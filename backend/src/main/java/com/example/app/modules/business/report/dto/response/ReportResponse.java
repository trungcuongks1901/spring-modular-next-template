package com.example.app.modules.business.report.dto.response;

import java.time.Instant;

public record ReportResponse(Long id, Long officeId, String content, Long createdBy, Instant createdAt) {}
