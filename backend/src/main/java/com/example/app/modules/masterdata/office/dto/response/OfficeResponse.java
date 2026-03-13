package com.example.app.modules.masterdata.office.dto.response;

import java.time.Instant;

public record OfficeResponse(Long id, String code, String name, boolean active, Instant createdAt) {}
