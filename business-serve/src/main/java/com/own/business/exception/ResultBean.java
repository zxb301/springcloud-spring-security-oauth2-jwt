package com.own.business.exception;

import java.io.Serializable;

/**
 *
 */
public class ResultBean implements Serializable {
    /**
     * 成功失败的标识
     */
    protected boolean success = false;
    /**
     * 信息编号
     */
    protected String code;
    /**
     * 信息内容
     */
    protected String message = "操作失败！";


    /**
     * 数据内容
     */
    protected Object info;


    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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


}
