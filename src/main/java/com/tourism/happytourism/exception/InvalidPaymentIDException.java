package com.tourism.happytourism.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class InvalidPaymentIDException extends Exception {


    public InvalidPaymentIDException(String message) {
        super(message);
    }
}
