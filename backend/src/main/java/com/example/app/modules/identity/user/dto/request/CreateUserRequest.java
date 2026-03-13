package com.example.app.modules.identity.user.dto.request;

import com.example.app.modules.identity.role.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateUserRequest(@NotBlank String username, @NotBlank String password, @NotNull Role role, Long officeId, boolean active) {}
