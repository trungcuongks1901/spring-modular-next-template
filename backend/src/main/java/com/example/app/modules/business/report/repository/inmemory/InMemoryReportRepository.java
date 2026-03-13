package com.example.app.modules.business.report.repository.inmemory;

import com.example.app.modules.business.report.entity.Report;
import com.example.app.modules.business.report.repository.ReportRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class InMemoryReportRepository implements ReportRepository {
    private final List<Report> data = new CopyOnWriteArrayList<>();

    @Override public Report save(Report report) { data.add(report); return report; }
    @Override public List<Report> findAll() { return new ArrayList<>(data); }
}
