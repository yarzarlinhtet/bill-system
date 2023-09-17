package com.codingassigment.billingsystem.controllers.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillCreateResponse {

    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("date_time")
    private String dateTime;

    @JsonProperty("bill_id")
    private Integer billId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;
}
