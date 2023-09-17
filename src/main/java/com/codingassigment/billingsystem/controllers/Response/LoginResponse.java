package com.codingassigment.billingsystem.controllers.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginResponse {
    @JsonProperty("status_message")
    private String statusMessage;

    @JsonProperty("access_token")
    private String accessToken;
}
