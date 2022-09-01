package com.maveric.transactionservice.service;
import com.maveric.transactionservice.dto.TransactionDto;

import java.util.List;

public interface TransactionService {
    public List<TransactionDto> getTransactions(Integer page,Integer pageSize);
    public TransactionDto createTransaction(TransactionDto transactionDto);
    public TransactionDto getTransactionById(String transactionDtoId);
    public String deleteTransaction(String transactionDtoId);
}
