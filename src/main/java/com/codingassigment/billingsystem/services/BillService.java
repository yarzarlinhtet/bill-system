package com.codingassigment.billingsystem.services;

import com.codingassigment.billingsystem.controllers.Request.BillRequest;
import com.codingassigment.billingsystem.controllers.Response.BillCreateResponse;
import com.codingassigment.billingsystem.controllers.Response.BillResponse;
import com.codingassigment.billingsystem.models.Bill;

import java.util.List;

public interface BillService {
    BillCreateResponse add(BillRequest billRequest);

    BillResponse list(String billId);
}
