package com.example.app.modules.masterdata.office.service;

import com.example.app.modules.masterdata.office.dto.request.CreateOfficeRequest;
import com.example.app.modules.masterdata.office.dto.request.UpdateOfficeRequest;
import com.example.app.modules.masterdata.office.dto.response.OfficeResponse;

import java.util.List;

public interface OfficeService {
    OfficeResponse create(CreateOfficeRequest request);
    List<OfficeResponse> list();
    OfficeResponse update(Long id, UpdateOfficeRequest request);
    void delete(Long id);
}
