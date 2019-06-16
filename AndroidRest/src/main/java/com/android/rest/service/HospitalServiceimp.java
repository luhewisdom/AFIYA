package com.android.rest.service;

import com.android.rest.domain.Hospital;
import com.android.rest.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HospitalServiceimp  implements HospitalService{

	
	public HospitalRepository hospitalRepository;
	
    @Autowired
	public HospitalServiceimp(HospitalRepository hospitalRepository)
	{
		this.hospitalRepository = hospitalRepository;
	}

	@Override
	public Hospital save(Hospital hospital) {
		return hospitalRepository.save(hospital);
	}

	@Override
	public Iterable<Hospital> saveAll(Iterable<Hospital> hospitals) {
		return hospitalRepository.saveAll(hospitals);
	}

	@Override
	public Optional<Hospital> findById(Long id) {
		return  hospitalRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return hospitalRepository.existsById(id);
	}

	@Override
	public Iterable<Hospital> findAll() {
		return hospitalRepository.findAll();
	}

	@Override
	public Iterable<Hospital> findAllById(Iterable<Long> ids) {
		return hospitalRepository.findAllById(ids);
	}

	@Override
	public Iterable<Hospital> findAll(Sort sort) {
		return  hospitalRepository.findAll(sort);
	}

	@Override
	public Page<Hospital> findAll(Pageable pageable) {
		return hospitalRepository.findAll(pageable);
	}

	@Override
	public long count() {
		return hospitalRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		hospitalRepository.deleteById(id);
		
	}

	@Override
	public void delete(Hospital hospital) {
		hospitalRepository.delete(hospital);
		
	}

	@Override
	public void deleteAll(Iterable<Hospital> hospitals) {
		hospitalRepository.deleteAll(hospitals);
		
	}

	@Override
	public void deleteAll() {
		hospitalRepository.deleteAll();
		
	}
    
	
}
