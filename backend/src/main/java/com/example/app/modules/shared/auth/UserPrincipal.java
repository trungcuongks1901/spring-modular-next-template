package com.example.app.modules.shared.auth;

public record UserPrincipal(Long userId, String role, Long officeId, String username) {
}
