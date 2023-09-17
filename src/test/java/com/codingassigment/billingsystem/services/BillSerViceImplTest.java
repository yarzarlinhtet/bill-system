package com.codingassigment.billingsystem.services;

import com.codingassigment.billingsystem.controllers.Request.BillRequest;
import com.codingassigment.billingsystem.controllers.Response.BillCreateResponse;
import com.codingassigment.billingsystem.models.Bill;
import com.codingassigment.billingsystem.repositories.BillRepository;
import com.codingassigment.billingsystem.serviceImpls.BillServiceImpl;
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
public class BillSerViceImplTest {
    @InjectMocks
    private BillServiceImpl billService;

    @Mock
    private BillRepository billRepository;

    @Test
    void test_bill_add_when_bill_name_exists() {
        when(billRepository.existsByName(any())).thenReturn(true);

        String billName = "Top up";

        BillRequest billRequest = BillRequest.builder()
                .name(billName)
                .build();

        BillCreateResponse billCreateResponse = this.billService.add(billRequest);

        assertNotNull(billCreateResponse);

        assertEquals(String.format("Bill %s is already exists", billName), billCreateResponse.getStatusMessage());

        assertNull(billCreateResponse.getName());
    }

    @Test
    void test_add_new_bill() {
        String billName = "Top up";

        BillRequest billRequest = BillRequest.builder()
                .name(billName)
                .build();

        when(billRepository.existsByName(any())).thenReturn(false);

        when(billRepository.save(any(Bill.class))).thenReturn(
                Bill.builder()
                        .name(billName)
                        .build());

        BillCreateResponse billCreateResponse = this.billService.add(billRequest);

        assertNotNull(billCreateResponse);

//        assertEquals(String.format("Bill %s is successfully saved in the system", billName), billCreateResponse.getStatusMessage());

        assertEquals(billName, billCreateResponse.getName());
    }
}
