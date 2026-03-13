package com.example.app.modules.shared.auth;

import com.example.app.modules.identity.role.entity.Role;

public record UserPrincipal(Long userId, Role role, Long officeId, String username) {
}
