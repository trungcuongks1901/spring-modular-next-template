package com.example.app.modules.identity.user.dto.request;

import com.example.app.modules.identity.role.entity.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateUserRequest(@NotBlank String username, @NotNull Role role, Long officeId, boolean active) {}
