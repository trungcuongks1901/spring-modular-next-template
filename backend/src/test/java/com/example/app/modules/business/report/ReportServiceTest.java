package com.example.app.modules.business.report;

import com.example.app.modules.business.report.dto.request.CreateReportRequest;
import com.example.app.modules.business.report.service.ReportService;
import com.example.app.modules.identity.role.entity.Role;
import com.example.app.modules.shared.auth.UserPrincipal;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReportServiceTest {
    @Autowired
    private ReportService reportService;

    @Test
    void office_user_only_sees_own_reports() {
        UserPrincipal office = new UserPrincipal(2L, Role.OFFICE, 1L, "user1");
        reportService.create(new CreateReportRequest("a"), office);
        assertEquals(1, reportService.list(office).size());
    }
}
