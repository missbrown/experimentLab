package com.bosc.assessment.dto;

import com.bosc.assessment.util.ReturnCode;

public class ResponseDto<T> {
    private T data;
    private String code;
    private String msg;
    private Integer length;

    public void success() {
        setCode(ReturnCode.OK.getCode());
        setMsg(ReturnCode.OK.getMsg());
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
