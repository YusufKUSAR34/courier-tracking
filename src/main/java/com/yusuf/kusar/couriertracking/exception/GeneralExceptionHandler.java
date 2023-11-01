package com.yusuf.kusar.couriertracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GeneralExceptionHandler {
    @ExceptionHandler(TrackingCourierAtStoreNotFoundException.class)
    public ResponseEntity<?> handle(TrackingCourierAtStoreNotFoundException exception){
        return  new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}