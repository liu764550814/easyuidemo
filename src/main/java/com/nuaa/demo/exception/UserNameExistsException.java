package com.nuaa.demo.exception;

public class UserNameExistsException extends Exception{
    public UserNameExistsException() {
        super();
    }

    public UserNameExistsException(String message) {
        super(message);
    }

    public UserNameExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNameExistsException(Throwable cause) {
        super(cause);
    }

    protected UserNameExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
