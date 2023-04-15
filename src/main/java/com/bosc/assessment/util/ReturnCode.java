package com.bosc.assessment.util;

public enum ReturnCode {
    ILLEGAL_ARGUMENT("405", "illegal argument"),
    OK("200","ok");

    private String code;
    private String msg;
    ReturnCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
