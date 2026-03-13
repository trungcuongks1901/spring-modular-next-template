package com.example.app.modules.identity.auth;

import com.example.app.modules.identity.auth.dto.request.LoginRequest;
import com.example.app.modules.identity.auth.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    void should_login_with_seed_user() {
        assertNotNull(authService.login(new LoginRequest("admin", "admin123")).token());
    }
}
