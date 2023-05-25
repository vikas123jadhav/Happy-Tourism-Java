package com.tourism.happytourism.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


//@ResponseStatus(value = HttpStatus.IM_USED)
public class UsernameAlreadyExists extends Exception {

    public UsernameAlreadyExists(String message) {
        super(message);
    }
}