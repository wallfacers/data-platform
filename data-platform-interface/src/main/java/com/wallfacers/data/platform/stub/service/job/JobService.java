package com.wallfacers.data.platform.stub.service.job;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wallfacers.data.platform.dao.model.JobDO;

/**
 * 任务接口
 *
 * @author wallfacers
 */
public interface JobService extends IService<JobDO> {

    /**
     * 通过任务id查询任务
     *
     * @param id 任务id
     * @return 查询任务
     */
    JobDO findJobById(Long id);

}
