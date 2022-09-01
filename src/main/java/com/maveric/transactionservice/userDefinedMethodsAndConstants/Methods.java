package com.maveric.transactionservice.userDefinedMethodsAndConstants;

import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.model.Transaction;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Methods {
    private Methods() {
    }

    public static LocalDateTime getCurrentDateTime() {
        return (java.time.LocalDateTime.now());
    }
    public static Transaction toModel(TransactionDto transactionDto){
        Transaction transaction = new Transaction();
        transaction.setAccountId(transactionDto.getAccountId());
        transaction.set_id(transactionDto.get_id());
        transaction.setAmount(transactionDto.getAmount());
        transaction.setType(transactionDto.getType());
        transaction.setCreatedAt(transactionDto.getCreatedAt());

        return transaction;
    }

    public static TransactionDto dto(Transaction transaction){
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountId(transaction.getAccountId());
        transactionDto.set_id(transaction.get_id());
        transactionDto.setAmount(transaction.getAmount());
        transactionDto.setType(transaction.getType());
        transactionDto.setCreatedAt(transaction.getCreatedAt());

        return transactionDto;
    }
}