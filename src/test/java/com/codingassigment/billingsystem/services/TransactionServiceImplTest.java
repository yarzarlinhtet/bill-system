package com.codingassigment.billingsystem.services;

import com.codingassigment.billingsystem.controllers.Request.PaymentRequest;
import com.codingassigment.billingsystem.exceptions.BadRequestException;
import com.codingassigment.billingsystem.repositories.TransactionRepository;
import com.codingassigment.billingsystem.serviceImpls.TransactionServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles(value = "test")
public class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;


    @Mock
    private TransactionRepository transactionRepository;

    @Test
    void test_add_transaction_with_existing_refNo() {
        PaymentRequest paymentRequest = PaymentRequest.builder()
                .referenceNo("12345")
                .build();
        when(transactionRepository.existsByReferenceNo(any())).thenReturn(true);

        Assertions.assertThrows(BadRequestException.class, ()->{
            this.transactionService.pay(paymentRequest);
        });
    }
}
