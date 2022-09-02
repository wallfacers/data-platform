package com.wallfacers.data.platform.model.bo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wallfacers.data.platform.enums.DeletedEnum;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * 菜单 BO
 *
 * @author wallfacers
 */
public class MenuBO implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * pid
     */
    private Long pid;

    /**
     * 标题
     */
    private String title;

    /**
     * 图标
     */
    private String icon;

    /**
     * 链接
     */
    private String href;

    /**
     * 链接打开方式
     */
    private String target;

    /**
     * 排序方式
     */
    private Integer sort;

    /**
     * 状态，是否启用
     */
    private Boolean status;

    /**
     * 描述
     */
    private String remark;

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

    /**
     * 菜单列表
     */
    private Collection<MenuBO> childList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    public Collection<MenuBO> getChildList() {
        return childList;
    }

    public void setChildList(Collection<MenuBO> childList) {
        this.childList = childList;
    }
}
