package com.feeltech.appbee.exceptionHander;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NotFoundException(String msg) {
    }
}
