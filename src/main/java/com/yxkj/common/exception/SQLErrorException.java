package com.yxkj.common.exception;

public class SQLErrorException extends Exception{

    public SQLErrorException() {
        super();
    }

    public SQLErrorException(String message) {
        super(message);
    }

    public SQLErrorException(String message, Throwable cause) {
        super(message, cause);
    }


    public SQLErrorException(Throwable cause) {
        super(cause);
    }
}
