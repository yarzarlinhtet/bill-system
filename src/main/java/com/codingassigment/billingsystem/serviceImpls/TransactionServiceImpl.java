package com.codingassigment.billingsystem.serviceImpls;

import com.codingassigment.billingsystem.controllers.Request.PaymentRequest;
import com.codingassigment.billingsystem.controllers.Response.TransactionCreateResponse;
import com.codingassigment.billingsystem.controllers.Response.TransactionResponse;
import com.codingassigment.billingsystem.exceptions.BadRequestError;
import com.codingassigment.billingsystem.exceptions.BadRequestException;
import com.codingassigment.billingsystem.models.Bill;
import com.codingassigment.billingsystem.models.Transaction;
import com.codingassigment.billingsystem.repositories.BillRepository;
import com.codingassigment.billingsystem.repositories.TransactionRepository;
import com.codingassigment.billingsystem.services.TransactionService;
import com.codingassigment.billingsystem.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

    private final TransactionRepository transactionRepository;

    private final BillRepository billRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, BillRepository billRepository) {
        this.transactionRepository = transactionRepository;
        this.billRepository = billRepository;
    }

    @Override
    public TransactionCreateResponse pay(PaymentRequest paymentRequest) {
        if (this.transactionRepository.existsByReferenceNo(paymentRequest.getReferenceNo())) {
            throw new BadRequestException(String.format("Reference Number %s is already exists", paymentRequest.getReferenceNo()),
                    BadRequestError.builder()
                            .statusMessage(String.format("Reference Number %s is already exists", paymentRequest.getReferenceNo()))
                            .build());
//            return TransactionCreateResponse.builder()
//                    .statusMessage()
//                    .build();
        }
        Optional<Bill> bill = this.billRepository.findById(paymentRequest.getId());
        if (bill.isEmpty()) {
            throw new BadRequestException(String.format("Bill Id %s is not exists", paymentRequest.getId()),
                    BadRequestError.builder()
                            .statusMessage(String.format("Bill Id %s is not exists", paymentRequest.getId()))
                            .build());
        }

        Transaction transaction = this.transactionRepository.save(
                Transaction.builder()
                        .apiCaller(paymentRequest.getApiCaller())
                        .bill(bill.get())
                        .amount(paymentRequest.getAmount())
                        .referenceNo(paymentRequest.getReferenceNo())
                        .phoneNumber(paymentRequest.getPhoneNumber())
                        .transactionDate(new Date())
                        .build()
        );
        return TransactionCreateResponse.builder()
                .statusMessage("Transaction is successful!")
                .amount(transaction.getAmount())
                .transactionId(transaction.getId())
                .transactionDate(AppUtils.dateToSTring(transaction.getTransactionDate()))
                .phoneNumber(transaction.getPhoneNumber())
                .build();
    }

    @Override
    public List<TransactionResponse> list(String id) {
        if (StringUtils.hasText(id)) {
            Optional<Transaction> transaction = this.transactionRepository.findById(Integer.parseInt(id));
            if (transaction.isPresent()) {
                Transaction tran = transaction.get();
                return List.of(TransactionResponse.builder()
                        .id(tran.getId())
                        .apiCaller(tran.getApiCaller())
                        .amount(tran.getAmount())
                        .referenceNo(tran.getReferenceNo())
                        .phoneNumber(tran.getPhoneNumber())
                        .build());
            }
            return new ArrayList<>();
        }
        List<Transaction> transactions = this.transactionRepository.findAll();

        List<TransactionResponse> transactionResponses = transactions.stream()
                .map((t) -> TransactionResponse.builder()
                        .id(t.getId())
                        .apiCaller(t.getApiCaller())
                        .amount(t.getAmount())
                        .referenceNo(t.getReferenceNo())
                        .phoneNumber(t.getPhoneNumber())
                        .build()).collect(Collectors.toList());
        return transactionResponses;
    }
}
