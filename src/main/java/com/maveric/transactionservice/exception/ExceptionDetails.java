package com.maveric.transactionservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@AllArgsConstructor
public class ExceptionDetails {
    private Date time;
    private String message;
    private String details;

}
