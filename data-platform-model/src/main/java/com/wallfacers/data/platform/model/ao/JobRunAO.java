package com.wallfacers.data.platform.model.ao;

import java.io.Serializable;

/**
 * 运行任务 AO
 *
 * @author wallfacers
 */
public class JobRunAO implements Serializable {

    private static final long serialVersionUID = -4268562725316491144L;

    /**
     * 任务id
     */
    private Long id;

    /**
     * 任务代码
     */
    private String code;

    /**
     * 运行方式，sync为true标识同步运行，否则异步
     */
    private Boolean sync = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getSync() {
        return sync;
    }

    public void setSync(Boolean sync) {
        this.sync = sync;
    }
}
