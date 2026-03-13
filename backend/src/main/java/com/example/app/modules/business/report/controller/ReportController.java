package com.example.app.modules.business.report.controller;

import com.example.app.modules.business.report.dto.request.CreateReportRequest;
import com.example.app.modules.business.report.dto.response.ReportResponse;
import com.example.app.modules.business.report.service.ReportService;
import com.example.app.modules.masterdata.office.dto.response.OfficeResponse;
import com.example.app.modules.shared.auth.CurrentUser;
import com.example.app.modules.shared.auth.UserPrincipal;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) { this.reportService = reportService; }

    @PostMapping("/reports")
    public ReportResponse create(@Valid @RequestBody CreateReportRequest request, @CurrentUser UserPrincipal userPrincipal) {
        return reportService.create(request, userPrincipal);
    }

    @GetMapping("/reports")
    public List<ReportResponse> list(@CurrentUser UserPrincipal userPrincipal) { return reportService.list(userPrincipal); }

    @GetMapping("/report/offices")
    public List<OfficeResponse> reportOffices(@CurrentUser UserPrincipal userPrincipal) { return reportService.reportOffices(userPrincipal); }
}
