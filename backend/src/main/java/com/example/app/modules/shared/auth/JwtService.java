package com.example.app.modules.shared.auth;

import com.example.app.modules.identity.role.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private final SecretKey key;
    private final int expirationMinutes;

    public JwtService(@Value("${app.jwt.secret}") String secret, @Value("${app.jwt.expiration-minutes}") int expirationMinutes) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.expirationMinutes = expirationMinutes;
    }

    public String generate(UserPrincipal user) {
        Instant now = Instant.now();
        return Jwts.builder()
                .claims(Map.of("userId", user.userId(), "role", user.role().name(), "officeId", user.officeId()))
                .subject(user.username())
                .issuedAt(Date.from(now))
                .expiration(Date.from(now.plus(expirationMinutes, ChronoUnit.MINUTES)))
                .signWith(key)
                .compact();
    }

    public UserPrincipal parse(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload();
        Long office = claims.get("officeId", Integer.class) == null ? null : claims.get("officeId", Integer.class).longValue();
        return new UserPrincipal(claims.get("userId", Integer.class).longValue(), Role.valueOf(claims.get("role", String.class)), office, claims.getSubject());
    }
}
