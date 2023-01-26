package com.jb.springboottesting.exceptions;

/**
 * Created by kobis on 26 Jan, 2023
 */
public class ErrUtils {

    public static CatSystemException notFound() {
        return new CatSystemException(ErrMsg.CAT_ID_NOT_FOUND);
    }
}
