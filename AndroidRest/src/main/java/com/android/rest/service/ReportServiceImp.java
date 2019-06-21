package com.android.rest.service;

import com.android.rest.domain.Report;
import com.android.rest.domain.User;
import com.android.rest.repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportServiceImp implements ReportService {
    public com.android.rest.repository.ReportRepo reportRepo;

    @Autowired
    public ReportServiceImp(com.android.rest.repository.ReportRepo ReportRepo)
    {
        this.reportRepo = ReportRepo;
    }

    @Override
    public Report save(Report Report) {
        return reportRepo.save(Report);
    }

    @Override
    public Iterable<Report> saveAll(Iterable<Report> Reports) {
        return reportRepo.saveAll(Reports);
    }

    @Override
    public Optional<Report> findById(Long id) {
        return  reportRepo.findById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return reportRepo.existsById(id);
    }

    @Override
    public Iterable<Report> findAll() {
        return reportRepo.findAll();
    }

    @Override
    public Iterable<Report> findAllById(Iterable<Long> ids) {
        return reportRepo.findAllById(ids);
    }

    @Override
    public List<Report> findByUser(User user) {
        return reportRepo.findByUser(user);
    }


    @Override
    public long count() {
        return reportRepo.count();
    }

    @Override
    public void deleteById(Long id) {
        reportRepo.deleteById(id);

    }

    @Override
    public void delete(Report Report) {
        reportRepo.delete(Report);

    }

    @Override
    public void deleteAll(Iterable<Report> Reports) {
        reportRepo.deleteAll(Reports);

    }

    @Override
    public void deleteAll() {
        reportRepo.deleteAll();

    }
}
