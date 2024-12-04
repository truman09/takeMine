package com.towson.takeMine.service;

import com.towson.takeMine.entity.Borrow;
import com.towson.takeMine.entity.Report;
import com.towson.takeMine.entity.Resource;
import com.towson.takeMine.repository.BorrowRepository;
import com.towson.takeMine.repository.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {
    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public Report addReport(Report report) {
        return reportRepository.save(report);
    }
    public List<Report> getAllReports (){
        return reportRepository.findAll();
    }
    public Report getReportId (int reportId){
        Optional<Report> report = reportRepository.findById(reportId);
        if (report.isEmpty()) {
            throw new IllegalArgumentException("Report already exists");
        }
        return report.get();
    }
    public List<Report> getAllByReportedUser (String tuId){
        return reportRepository.findByReportedUser(tuId);
    }
    public List<Report> getAllByReportingUser (String tuId){
        return reportRepository.findByReportingUser(tuId);
    }
    public Report updateReport(int reportId, Report updates) {
        Report report = reportRepository.findById(reportId)
                .orElseThrow(() -> new IllegalArgumentException("Report not found"));
        return reportRepository.save(updates);
    }


    public void deleteReport (int reportId){
        Optional<Report> report = reportRepository.findById(reportId);
        if (report.isEmpty()) {
            throw new IllegalArgumentException("Report already exists");
        }
        reportRepository.delete(report.get());
    }
}
