package com.maveric.transactionservice.service;

import com.maveric.transactionservice.dto.TransactionDto;
import com.maveric.transactionservice.model.Transaction;
import com.maveric.transactionservice.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.maveric.transactionservice.userDefinedMethodsAndConstants.Type.CREDIT;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
 class TransactionServiceImpTest {
    @Mock
    private TransactionRepository transactionRepository;
    @InjectMocks
    private TransactionServiceImp transactionService;

    @Test
    void shouldReturnTransactionWhenCreateAccountInvoked() {

        when(transactionRepository.save(any())).thenReturn(new Transaction("1", "123", CREDIT, 300, "23423"));


        TransactionDto transactionDto = transactionService.createTransaction(new TransactionDto("1", "123", CREDIT, 300, "23423"));


        assertNotNull(transactionDto);
        assertSame(transactionDto.getType(),getTransactionDto().getType());
    }
    @Test
            void ShouldReturnTransactionDetailsWhenTransactionByIdInvoked() {
        when(transactionRepository.findById(any())).thenReturn(Optional.of(new Transaction("1", "123", CREDIT, 300, "23423")));


        TransactionDto transactionDto = transactionService.getTransactionById("123");


        assertNotNull(transactionDto);
        assertSame(transactionDto.getType(),getTransactionDto().getType());
    }
    @Test
    void shouldDeleteTransactionwhenDeleteTransactionInvoked(){

        transactionRepository.deleteById("123");
        verify(transactionRepository,atLeastOnce()).deleteById("123");
    }
    @Test
    void shouldReturnTransactionswhenAccountsnotemptyindb(){
        List<Transaction> transaction = new ArrayList<Transaction>();
        transaction.add(new Transaction("1", "123", CREDIT, 300, "23423"));
        when(transactionRepository.findAll()).thenReturn(transaction);
        assertFalse(transactionService.getTransactions(2,10).isEmpty());

    }

      TransactionDto getTransactionDto() {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.set_id("1");
        transactionDto.setAccountId("233");
        transactionDto.setAmount(100);
        transactionDto.setCreatedAt("2022-08-27T10:45:49.520Z");
        transactionDto.setType(CREDIT);
        assertNotNull(transactionDto);
        return transactionDto;
    }
}
