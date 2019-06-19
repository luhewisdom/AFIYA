package com.android.rest.service;

import com.android.rest.domain.Hospital;
import com.android.rest.domain.User;
import com.android.rest.repository.HospitalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class HospitalServiceimp  implements HospitalService{

	
	public HospitalRepo hospitalRepo;
	
    @Autowired
	public HospitalServiceimp(HospitalRepo hospitalRepo)
	{
		this.hospitalRepo = hospitalRepo;
	}

	@Override
	public Hospital save(Hospital hospital) {
		return hospitalRepo.save(hospital);
	}

	@Override
	public Iterable<Hospital> saveAll(Iterable<Hospital> hospitals) {
		return hospitalRepo.saveAll(hospitals);
	}

	@Override
	public Optional<Hospital> findById(Long id) {
		return  hospitalRepo.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		return hospitalRepo.existsById(id);
	}



	@Override
	public Iterable<Hospital> findAll() {
		return hospitalRepo.findAll();
	}

	@Override
	public Iterable<Hospital> findAllById(Iterable<Long> ids) {
		return hospitalRepo.findAllById(ids);
	}

	@Override
	public Iterable<Hospital> findAll(Sort sort) {
		return  hospitalRepo.findAll(sort);
	}

	@Override
	public Page<Hospital> findAll(Pageable pageable) {
		return hospitalRepo.findAll(pageable);
	}

	@Override
	public Hospital findByHname(String hname) {
		return hospitalRepo.findByHname(hname);
	}

	@Override
	public Hospital findByUser(User user) {
		return hospitalRepo.findByUser(user);
	}

	@Override
	public long count() {
		return hospitalRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		hospitalRepo.deleteById(id);
		
	}

	@Override
	public void delete(Hospital hospital) {
		hospitalRepo.delete(hospital);
		
	}

	@Override
	public void deleteAll(Iterable<Hospital> hospitals) {
		hospitalRepo.deleteAll(hospitals);
		
	}

	@Override
	public void deleteAll() {
		hospitalRepo.deleteAll();
		
	}
    
	
}
