package com.example.service;

import com.example.model.UserCredentials;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.util.ReflectionTestUtils;

import javax.crypto.SecretKey;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JWTServiceTest {

    private JWTService jwtService;
    private SecretKey secretKey;
    private String base64Secret;

    @BeforeEach
    void setUp() {

        jwtService = new JWTService();

        secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        base64Secret = Encoders.BASE64.encode(secretKey.getEncoded());

        ReflectionTestUtils.setField(jwtService, "jwtSecret", base64Secret);
    }

    @Test
    void generateToken_shouldContainSubjectAndUserIdClaim() {

        UserCredentials creds = new UserCredentials(123, "John", "Doe");


        String token = jwtService.generateToken(creds);
        assertNotNull(token);


        String subject = jwtService.extractUserName(token);
        assertThat(subject).isEqualTo("John");


        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        assertThat(claims.get("userId", Long.class)).isEqualTo(123L);
    }

    @Test
    void validateToken_withValidUserDetails_shouldReturnTrue() {
        UserCredentials creds = new UserCredentials(123, "john.doe", "Doe");

        String token = jwtService.generateToken(creds);


        UserDetails userDetails = User.withUsername("john.doe")
                .password("irrelevant")
                .roles("USER")
                .build();


        assertTrue(jwtService.validateToken(token, userDetails));
    }

    @Test
    void validateToken_withWrongUsername_shouldReturnFalse() {
        UserCredentials creds = new UserCredentials(123, "John", "Doe");

        String token = jwtService.generateToken(creds);


        UserDetails other = User.withUsername("jane.doe")
                .password("irrelevant")
                .roles("USER")
                .build();


        assertFalse(jwtService.validateToken(token, other));
    }

    @Test
    void validateToken_withTamperedToken_shouldThrowException() {
        UserCredentials creds = new UserCredentials(1, "alice", "Doe");
        String token = jwtService.generateToken(creds);

        // podróbmy token: dopiszemy literkę na końcu
        String tampered = token + "x";

        // parsowanie/tłumaczenie wywoła wyjątek
        assertThrows(Exception.class, () -> jwtService.extractUserName(tampered));
    }
}
