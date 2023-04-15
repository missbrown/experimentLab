package com.bosc.assessment.util;

public class BusinessException extends RuntimeException {

    public BusinessException() {}
    public BusinessException(ReturnCode returnCode) {
        super(returnCode.getMsg());
    }
    public BusinessException(String msg) {
        super(msg);
    }
}
