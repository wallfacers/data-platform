package com.wallfacers.data.platform.model.vo;

import java.io.Serializable;

/**
 * 返回接口 VO
 *
 * @author wallfacers
 */
public class ResponseVO<T> implements Serializable {

    private static final String SUCCESS_CODE = "000000";

    private static final String ERROR_CODE = "999999";

    private String code;

    private String message;

    private T data;

    public ResponseVO() {
    }

    public ResponseVO(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseVO(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseVO(String code, T data) {
        this.code = code;
        this.data = data;
    }


    public static <T> ResponseVO<T> success(T data) {
        return new ResponseVO<>(SUCCESS_CODE, data);
    }

    public static <T> ResponseVO<T> error(String message) {
        return new ResponseVO<>(ERROR_CODE, message);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
