package com.codingassigment.billingsystem.controllers;

import com.codingassigment.billingsystem.controllers.Request.PaymentRequest;
import com.codingassigment.billingsystem.exceptions.BadRequestException;
import com.codingassigment.billingsystem.services.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class TransactionController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(value = "/pay")
    public ResponseEntity<?> pay(@Valid @RequestBody PaymentRequest paymentRequest) {
        try {
            return ResponseEntity.ok(this.transactionService.pay(paymentRequest));
        }catch (BadRequestException badRequestException) {
            return ResponseEntity.badRequest().body(badRequestException.getBadRequestError());
        }

    }

    @GetMapping(value = "/transaction")
    public ResponseEntity<?> transactions(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok(this.transactionService.list(id));
    }
}
