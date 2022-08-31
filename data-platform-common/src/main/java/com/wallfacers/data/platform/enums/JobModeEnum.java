package com.wallfacers.data.platform.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 任务模式
 *
 * @author wallfacers
 */
public enum JobModeEnum {

    /**
     * 脚本呢
     */
    SCRIPT(0, "脚本"),

    /**
     * 可配置
     */
    CONFIGURABLE(1, "可配置");

    @EnumValue
    private int mode;

    private String name;

    JobModeEnum(int mode, String name) {
        this.mode = mode;
        this.name = name;
    }

    public static JobModeEnum of(int jobMode) {
        for (JobModeEnum jobModeEnum : values()) {
            if (jobMode == jobModeEnum.getMode()) {
                return jobModeEnum;
            }
        }
        return null;
    }

    public static JobModeEnum ofName(String name) {
        for (JobModeEnum jobModeEnum : values()) {
            if (jobModeEnum.getName().equals(name)) {
                return jobModeEnum;
            }
        }
        return null;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
