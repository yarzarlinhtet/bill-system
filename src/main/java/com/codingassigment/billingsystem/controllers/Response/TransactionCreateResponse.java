package com.codingassigment.billingsystem.controllers.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionCreateResponse {
    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("transaction_id")
    private Integer transactionId;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("transaction_date")
    private String transactionDate;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
