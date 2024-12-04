
package com.towson.takeMine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "REPORTS")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reportId;

    @Column(nullable = false)
    private String reportedUser;

    @Column(nullable = false)
    private String reportingUser;


    @Column(nullable = false)
    private String text;

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public String getReportedUser() {
        return reportedUser;
    }

    public void setReportedUser(String reportedUser) {
        this.reportedUser = reportedUser;
    }

    public String getReportingUser() {
        return reportingUser;
    }

    public void setReportingUser(String reportingUser) {
        this.reportingUser = reportingUser;
    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
// Getters and Setters
}
