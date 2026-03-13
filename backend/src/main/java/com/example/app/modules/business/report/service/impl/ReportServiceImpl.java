package com.example.app.modules.business.report.service.impl;

import com.example.app.modules.business.report.dto.request.CreateReportRequest;
import com.example.app.modules.business.report.dto.response.ReportResponse;
import com.example.app.modules.business.report.entity.Report;
import com.example.app.modules.business.report.repository.ReportRepository;
import com.example.app.modules.business.report.service.ReportService;
import com.example.app.modules.identity.role.entity.Role;
import com.example.app.modules.masterdata.office.dto.response.OfficeResponse;
import com.example.app.modules.masterdata.office.service.OfficeService;
import com.example.app.modules.shared.auth.UserPrincipal;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;
    private final OfficeService officeService;

    public ReportServiceImpl(ReportRepository reportRepository, OfficeService officeService) {
        this.reportRepository = reportRepository;
        this.officeService = officeService;
    }

    public ReportResponse create(CreateReportRequest request, UserPrincipal userPrincipal) {
        Long id = reportRepository.findAll().stream().mapToLong(Report::id).max().orElse(0L) + 1;
        Long officeId = userPrincipal.role() == Role.ADMIN ? userPrincipal.officeId() : userPrincipal.officeId();
        Report report = reportRepository.save(new Report(id, officeId, request.content(), userPrincipal.userId(), Instant.now()));
        return map(report);
    }
    public List<ReportResponse> list(UserPrincipal userPrincipal) {
        return reportRepository.findAll().stream()
                .filter(r -> userPrincipal.role() == Role.ADMIN || r.officeId().equals(userPrincipal.officeId()))
                .map(this::map)
                .toList();
    }
    public List<OfficeResponse> reportOffices(UserPrincipal userPrincipal) {
        return userPrincipal.role() == Role.ADMIN ? officeService.list() : officeService.list().stream().filter(o -> o.id().equals(userPrincipal.officeId())).toList();
    }
    private ReportResponse map(Report report) { return new ReportResponse(report.id(), report.officeId(), report.content(), report.createdBy(), report.createdAt()); }
}
