package com.android.rest.service;


import com.android.rest.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {

	User findUserByUsername(String username);
	void saveUser(User user,String role);
	void saveUser(User user);
	Iterable<User> findAll();
	
}
