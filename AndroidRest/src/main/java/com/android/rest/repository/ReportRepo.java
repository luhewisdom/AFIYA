package com.android.rest.repository;

import com.android.rest.domain.Report;
import org.springframework.data.repository.CrudRepository;

public interface ReportRepo extends CrudRepository<Report,Long> {
}
