package com.example.app.modules.business.report.entity;

import java.time.Instant;

public record Report(Long id, Long officeId, String content, Long createdBy, Instant createdAt) {
}
