package com.example.userrev.advice;

import org.springframework.http.HttpStatus;

public class NotFoundException extends RuntimeException{



    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
