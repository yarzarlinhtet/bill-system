package com.codingassigment.billingsystem.sercurity;

import com.codingassigment.billingsystem.security.JwtTokenProviderImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles(value = "test")
public class JwtTokenProviderImplTest {

    @Autowired
    private JwtTokenProviderImpl jwtTokenProvider;

    @Test
    void test_generate_token() {
        assertNotNull(jwtTokenProvider.generateToken("test"));
    }

    @Test
    void test_valid_token() {
        String token = jwtTokenProvider.generateToken("test");

        assertTrue(jwtTokenProvider.validateToken(token));
    }

    @Test
    void test_invalid_token() throws InterruptedException {
        assertFalse(jwtTokenProvider.validateToken("blablatoken"));

        String token = jwtTokenProvider.generateToken("test");
        Thread.sleep(2000);
        assertFalse(jwtTokenProvider.validateToken(token));
    }

    @Test
    void test_get_name_from_token() {
        String expectedUserName = "city pay user";

        String token = jwtTokenProvider.generateToken(expectedUserName);

        assertEquals(expectedUserName, jwtTokenProvider.getUsernameFromToken(token));

    }
}
