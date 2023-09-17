package com.codingassigment.billingsystem.controllers.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidationErrorResponse {
    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("errors")
    private List<Error> errors;

    public void addErrors(List<FieldError> fieldErrors) {
        this.errors = new ArrayList<>();
        for (FieldError fieldError :
                fieldErrors) {
            this.errors.add(new Error(fieldError.getField(), fieldError.getDefaultMessage()));
        }
    }
}


