package com.wallfacers.data.platform.model.query;

import java.io.Serializable;

/**
 * 任务Query
 *
 * @author wallfacers
 */
public class JobQuery implements Serializable {

    /**
     * 任务id
     */
    private Long id;

    /**
     * 是否删除
     */
    private Boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}
