package com.wallfacers.data.platform.executor.service;

import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinNT;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import com.wallfacers.data.platform.common.NamedThreadFactory;
import com.wallfacers.data.platform.common.SnowflakeIdWorker;
import com.wallfacers.data.platform.enums.JobStatusEnum;
import com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder;
import com.wallfacers.data.platform.stub.service.datax.DataxServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * datax service impl
 *
 * @author wsz
 */
public class DataxServiceImpl extends DataxServiceGrpc.DataxServiceImplBase {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataxServiceImpl.class);

    /**
     * 目前写死
     */
    private static final String DATAX_PY_SHELL_HOME = "python D:/software/development/java/source/DataX/target/datax/datax/bin/datax.py ";

    private static final SnowflakeIdWorker SNOW_FLAKE_ID_WORKER = new SnowflakeIdWorker(0, 0);

    private static final LoadingCache<String, Long> PID_CACHE = CacheBuilder.newBuilder()
            // key有效时间
            .expireAfterAccess(Duration.ofHours(12))
            .build(
                    new CacheLoader<String, Long>() {
                        @Override
                        public Long load(String key) {
                            return Long.parseLong(key);
                        }
                    }
            );

    private static final ExecutorService RUN_JOB_HANDLER_LOG_POOL = new ThreadPoolExecutor(
            Runtime.getRuntime().availableProcessors() + 1,
            Runtime.getRuntime().availableProcessors() + 1,
            0L, TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(1000), new NamedThreadFactory("run-job-handler-log-pool-"));

    @Override
    public void run(DataxServiceBuilder.RunRequest request, StreamObserver<DataxServiceBuilder.RunResponse> responseObserver) {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        String terminal = isWindows ? "cmd" : "/bash/sh";
        String cmd = isWindows ? "/c" : "-c";


        long uid = SNOW_FLAKE_ID_WORKER.nextId();

        String fileName = String.valueOf(uid);
        // 将datax文件内容实例化当前目录，后续删除
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            byte[] bytes = request.getCode().getBytes(StandardCharsets.UTF_8);
            fileOutputStream.write(bytes, 0, bytes.length);
        } catch (IOException e) {
            DataxServiceBuilder.RunResponse errorResponse = DataxServiceBuilder.RunResponse.newBuilder()
                    .setJobId(request.getJobId())
                    .setUid(uid)
                    .setStatus(JobStatusEnum.ERROR.getStatus())
                    .setMessage(Throwables.getStackTraceAsString(e)).build();
            responseObserver.onNext(errorResponse);
            responseObserver.onCompleted();

            LOGGER.error("failed to store files, cause: {}", Throwables.getStackTraceAsString(e));
        }

        try {
            Process process = Runtime.getRuntime().exec(
                    new String[]{terminal, cmd, DATAX_PY_SHELL_HOME + fileName});

            PID_CACHE.put(String.valueOf(uid), getPid(process));

            RUN_JOB_HANDLER_LOG_POOL.execute(new HandleProcessLog(process, request.getJobId(), uid, responseObserver));

        } catch (Exception e) {
            LOGGER.error("failure to execute a job, cause: {}", Throwables.getStackTraceAsString(e));
        }
    }

    @Override
    public void stop(DataxServiceBuilder.StopRequest request, StreamObserver<DataxServiceBuilder.StopResponse> responseObserver) {
        try {
            Long pid = PID_CACHE.getIfPresent(String.valueOf(request.getUid()));
            // 标识pid不存在
            if (Objects.isNull(pid)) {
                throw new RuntimeException("PID未找到");
            }

            if (-1L == pid) {
                throw new RuntimeException("任务未运行");
            }

            this.stop(pid);
            DataxServiceBuilder.StopResponse errorStopResponse = DataxServiceBuilder.StopResponse
                    .newBuilder().setStatus(JobStatusEnum.STOP.getStatus())
                    .setUid(request.getUid()).build();
            responseObserver.onNext(errorStopResponse);
        } catch (Exception e) {
            LOGGER.error("failed to Stop a task, cause: {}", Throwables.getStackTraceAsString(e));
            DataxServiceBuilder.StopResponse errorStopResponse = DataxServiceBuilder.StopResponse
                    .newBuilder().setStatus(JobStatusEnum.ERROR.getStatus())
                    .setUid(request.getUid()).build();
            responseObserver.onNext(errorStopResponse);
            responseObserver.onError(e);
        } finally {
            PID_CACHE.invalidate(String.valueOf(request.getUid()));
            responseObserver.onCompleted();
        }
    }

    private long getPid(Process process) {
        long result = -1;
        try {
            //for windows
            if (process.getClass().getName().equals("java.lang.Win32Process") ||
                    process.getClass().getName().equals("java.lang.ProcessImpl")) {
                Field f = process.getClass().getDeclaredField("handle");
                f.setAccessible(true);
                long handle = f.getLong(process);
                Kernel32 kernel = Kernel32.INSTANCE;
                WinNT.HANDLE hand = new WinNT.HANDLE();
                hand.setPointer(Pointer.createConstant(handle));
                result = kernel.GetProcessId(hand);
                f.setAccessible(false);
            }
            //for unix based operating systems
            else if (process.getClass().getName().equals("java.lang.UNIXProcess")) {
                Field f = process.getClass().getDeclaredField("pid");
                f.setAccessible(true);
                result = f.getLong(process);
                f.setAccessible(false);
            }
        }
        catch(Exception ex) {
            result = -1;
        }
        return result;
    }

    private void stop(long pid) throws Exception {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        String terminal = isWindows ? "cmd" : "/bash/sh";
        String cmd = isWindows ? "/c" : "-c";

        if (isWindows) {
            Runtime.getRuntime().exec(new String[]{terminal, cmd, " taskkill /PID " + pid + " /F /T "});
        }
        else {
            Runtime.getRuntime().exec(new String[]{terminal, cmd, " kill -9 " + pid});
        }
    }

    public static class HandleProcessLog implements Runnable{

        private final Process process;

        private final Long jobId;

        private final Long uid;

        private final StreamObserver<DataxServiceBuilder.RunResponse> responseObserver;

        public HandleProcessLog(Process process,
                                Long jobId,
                                Long uid,
                                StreamObserver<DataxServiceBuilder.RunResponse> responseObserver){
            this.process = process;
            this.jobId = jobId;
            this.uid = uid;
            this.responseObserver = responseObserver;
        }
        @Override
        public void run() {
            InputStream inputStream = process.getInputStream();
            byte[] b = new byte[100];
            try {
                while(inputStream.read(b) !=-1){
                    DataxServiceBuilder.RunResponse errorResponse = DataxServiceBuilder.RunResponse.newBuilder()
                            .setJobId(jobId)
                            .setUid(uid)
                            .setStatus(JobStatusEnum.RUNNING.getStatus())
                            .setMessage(new String(b, StandardCharsets.UTF_8)).build();
                    responseObserver.onNext(errorResponse);
                }

                int status = process.exitValue() == 0 ? JobStatusEnum.SUCCESS.getStatus()
                        : JobStatusEnum.ERROR.getStatus();
                DataxServiceBuilder.RunResponse errorResponse = DataxServiceBuilder.RunResponse.newBuilder()
                        .setJobId(jobId)
                        .setUid(uid)
                        .setStatus(status)
                        .build();
                responseObserver.onNext(errorResponse);

            } catch (IOException e) {
                LOGGER.error("description Failed to obtain logs, cause: {}", Throwables.getStackTraceAsString(e));
                DataxServiceBuilder.RunResponse errorResponse = DataxServiceBuilder.RunResponse.newBuilder()
                        .setJobId(jobId)
                        .setUid(uid)
                        .setStatus(JobStatusEnum.ERROR.getStatus())
                        .setMessage(Throwables.getStackTraceAsString(e)).build();
                responseObserver.onNext(errorResponse);
            } finally {
                // 删除Pid缓存
                PID_CACHE.invalidate(String.valueOf(this.uid));
                responseObserver.onCompleted();
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOGGER.error("description Failed to obtain logs, cause: {}", Throwables.getStackTraceAsString(e));
                }

                // 删除本地文件
                File file = new File(String.valueOf(uid));
                if (file.exists() && !file.delete()) {
                    LOGGER.error("Failed to delete a file, fileName: {}", jobId);
                }
            }

        }
    }
}

