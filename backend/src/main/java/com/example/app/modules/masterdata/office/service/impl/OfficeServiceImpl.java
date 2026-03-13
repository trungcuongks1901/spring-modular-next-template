package com.example.app.modules.masterdata.office.service.impl;

import com.example.app.modules.masterdata.office.dto.request.CreateOfficeRequest;
import com.example.app.modules.masterdata.office.dto.request.UpdateOfficeRequest;
import com.example.app.modules.masterdata.office.dto.response.OfficeResponse;
import com.example.app.modules.masterdata.office.entity.Office;
import com.example.app.modules.masterdata.office.repository.OfficeRepository;
import com.example.app.modules.masterdata.office.service.OfficeService;
import com.example.app.modules.shared.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;

    public OfficeServiceImpl(OfficeRepository officeRepository) { this.officeRepository = officeRepository; }

    @Override
    public OfficeResponse create(CreateOfficeRequest request) {
        Long id = officeRepository.findAll().stream().mapToLong(Office::id).max().orElse(0L) + 1;
        Office saved = officeRepository.save(new Office(id, request.code(), request.name(), request.active(), Instant.now()));
        return map(saved);
    }
    @Override
    public List<OfficeResponse> list() { return officeRepository.findAll().stream().map(this::map).toList(); }
    @Override
    public OfficeResponse update(Long id, UpdateOfficeRequest request) {
        Office existing = officeRepository.findById(id).orElseThrow(() -> new NotFoundException("Office not found"));
        Office saved = officeRepository.save(new Office(id, request.code(), request.name(), request.active(), existing.createdAt()));
        return map(saved);
    }
    @Override
    public void delete(Long id) { officeRepository.delete(id); }
    private OfficeResponse map(Office office) { return new OfficeResponse(office.id(), office.code(), office.name(), office.active(), office.createdAt()); }
}
