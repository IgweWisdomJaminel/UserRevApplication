package com.example.userrev.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NotFoundException.class)
    public Map<String,String>notFoundException(NotFoundException ex){
        Map<String, String>erx= new HashMap<>();
      return Map.of("message:", ex.getMessage());
    }

    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<Object>invalidArgumentHandler(InvalidArgumentException ex){
        Exception exception = new Exception(ex.getMessage(),ex.getCause(),HttpStatus.OK);
        return new ResponseEntity<>(exception,HttpStatus.OK);
    }
}
