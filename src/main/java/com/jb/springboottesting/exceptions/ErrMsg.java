package com.jb.springboottesting.exceptions;

import lombok.Getter;

/**
 * Created by kobis on 26 Jan, 2023
 */
@Getter
public enum ErrMsg {



    CAT_ID_NOT_FOUND("Some thing went wrong","Cat id not found",1660),
    CAT_ID_ALREADY_EXIST("Some thing went wrong","Cat id already exist",1923);

    private String userMessage;
    private String internalMessage;
    private long errCode;

    ErrMsg(String userMessage, String internalMessage, long errCode) {
        this.userMessage = userMessage;
        this.internalMessage = internalMessage;
        this.errCode = errCode;
    }
}
