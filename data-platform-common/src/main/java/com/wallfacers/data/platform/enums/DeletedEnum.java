package com.wallfacers.data.platform.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 任务模式
 *
 * @author wallfacers
 */
public enum DeletedEnum {

    /**
     * 未删除
     */
    UNDELETED(0, "未删除"),

    /**
     * 已删除
     */
    DELETED(1, "已删除");

    @EnumValue
    private int code;

    private String name;

    DeletedEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static DeletedEnum of(int code) {
        for (DeletedEnum deletedEnum : values()) {
            if (code == deletedEnum.getCode()) {
                return deletedEnum;
            }
        }
        return null;
    }

    public static DeletedEnum ofName(String name) {
        for (DeletedEnum deletedEnum : values()) {
            if (deletedEnum.getName().equals(name)) {
                return deletedEnum;
            }
        }
        return null;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
