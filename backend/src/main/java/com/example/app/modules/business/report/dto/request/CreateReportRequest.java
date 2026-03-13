package com.example.app.modules.business.report.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CreateReportRequest(@NotBlank String content) {}
