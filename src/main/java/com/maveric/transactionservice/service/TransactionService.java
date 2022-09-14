package com.maveric.transactionservice.service;

import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.exception.TranscationNotFoundException;

import java.util.List;

public interface TransactionService {
     List<TransactionDto> getTransactions(String accountId,Integer page,Integer pageSize) throws TranscationNotFoundException;
     TransactionDto createTransaction(TransactionDto transactionDto);
     TransactionDto getTransactionById(String accountDtoId,String transactionDtoId) throws TranscationNotFoundException;
    void deleteTransaction(String accountId,String transactionDtoId) throws TranscationNotFoundException;
}
