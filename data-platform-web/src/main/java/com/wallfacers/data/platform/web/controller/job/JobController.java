package com.wallfacers.data.platform.web.controller.job;

import com.wallfacers.data.platform.model.ao.JobRunAO;
import com.wallfacers.data.platform.model.vo.JobRunResultVO;
import com.wallfacers.data.platform.model.vo.ResponseVO;
import com.wallfacers.data.platform.server.manager.JobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.wallfacers.data.platform.common.AbstractCopyUtils.copy;

/**
 * 任务 Controller
 *
 * @author wallfacers
 */
@RestController
@RequestMapping("/v1/api/data/platform/job")
public class JobController {

    @Autowired
    private JobManager jobManager;

    /**
     * 运行任务
     *
     * @param jobRunAO 运行任务请求参数
     * @return 运行任务结果集
     */
    @PostMapping("/run")
    public ResponseVO<JobRunResultVO> run(@RequestBody JobRunAO jobRunAO) {
        return ResponseVO.success(copy(jobManager.run(jobRunAO), JobRunResultVO.class));
    }


    /**
     * 获取任务运行日志
     *
     * @param jobId 任务id
     * @return 任务运行日志
     */
    @GetMapping("/log")
    public ResponseVO<JobRunResultVO> log(@RequestParam("jobId") Long jobId) {
        return ResponseVO.success(copy(jobManager.getLog(jobId), JobRunResultVO.class));
    }

}
