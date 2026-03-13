package com.example.app.modules.masterdata.office.repository.inmemory;

import com.example.app.modules.masterdata.office.entity.Office;
import com.example.app.modules.masterdata.office.repository.OfficeRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryOfficeRepository implements OfficeRepository {
    private final Map<Long, Office> data = new ConcurrentHashMap<>();

    public InMemoryOfficeRepository() {
        data.put(1L, new Office(1L, "HN", "Hanoi Office", true, Instant.now()));
        data.put(2L, new Office(2L, "SG", "Saigon Office", true, Instant.now()));
        data.put(3L, new Office(3L, "DN", "Danang Office", true, Instant.now()));
    }

    @Override
    public Office save(Office office) { data.put(office.id(), office); return office; }
    @Override
    public List<Office> findAll() { return new ArrayList<>(data.values()); }
    @Override
    public Optional<Office> findById(Long id) { return Optional.ofNullable(data.get(id)); }
    @Override
    public void delete(Long id) { data.remove(id); }
}
