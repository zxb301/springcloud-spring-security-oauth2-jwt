package com.own.userserve.common.exception;

import lombok.Data;

@Data
public class InternalApiException extends Exception {

    private String code;
    private String message;

    public InternalApiException(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
