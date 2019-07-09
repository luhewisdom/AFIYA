package com.android.rest.service;

import com.android.rest.domain.Hospital;
import com.android.rest.domain.Report;
import com.android.rest.domain.User;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;


public interface ReportService {
    public Report save(Report Report);

    public Iterable<Report> saveAll(Iterable<Report> Reports);

    Optional<Report> findById(Long id);

    boolean existsById(Long id);

    Iterable<Report> findAll();

    Iterable<Report> findAllById(Iterable<Long> ids);

    List<Report> findByUser(User user);
    //Page<Report> findAll(Pageable pageable);

    Report findByReportNO(String rno);

    List<Report> findByHospital(Hospital hospital);

    long count();

    void deleteById(Long id);

    void delete(Report Report);

    void deleteAll(Iterable<Report> Reports);

    void deleteAll();
}
