package com.example.app.modules.shared.util;

import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class IdGenerator {
    private final AtomicLong sequence = new AtomicLong(1000L);
    public long next() { return sequence.incrementAndGet(); }
}
