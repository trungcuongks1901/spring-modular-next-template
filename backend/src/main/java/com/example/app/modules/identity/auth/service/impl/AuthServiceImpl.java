package com.example.app.modules.identity.auth.service.impl;

import com.example.app.modules.identity.auth.dto.request.LoginRequest;
import com.example.app.modules.identity.auth.dto.response.LoginResponse;
import com.example.app.modules.identity.auth.service.AuthService;
import com.example.app.modules.identity.user.entity.User;
import com.example.app.modules.identity.user.repository.UserRepository;
import com.example.app.modules.shared.auth.JwtService;
import com.example.app.modules.shared.auth.UserPrincipal;
import com.example.app.modules.shared.exception.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthServiceImpl(UserRepository userRepository, JwtService jwtService) { this.userRepository = userRepository; this.jwtService = jwtService; }

    public LoginResponse login(LoginRequest request) {
        User user = userRepository.findByUsername(request.username())
                .filter(u -> u.password().equals(request.password()) && u.active())
                .orElseThrow(() -> new UnauthorizedException("Invalid credentials"));
        String token = jwtService.generate(new UserPrincipal(user.id(), user.role(), user.officeId(), user.username()));
        return new LoginResponse(token);
    }
}
