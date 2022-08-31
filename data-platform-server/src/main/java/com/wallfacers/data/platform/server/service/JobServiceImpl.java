package com.wallfacers.data.platform.server.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wallfacers.data.platform.dao.mapper.JobMapper;
import com.wallfacers.data.platform.dao.model.JobDO;
import com.wallfacers.data.platform.enums.DeletedEnum;
import com.wallfacers.data.platform.stub.service.job.JobService;
import org.springframework.stereotype.Service;

/**
 * 任务接口实现
 *
 * @author wallfacers
 */
@Service
public class JobServiceImpl extends ServiceImpl<JobMapper, JobDO> implements JobService {

    @Override
    public JobDO findJobById(Long id) {
        LambdaQueryWrapper<JobDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(JobDO::getId, id);
        queryWrapper.eq(JobDO::getDeleted, DeletedEnum.UNDELETED);
        return this.baseMapper.selectOne(queryWrapper);
    }

}
