package com.example.app.modules.identity.user.dto.response;

import com.example.app.modules.identity.role.entity.Role;

public record UserResponse(Long id, String username, Role role, Long officeId, boolean active) {}
