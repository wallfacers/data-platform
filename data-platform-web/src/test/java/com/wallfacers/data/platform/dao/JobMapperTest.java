package com.wallfacers.data.platform.dao;

import com.wallfacers.data.platform.DataPlatformWebApplicationTests;
import com.wallfacers.data.platform.common.AbstractCopyUtils;
import com.wallfacers.data.platform.dao.mapper.JobMapper;
import com.wallfacers.data.platform.dao.model.JobDO;
import com.wallfacers.data.platform.enums.JobModeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 测试JobMapper
 *
 * @see JobMapper
 * @author wallfacers
 */
@SpringBootTest(classes = DataPlatformWebApplicationTests.class)
public class JobMapperTest {

    @Autowired
    private JobMapper jobMapper;

    @Test
    public void testGet() {
        JobDO job = jobMapper.findJobById(2178833377792000L);
        System.out.println(AbstractCopyUtils.GSON.toJson(job));
    }

    @Test
    public void tetAdd() {
        JobDO job = new JobDO();
        job.setJobMode(JobModeEnum.SCRIPT);
        job.setJobName("test_datax_job_2");
        job.setJobCode("{\"job\":{\"content\":[{\"reader\":{\"name\":\"streamreader\",\"parameter\":{\"sliceRecordCount\":10,\"column\":[{\"type\":\"long\",\"value\":\"10\"},{\"type\":\"string\",\"value\":\"世界你好\"}]}},\"writer\":{\"name\":\"streamwriter\",\"parameter\":{\"encoding\":\"UTF-8\",\"print\":true}}}],\"setting\":{\"speed\":{\"channel\":5}}}}");
        int result = jobMapper.insert(job);
        System.out.println(result);
    }


    @Test
    public void tetUpdate() {
        JobDO job = new JobDO();
        job.setId(1563546989740605441L);
        job.setJobName("test_datax_job_5");
        int result = jobMapper.updateById(job);
        System.out.println(result);
    }

}
