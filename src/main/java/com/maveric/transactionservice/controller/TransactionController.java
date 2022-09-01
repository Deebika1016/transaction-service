package com.maveric.transactionservice.controller;
import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.model.Transaction;
import com.maveric.transactionservice.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("accounts/{accountId}/transactions")
    public ResponseEntity<List<TransactionDto>> getTransactions(@PathVariable String accountDtoId, @RequestParam(defaultValue = "0") Integer page,
                                                                @RequestParam(defaultValue = "10") Integer pageSize) {
        List<TransactionDto> transactionResponse = transactionService.getTransactions(page,pageSize);
        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
    }

    @PostMapping("accounts/{accountId}/transactions")
    public ResponseEntity<TransactionDto> createTransaction(@PathVariable String accountDtoId, @RequestBody TransactionDto transactionDto) {
        TransactionDto transactionResponse = transactionService.createTransaction(transactionDto);
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }

    @GetMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<TransactionDto> getTransactionDetails(@PathVariable String accountDtoId,@PathVariable String transactionDtoId) {
        TransactionDto transactionResponse = transactionService.getTransactionById(transactionDtoId);
        return new ResponseEntity<>(transactionResponse, HttpStatus.OK);
    }

    @DeleteMapping("accounts/{accountId}/transactions/{transactionId}")
    public ResponseEntity<String> deleteTransaction(@PathVariable String accountId,@PathVariable String transactionDtoId) {
        String response = transactionService.deleteTransaction(transactionDtoId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
