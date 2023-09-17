package com.codingassigment.billingsystem.controllers;

import com.codingassigment.billingsystem.controllers.Request.BillRequest;
import com.codingassigment.billingsystem.controllers.Response.BillCreateResponse;
import com.codingassigment.billingsystem.models.Bill;
import com.codingassigment.billingsystem.services.BillService;
import com.codingassigment.billingsystem.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/")
public class BillController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillController.class);

    private final BillService billService;

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> addBill(@Valid @RequestBody BillRequest billRequest) {
        return ResponseEntity.ok(this.billService.add(billRequest));
    }

    @GetMapping(value = "/list")
    public ResponseEntity<?> billList(@RequestParam(name = "id") String id) {
        return ResponseEntity.ok(this.billService.list(id));
    }
}
