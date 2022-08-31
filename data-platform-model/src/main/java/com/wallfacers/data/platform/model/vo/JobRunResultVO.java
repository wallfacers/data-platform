package com.wallfacers.data.platform.model.vo;

import com.wallfacers.data.platform.enums.JobStatusEnum;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 运行任务结果集 VO
 *
 * @author wallfacers
 */
public class JobRunResultVO implements Serializable {

    private static final long serialVersionUID = -1024847267098671918L;

    private Long jobId;

    private Long uid;

    private JobStatusEnum jobStatusEnum;

    private List<String> runLogList = new ArrayList<>();

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public JobStatusEnum getJobStatusEnum() {
        return jobStatusEnum;
    }

    public void setJobStatusEnum(JobStatusEnum jobStatusEnum) {
        this.jobStatusEnum = jobStatusEnum;
    }


    public List<String> getRunLogList() {
        return runLogList;
    }

    public void setRunLogList(List<String> runLogList) {
        this.runLogList = runLogList;
    }
}
