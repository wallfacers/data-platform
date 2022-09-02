package com.wallfacers.data.platform.dao.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.wallfacers.data.platform.enums.JobModeEnum;

/**
 * 任务 DO
 *
 * @author wallfacers
 */
@TableName("tp_job")
public class JobDO extends BaseDO {

    private static final long serialVersionUID = 995787003370295609L;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务代码
     */
    private String jobCode;

    /**
     * 任务模式
     */
    private JobModeEnum jobMode;

    /**
     * 版本
     */
    @Version
    private Long version;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public JobModeEnum getJobMode() {
        return jobMode;
    }

    public void setJobMode(JobModeEnum jobMode) {
        this.jobMode = jobMode;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
