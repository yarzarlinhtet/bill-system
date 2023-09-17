package com.codingassigment.billingsystem.controllers.Request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "username is empty")
    private String username;

    @NotBlank(message = "password is empty")
    private String password;
}
