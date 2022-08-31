package com.wallfacers.data.platform.web.controller;

import com.wallfacers.data.platform.common.AbstractCopyUtils;
import com.wallfacers.data.platform.model.ao.JobRunAO;
import com.wallfacers.data.platform.model.vo.JobRunResultVO;
import com.wallfacers.data.platform.server.manager.JobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public JobRunResultVO run(@RequestBody JobRunAO jobRunAO) {
        return AbstractCopyUtils.copy(jobManager.run(jobRunAO), JobRunResultVO.class);
    }


    /**
     * 获取任务运行日志
     *
     * @param jobId 任务id
     * @return 任务运行日志
     */
    @GetMapping("/log")
    public JobRunResultVO getLog(@RequestParam("jobId") Long jobId) {
        return AbstractCopyUtils.copy(jobManager.getLog(jobId), JobRunResultVO.class);
    }

}
