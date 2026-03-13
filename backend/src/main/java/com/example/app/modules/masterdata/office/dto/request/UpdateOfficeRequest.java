package com.example.app.modules.masterdata.office.dto.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateOfficeRequest(@NotBlank String code, @NotBlank String name, boolean active) {
}
