package com.example.app.modules.business.report.service;

import com.example.app.modules.business.report.dto.request.CreateReportRequest;
import com.example.app.modules.business.report.dto.response.ReportResponse;
import com.example.app.modules.masterdata.office.dto.response.OfficeResponse;
import com.example.app.modules.shared.auth.UserPrincipal;

import java.util.List;

public interface ReportService {
    ReportResponse create(CreateReportRequest request, UserPrincipal userPrincipal);
    List<ReportResponse> list(UserPrincipal userPrincipal);
    List<OfficeResponse> reportOffices(UserPrincipal userPrincipal);
}
