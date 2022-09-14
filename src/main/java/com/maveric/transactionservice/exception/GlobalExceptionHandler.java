package com.maveric.transactionservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> exception(Exception exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(),exception.getMessage(),request.getDescription(true));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<ExceptionDetails> methodNotAllowedException(MethodNotAllowedException exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ExceptionDetails> badRequest(MethodNotAllowedException exception, WebRequest request){
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TranscationNotFoundException.class)

    public ResponseEntity<ExceptionDetails> transactionNotFound(TranscationNotFoundException exception, WebRequest request) {
        ExceptionDetails exceptionDetails = new ExceptionDetails(new Date(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }}
