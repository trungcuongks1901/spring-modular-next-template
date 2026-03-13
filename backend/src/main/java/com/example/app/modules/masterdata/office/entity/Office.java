package com.example.app.modules.masterdata.office.entity;

import java.time.Instant;

public record Office(Long id, String code, String name, boolean active, Instant createdAt) {
}
