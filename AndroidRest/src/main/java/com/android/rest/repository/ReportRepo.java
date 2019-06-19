package com.android.rest.repository;

import com.android.rest.domain.Report;
import com.android.rest.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepo extends CrudRepository<Report,Long> {

    List<Report> findByUser(User user);
}
