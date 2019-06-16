package com.android.rest.service;


import com.android.rest.domain.Role;
import com.android.rest.domain.User;
import com.android.rest.repository.RoleRepo;
import com.android.rest.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service
public class UserServiceImpl implements UserService{
	
	private UserRepo userRepository;
    private RoleRepo roleRepository;
    private NoOpPasswordEncoder noOpPasswordEncoder;
    
    @Autowired
    public UserServiceImpl(UserRepo userRepository,
                       RoleRepo roleRepository,
                       NoOpPasswordEncoder noOpPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.noOpPasswordEncoder = noOpPasswordEncoder;
    }

    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }
    
    public void saveUser(User user , String role) {
        user.setPassword(noOpPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByRole(role);
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(noOpPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(1);
        Role userRole = roleRepository.findByRole("client");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		
		if(user != null) {
			return user;
		}
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}

	@Override
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
}
