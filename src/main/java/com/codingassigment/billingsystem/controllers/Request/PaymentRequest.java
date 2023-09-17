package com.codingassigment.billingsystem.controllers.Request;

import com.codingassigment.billingsystem.validations.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {
    @NotEmpty(message = "api caller is empty")
    @JsonProperty("api_caller")
    private String apiCaller;

    @NotNull(message = "billId is empty")
    @JsonProperty("id")
    private Integer id;

    @Min(value = 0, message = "amount must be at least 0")
    @Max(value = 100000, message = "amount cannot exceed 100000")
    @NotNull(message = "amount is empty")
    @JsonProperty("amount")
    private Integer amount;

    @NotNull(message = "Reference Number is empty")
    @JsonProperty("reference_no")
    private String referenceNo;

    @NotNull(message = "Phone number is empty")
    @PhoneNumber
    @JsonProperty("phone_number")
    private String phoneNumber;
}
