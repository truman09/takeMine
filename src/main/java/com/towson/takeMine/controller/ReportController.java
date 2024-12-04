package com.towson.takeMine.controller;

import com.towson.takeMine.entity.Report;
import com.towson.takeMine.service.ReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;
    public ReportController(ReportService reportService) {

        this.reportService = reportService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Report>> getReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }
    @GetMapping("/all/reportId/{reportId}")
    public ResponseEntity<Report> getAllByReportId(@PathVariable int reportId) {
        return ResponseEntity.ok(reportService.getReportId(reportId));
    }
    @GetMapping("/all/reportedUser/{reportedUser}")
    public ResponseEntity<List<Report>> getByReportedUser(@PathVariable String reportedUser) {
        return ResponseEntity.ok(reportService.getAllByReportedUser(reportedUser));
    }
    @GetMapping("/all/reportingUser/{reportingUser}")
    public ResponseEntity<List<Report>> getByReportingUser(@PathVariable String reportingUser) {
        return ResponseEntity.ok(reportService.getAllByReportingUser(reportingUser));
    }
    @PostMapping("/addReport")
    public ResponseEntity<Report> registerReport(@RequestBody Report report) {
        System.out.println(report.toString() + "..........");
        return ResponseEntity.ok(reportService.addReport(report));
    }
    @PutMapping("/{reportId}")
    public ResponseEntity<Report> updateReport(@PathVariable int reportId,
                                               @RequestBody Report report) {
        return ResponseEntity.ok(reportService.updateReport(reportId, report));
    }
}
