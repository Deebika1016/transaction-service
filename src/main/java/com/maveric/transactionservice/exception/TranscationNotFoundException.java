package com.maveric.transactionservice.exception;

public class TranscationNotFoundException extends RuntimeException{

    public TranscationNotFoundException(String message) {
        super(message);
    }
}
