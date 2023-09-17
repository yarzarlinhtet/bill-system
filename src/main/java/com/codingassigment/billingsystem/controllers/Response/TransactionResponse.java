package com.codingassigment.billingsystem.controllers.Response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransactionResponse {
    @JsonProperty("api_caller")
    private String apiCaller;

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("amount")
    private Integer amount;

    @JsonProperty("reference_no")
    private String referenceNo;

    @JsonProperty("phone_number")
    private String phoneNumber;
}
