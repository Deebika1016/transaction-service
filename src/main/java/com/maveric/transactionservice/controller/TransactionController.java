package com.maveric.transactionservice.controller;

import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.exception.TranscationNotFoundException;
import com.maveric.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("accounts/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactions(@Valid @PathVariable String accountId,
                                                                @RequestParam(defaultValue = "0") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) throws TranscationNotFoundException {
        List<TransactionDto> transactionResponse = transactionService.getTransactions(accountId,page,pageSize);
        if (transactionResponse.isEmpty()){
            throw new TranscationNotFoundException("Transactions Not Found");
        }else {
        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);}
    }

    @PostMapping("accounts/{accountId}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@Valid @PathVariable String accountId,
                                                            @RequestBody TransactionDto transactionDto)
                                                            {
        TransactionDto transactionResponse = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @GetMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionDetails(@Valid @PathVariable String accountId,
                                                                @PathVariable String transactionId) throws TranscationNotFoundException {
        TransactionDto transactionResponse = transactionService.getTransactionById(accountId,transactionId);
        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
    }

    @DeleteMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<String>deleteTransaction(@Valid @PathVariable String accountId,
                                                   @PathVariable String transactionId)
                                                   {
        transactionService.deleteTransaction(accountId,transactionId);
       return new ResponseEntity<>("Transaction Deleted Success fully",HttpStatus.OK);
    }
}
