package com.example.app.modules.identity.auth.controller;

import com.example.app.modules.identity.auth.dto.request.LoginRequest;
import com.example.app.modules.identity.auth.dto.response.LoginResponse;
import com.example.app.modules.identity.auth.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) { this.authService = authService; }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) { return authService.login(request); }
}
