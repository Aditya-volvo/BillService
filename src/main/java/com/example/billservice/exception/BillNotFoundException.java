package com.example.billservice.exception;

import org.springframework.stereotype.Component;

@Component
public class BillNotFoundException extends RuntimeException {
    public BillNotFoundException(String message) {
        super(message);
    }
}
