package com.simba.service.sender.exceptions;

/**
 * Created by shuoGG on 2018/7/24
 */
public class PushTypeException extends RuntimeException{
    public PushTypeException() {
    }

    public PushTypeException(String message) {
        super(message);
    }
}
