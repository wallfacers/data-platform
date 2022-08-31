package com.wallfacers.data.platform.dao.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wallfacers.data.platform.enums.DeletedEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * Base DO
 *
 * @author wallfacers
 */
public class BaseDO implements Serializable {

    /**
     * 雪花id
     */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 删除标识
     */
    private DeletedEnum deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public DeletedEnum getDeleted() {
        return deleted;
    }

    public void setDeleted(DeletedEnum deleted) {
        this.deleted = deleted;
    }
}

