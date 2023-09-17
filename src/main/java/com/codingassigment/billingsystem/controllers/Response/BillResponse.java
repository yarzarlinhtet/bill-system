package com.codingassigment.billingsystem.controllers.Response;

import com.codingassigment.billingsystem.models.Bill;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillResponse {
    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("date_time")
    private String dateTime;

    private List<Biller> billers = new ArrayList<>();

    public void addBill(Bill bill) {
        if (bill != null) {
            if (billers == null) {
                this.billers = new ArrayList<>();
            }
            this.billers.add(new Biller(bill.getId(), bill.getName(), bill.getDescription()));
        }
    }

    public void addBills(List<Bill> bills) {
        for (Bill bill :
                bills) {
            this.addBill(bill);
        }
    }
}
