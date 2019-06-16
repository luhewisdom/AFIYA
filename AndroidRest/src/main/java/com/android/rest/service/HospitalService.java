package com.android.rest.service;

import com.android.rest.domain.Hospital;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Optional;



public interface HospitalService {
	public Hospital  save(Hospital hospital);
	
	public Iterable<Hospital> saveAll(Iterable<Hospital> hospitals);

	Optional<Hospital> findById(Long id);

	boolean existsById(Long id);
	
	Iterable<Hospital> findAll();

	Iterable<Hospital> findAllById(Iterable<Long> ids);
	
	Iterable<Hospital> findAll(Sort sort);
	
	Page<Hospital> findAll(Pageable pageable);

	long count();
	
	void deleteById(Long id);
	
	void delete(Hospital hospital);
	
	void deleteAll(Iterable<Hospital> hospitals);

	void deleteAll();

}
