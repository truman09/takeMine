package com.towson.takeMine.repository;

import com.towson.takeMine.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
    @Override
    List<Report> findAll();

    @Override
    <S extends Report> S save(S entity);

    @Override
    Optional<Report> findById(Integer integer);

    @Override
    void delete(Report entity);

    List<Report> findByReportedUser(String reportedUser);
    List<Report> findByReportingUser(String reportingUser);

}
