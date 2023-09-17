package com.codingassigment.billingsystem.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenProviderImpl implements JwtTokenProvider {

    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenProviderImpl.class);

    @Value("${app.jwt.key}")
    private String jwtKey;

    @Value("${app.jwt.expiration-time}")
    private Integer expirationTime;

    @Override
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS256, jwtKey)
                .compact();
    }

    @Override
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    @Override
    public boolean validateToken(String token) {
        try{
            Jwts.parser()
                    .setSigningKey(jwtKey)
                    .parseClaimsJws(token);
            return true;
        }catch (Exception e) {
            LOGGER.error("validateToken() Invalid Json Token");
        }
        return false;
    }
}
