package com.wallfacers.data.platform.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 任务状态
 *
 * @author wallfacers
 */
public enum JobStatusEnum {

    NOT_STARTED(0, "未运行"),

    WAIT(1, "等待"),

    RUNNING(2, "运行中"),

    SUCCESS(3, "成功"),

    ERROR(4, "失败"),

    STOP(5, "停止");

    @EnumValue
    private int status;

    private String name;

    JobStatusEnum(int status, String name) {
        this.status = status;
        this.name = name;
    }

    public static JobStatusEnum of(int status) {
        for (JobStatusEnum statusEnum : values()) {
            if (status == statusEnum.getStatus()) {
                return statusEnum;
            }
        }
        return null;
    }

    public static JobStatusEnum ofName(String name) {
        for (JobStatusEnum statusEnum : values()) {
            if (statusEnum.getName().equals(name)) {
                return statusEnum;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
