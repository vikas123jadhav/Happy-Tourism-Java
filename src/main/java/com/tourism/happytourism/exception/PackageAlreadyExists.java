package com.tourism.happytourism.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.IM_USED)
public class PackageAlreadyExists extends Exception {
    public PackageAlreadyExists(String message) {
        super(message);
    }
}