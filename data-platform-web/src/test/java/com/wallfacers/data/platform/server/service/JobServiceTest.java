package com.wallfacers.data.platform.server.service;


import com.wallfacers.data.platform.DataPlatformWebApplicationTests;
import com.wallfacers.data.platform.common.AbstractCopyUtils;
import com.wallfacers.data.platform.dao.model.JobDO;
import com.wallfacers.data.platform.stub.service.job.JobService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 任务 Service
 *
 * @author wallfacers
 */
@SpringBootTest(classes = DataPlatformWebApplicationTests.class)
public class JobServiceTest {

    @Autowired
    private JobService jobService;

    @Test
    public void testFindJobById() {
        JobDO jobDO = jobService.findJobById(1563546989740605441L);
        System.out.println(AbstractCopyUtils.GSON.toJson(jobDO));
    }

}
