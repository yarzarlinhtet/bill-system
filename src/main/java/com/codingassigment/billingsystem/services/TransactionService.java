package com.codingassigment.billingsystem.services;

import com.codingassigment.billingsystem.controllers.Request.PaymentRequest;
import com.codingassigment.billingsystem.controllers.Response.TransactionCreateResponse;
import com.codingassigment.billingsystem.controllers.Response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionCreateResponse pay(PaymentRequest paymentRequest);

    List<TransactionResponse> list(String id);
}
