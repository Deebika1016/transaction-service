package com.maveric.transactionservice.service;

import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.exception.TranscationNotFoundException;
import com.maveric.transactionservice.model.Transaction;
import com.maveric.transactionservice.repository.TransactionRepository;
import com.maveric.transactionservice.userDefinedMethodsAndConstants.Methods;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

import java.util.ArrayList;
import java.util.List;

import static com.maveric.transactionservice.userDefinedMethodsAndConstants.Methods.dto;

@Service
public class TransactionServiceImp implements TransactionService{
    @Autowired
     TransactionRepository repository;
    String exception ="Transaction Not Found";
    @Override
    public List<TransactionDto> getTransactions(@NotNull String accountId, Integer page, Integer pageSize) throws TranscationNotFoundException {
        Page<Transaction> transactions = repository.findAll(PageRequest.of(page, pageSize));
        List<TransactionDto> transactionDto = new ArrayList<>();
        if (accountId.isEmpty()) {
            throw new TranscationNotFoundException(exception);
        } else {
            for (Transaction a : transactions) {
                if (a.getAccountId().contentEquals(accountId)) {
                    transactionDto.add(dto(a));
                   }

            }
        } return transactionDto;}


    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) throws HttpServerErrorException.InternalServerError {
       Transaction transaction = new Transaction();

       transaction.set_id(transactionDto.get_id());
       transaction.setAccountId(transactionDto.getAccountId());
       transaction.setAmount(transactionDto.getAmount());
       transaction.setType(transactionDto.getType());
       transaction.setCreatedAt(String.valueOf(Methods.getCurrentDateTime()));
       repository.save(transaction);
      return  dto(transaction);
    }

    @Override
    public TransactionDto getTransactionById(String accountDtoId, String transactionDtoId) throws TranscationNotFoundException{
        Transaction response = repository.findById(transactionDtoId).orElseThrow(() -> new TranscationNotFoundException(exception));
        if(response.getAccountId().contentEquals(accountDtoId)){
       return dto(response);}else{throw new TranscationNotFoundException(exception);}
       }

    @Override
    public void deleteTransaction(String accountId,String transactionDtoId) throws TranscationNotFoundException {
        Transaction transaction = repository.findById(transactionDtoId).orElseThrow(() ->new TranscationNotFoundException("Transaction Not Found"));
        if (transaction.getAccountId().contains(accountId)){
            repository.deleteById(transactionDtoId);
        }else { throw new TranscationNotFoundException(exception);}
    }

}
