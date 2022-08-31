package com.wallfacers.data.platform.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wallfacers.data.platform.dao.model.JobDO;
import org.apache.ibatis.annotations.Param;

/**
 * 任务 Mapper
 *
 * @author wallfacers
 */
public interface JobMapper extends BaseMapper<JobDO> {

    /**
     * 通过任务id获取任务
     *
     * @param id id
     * @return 任务
     */
    JobDO findJobById(@Param("id") Long id);

}
