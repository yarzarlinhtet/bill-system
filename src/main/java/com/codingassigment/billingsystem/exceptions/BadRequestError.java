package com.codingassigment.billingsystem.exceptions;

import com.codingassigment.billingsystem.controllers.Response.Error;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BadRequestError {
    @JsonProperty(namespace = "status_message")
    private String statusMessage;

    private List<Error> errors;
}
