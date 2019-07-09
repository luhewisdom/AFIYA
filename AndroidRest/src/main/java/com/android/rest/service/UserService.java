package com.android.rest.service;


import com.android.rest.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;


public interface UserService extends UserDetailsService {

	User findUserByUsername(String username);
	void saveUser(User user,String role);
	void saveUser(User user);
	Iterable<User> findAll();



	Optional<User> findById(Long id);

	boolean existsById(Long id);


	Iterable<User> findAllById(Iterable<Long> ids);



	void deleteById(Long id);




	
}
