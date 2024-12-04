
package com.towson.takeMine.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "BORROWS", schema = "TAKE_MINE")
public class Borrow {
    @Id
    @Column(name="borrow_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int borrowId;

    @Column(nullable = false, name="res_Id")
    private int resId;

    @Column(nullable = false, name="borrower_TUID")
    private String borrowerTuId;

    @Column(nullable = false)
    private LocalDateTime startTime;
    @Column(nullable = false)
    private LocalDateTime endTime;

    @Column(nullable = false)
    private String status;
    @Column(nullable = false)
    private int resRating;

    public int getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(int borrowId) {
        this.borrowId = borrowId;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getBorrowerTuId() {
        return borrowerTuId;
    }

    public void setBorrowerTuId(String borrowerTuId) {
        this.borrowerTuId = borrowerTuId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getResRating() {
        return resRating;
    }

    public void setResRating(int resRating) {
        this.resRating = resRating;
    }
// Getters and Setters
}
