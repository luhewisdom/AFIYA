package com.android.rest.repository;


import com.android.rest.domain.Hospital;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface HospitalRepo extends PagingAndSortingRepository<Hospital,Long>{

	
}
