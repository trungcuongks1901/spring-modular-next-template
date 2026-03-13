package com.example.app.security;

import com.example.app.modules.shared.auth.JwtService;
import com.example.app.modules.shared.auth.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JwtServiceTest {
    @Autowired
    private JwtService jwtService;

    @Test
    void should_round_trip_claims() {
        UserPrincipal principal = new UserPrincipal(1L, "ADMIN", null, "admin");
        UserPrincipal parsed = jwtService.parse(jwtService.generate(principal));
        assertEquals(principal.userId(), parsed.userId());
        assertEquals(principal.role(), parsed.role());
    }
}
