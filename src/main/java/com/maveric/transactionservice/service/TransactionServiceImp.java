package com.maveric.transactionservice.service;
import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.exception.TranscationNotFoundException;
import com.maveric.transactionservice.model.Transaction;
import com.maveric.transactionservice.repository.TransactionRepository;
import com.maveric.transactionservice.userDefinedMethodsAndConstants.Methods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.maveric.transactionservice.userDefinedMethodsAndConstants.Methods.dto;
import static com.maveric.transactionservice.userDefinedMethodsAndConstants.Methods.getCurrentDateTime;

@Service
public class TransactionServiceImp implements TransactionService{
    @Autowired
    private TransactionRepository repository;
    @Override
    public List<TransactionDto> getTransactions(Integer page,Integer pageSize) {
        Page<Transaction> transactions=repository.findAll(PageRequest.of(page,pageSize));
        List<TransactionDto> transactionDto= new ArrayList<>();
        for (Transaction a:transactions){
            transactionDto.add(dto(a));
        }
        return transactionDto;

    }
    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
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
    public TransactionDto getTransactionById(String transactionDtoId) {
        Transaction transactionResponse=repository.findById(transactionDtoId).orElseThrow(() -> new TranscationNotFoundException("Transaction not found"));
        return dto(transactionResponse);
    }

    @Override
    public String deleteTransaction(String transactionDtoId) {
        repository.deleteById(transactionDtoId);
        return "Transaction deleted successfully.";
    }



}
