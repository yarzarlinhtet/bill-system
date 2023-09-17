package com.codingassigment.billingsystem.controllers.Request;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillRequest {
    @NotEmpty(message = "Bill Name is empty")
    private String name;

    private String description;
}
