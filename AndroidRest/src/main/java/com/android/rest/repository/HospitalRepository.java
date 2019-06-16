package com.android.rest.repository;


import com.android.rest.domain.Hospital;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface HospitalRepository extends PagingAndSortingRepository<Hospital,Long>{

	
}
