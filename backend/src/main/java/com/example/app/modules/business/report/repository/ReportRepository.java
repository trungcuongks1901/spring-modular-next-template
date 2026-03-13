package com.example.app.modules.business.report.repository;

import com.example.app.modules.business.report.entity.Report;

import java.util.List;

public interface ReportRepository {
    Report save(Report report);
    List<Report> findAll();
}
