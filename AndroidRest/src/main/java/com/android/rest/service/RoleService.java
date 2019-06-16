package com.android.rest.service;


import com.android.rest.domain.Role;

import java.util.Optional;


public interface RoleService {

	public Role save(Role role);
	
	public Iterable<Role> saveAll(Iterable<Role> roles);

	Optional<Role> findById(Long id);

	boolean existsById(Long id);

	public Role findByRoleName(String level);
	
	Iterable<Role> findAll();

	Iterable<Role> findAllById(Iterable<Long> ids);

	long count();
	
	void deleteById(Long id);
	
	void delete(Role role);
	
	void deleteAll(Iterable<Role> roles);

	void deleteAll();
}
