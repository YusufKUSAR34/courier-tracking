package com.yusuf.kusar.couriertracking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.FOUND)
public class TrackingCourierAtStoreNotFoundException extends RuntimeException{
    public TrackingCourierAtStoreNotFoundException(String message) {
        super(message);
    }
}
