package com.example.app.modules.masterdata.office.controller;

import com.example.app.modules.masterdata.office.dto.request.CreateOfficeRequest;
import com.example.app.modules.masterdata.office.dto.request.UpdateOfficeRequest;
import com.example.app.modules.masterdata.office.dto.response.OfficeResponse;
import com.example.app.modules.masterdata.office.service.OfficeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offices")
public class OfficeController {
    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) { this.officeService = officeService; }

    @PostMapping public OfficeResponse create(@Valid @RequestBody CreateOfficeRequest request) { return officeService.create(request); }
    @GetMapping public List<OfficeResponse> list() { return officeService.list(); }
    @PutMapping("/{id}") public OfficeResponse update(@PathVariable Long id, @Valid @RequestBody UpdateOfficeRequest request) { return officeService.update(id, request); }
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id) { officeService.delete(id); }
}
