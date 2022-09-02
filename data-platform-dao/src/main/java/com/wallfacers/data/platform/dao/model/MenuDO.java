package com.wallfacers.data.platform.dao.model;

/**
 * 菜单
 *
 * @author wallfacers
 */
public class MenuDO extends BaseDO {

    private static final long serialVersionUID = 7955332718178502589L;

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
}