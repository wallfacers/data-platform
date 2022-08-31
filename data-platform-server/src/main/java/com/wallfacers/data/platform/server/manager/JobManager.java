package com.wallfacers.data.platform.server.manager;

import com.google.common.base.Throwables;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.wallfacers.data.platform.common.SnowflakeIdWorker;
import com.wallfacers.data.platform.dao.model.JobDO;
import com.wallfacers.data.platform.enums.JobStatusEnum;
import com.wallfacers.data.platform.model.ao.JobRunAO;
import com.wallfacers.data.platform.model.bo.JobRunResultBO;
import com.wallfacers.data.platform.stub.service.datax.DataxServiceBuilder;
import com.wallfacers.data.platform.stub.service.datax.DataxServiceGrpc;
import com.wallfacers.data.platform.stub.service.job.JobService;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Objects;

/**
 * 任务 Manager
 *
 * @author wallfacers
 */
@Service
public class JobManager {

    private static final LoadingCache<Long, JobRunResultBO> JOB_RUN_STATUS_CACHE = CacheBuilder.newBuilder()
            // key有效时间
            .expireAfterAccess(Duration.ofMinutes(20))
            .build(
                    new CacheLoader<Long, JobRunResultBO>() {
                        @Override
                        public JobRunResultBO load(Long key) {
                            JobRunResultBO jobRunResultBO = new JobRunResultBO();
                            jobRunResultBO.setUid(key);
                            return jobRunResultBO;
                        }
                    }
            );

    private static final SnowflakeIdWorker SNOW_FLAKE_ID_WORKER = new SnowflakeIdWorker(1, 1);

    private final DataxServiceGrpc.DataxServiceStub dataxServiceStub;

    private final JobService jobService;

    public JobManager(DataxServiceGrpc.DataxServiceStub dataxServiceStub, JobService jobService) {
        this.dataxServiceStub = dataxServiceStub;
        this.jobService = jobService;
    }

    public JobRunResultBO run(JobRunAO jobRun) {

        // 表示同步运行
        boolean isSync = Objects.nonNull(jobRun.getSync()) && jobRun.getSync();

        JobDO jobDO = jobService.findJobById(jobRun.getId());
        if (Objects.isNull(jobDO)) {
            throw new RuntimeException("任务没有找到");
        }

        String code = StringUtils.hasText(jobRun.getCode()) ? jobRun.getCode() : jobDO.getJobCode();
        DataxServiceBuilder.RunRequest runRequest = DataxServiceBuilder.RunRequest
                .newBuilder().setJobId(jobDO.getId()).setCode(code).build();

        JobRunResultBO jobRunResultBO = new JobRunResultBO();
        jobRunResultBO.setJobId(jobDO.getId());

        // 等待uid
        dataxServiceStub.run(runRequest, new StreamObserver<DataxServiceBuilder.RunResponse>() {
            @Override
            public void onNext(DataxServiceBuilder.RunResponse runResponse) {
                // 存储
                JobRunResultBO jobRunResultBO = JOB_RUN_STATUS_CACHE.getIfPresent(runResponse.getJobId());
                if (Objects.isNull(jobRunResultBO)) {
                    jobRunResultBO = new JobRunResultBO();
                }
                jobRunResultBO.setJobId(runResponse.getJobId());
                jobRunResultBO.setUid(runResponse.getUid());
                jobRunResultBO.getRunLogList().add(runResponse.getMessage());
                jobRunResultBO.setJobStatusEnum(JobStatusEnum.of(runResponse.getStatus()));
                JOB_RUN_STATUS_CACHE.put(runResponse.getJobId(), jobRunResultBO);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("发生错误：" + Throwables.getStackTraceAsString(throwable));
            }

            @Override
            public void onCompleted() {
                System.out.println("调用完成");
            }
        });

        return jobRunResultBO;
    }

    public JobRunResultBO getLog(Long jobId) {
        return JOB_RUN_STATUS_CACHE.getIfPresent(jobId);
    }

}
