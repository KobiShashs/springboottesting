package com.jb.springboottesting.exceptions;

/**
 * Created by kobis on 26 Jan, 2023
 */
public class CatSystemException extends Exception {

    private String userMessage;
    private long errorCode;

    public CatSystemException(ErrMsg errMsg) {
        super(errMsg.getInternalMessage());
        this.userMessage = errMsg.getUserMessage();
        this.errorCode = errMsg.getErrCode();
    }
}
