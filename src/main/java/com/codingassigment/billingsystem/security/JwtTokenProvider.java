package com.codingassigment.billingsystem.security;

import org.springframework.security.core.Authentication;

public interface JwtTokenProvider {
    String generateToken(String username);

    String getUsernameFromToken(String token);

    boolean validateToken(String token);
}
