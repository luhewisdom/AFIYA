package com.android.rest.repository;


import com.android.rest.domain.Hospital;
import com.android.rest.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface HospitalRepo extends PagingAndSortingRepository<Hospital,Long>{

    Hospital findByHname(String hname);

    Hospital findByUser(User user);

	
}
