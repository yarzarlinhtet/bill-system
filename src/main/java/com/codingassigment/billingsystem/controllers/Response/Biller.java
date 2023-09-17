package com.codingassigment.billingsystem.controllers.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Biller {
    @JsonProperty("bill_id")
    private Integer billId;

    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

}
