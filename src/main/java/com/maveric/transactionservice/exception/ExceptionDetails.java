package com.maveric.transactionservice.exception;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionDetails {
    private Date time;
    private String message;
    private String details;

}
