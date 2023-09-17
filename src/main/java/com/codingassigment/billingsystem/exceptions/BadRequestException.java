package com.codingassigment.billingsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

    private BadRequestError badRequestError;

    public BadRequestException(String message) {
        super(message);
        this.badRequestError = BadRequestError.builder()
                .statusMessage(message)
                .build();
    }

    public BadRequestException(String message, BadRequestError badRequestError) {
        super(message);
        this.badRequestError = badRequestError;
    }

    public BadRequestError getBadRequestError() {
        return badRequestError;
    }
}
