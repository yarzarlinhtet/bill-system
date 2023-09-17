package com.codingassigment.billingsystem.serviceImpls;

import com.codingassigment.billingsystem.controllers.Request.BillRequest;
import com.codingassigment.billingsystem.controllers.Response.BillCreateResponse;
import com.codingassigment.billingsystem.controllers.Response.BillResponse;
import com.codingassigment.billingsystem.exceptions.BadRequestException;
import com.codingassigment.billingsystem.models.Bill;
import com.codingassigment.billingsystem.repositories.BillRepository;
import com.codingassigment.billingsystem.services.BillService;
import com.codingassigment.billingsystem.utils.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

@Service
public class BillServiceImpl implements BillService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BillService.class);

    private final BillRepository billRepository;

    @Autowired
    public BillServiceImpl(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @Override
    public BillCreateResponse add(BillRequest billRequest) {
        if (this.billRepository.existsByName(billRequest.getName())) {
            return BillCreateResponse.builder()
                    .statusMessage(String.format("Bill %s is already exists", billRequest.getName()))
                    .dateTime(AppUtils.dateToSTring(new Date()))
                    .build();
        }
        Bill bill = this.billRepository.save(
                Bill.builder()
                        .enable(true)
                        .name(billRequest.getName())
                        .description(billRequest.getDescription())
                        .build()
        );

        return BillCreateResponse.builder()
                .statusMessage(String.format("Bill %s is successfully saved in the system", bill.getName()))
                .dateTime(AppUtils.dateToSTring(new Date()))
                .billId(bill.getId())
                .name(bill.getName())
                .description(bill.getDescription())
                .build();
    }

    @Override
    public BillResponse list(String billId) {
        if (StringUtils.hasText(billId)) {
            BillResponse billResponse = BillResponse.builder()
                    .statusMessage("Transaction is Successful!")
                    .dateTime(AppUtils.dateToSTring(new Date()))
                    .build();
            Bill bill = this.billRepository.findById(Integer.parseInt(billId))
                    .orElse(null);
            billResponse.addBill(bill);
            return billResponse;
        }
        BillResponse billResponse = BillResponse.builder()
                .statusMessage("Transaction is Successful!")
                .dateTime(AppUtils.dateToSTring(new Date()))
                .build();
        billResponse.addBills(this.billRepository.findAll());
        return billResponse;

    }
}
