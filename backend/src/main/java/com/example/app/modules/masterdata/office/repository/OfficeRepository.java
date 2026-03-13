package com.example.app.modules.masterdata.office.repository;

import com.example.app.modules.masterdata.office.entity.Office;

import java.util.List;
import java.util.Optional;

public interface OfficeRepository {
    Office save(Office office);
    List<Office> findAll();
    Optional<Office> findById(Long id);
    void delete(Long id);
}
