package com.example.app.modules.identity.user.entity;

import com.example.app.modules.identity.role.entity.Role;

public record User(Long id, String username, String password, Role role, Long officeId, boolean active) {
}
