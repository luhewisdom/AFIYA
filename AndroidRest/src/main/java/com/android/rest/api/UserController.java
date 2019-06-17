package com.android.rest.api;


import com.android.rest.domain.Role;
import com.android.rest.domain.User;
import com.android.rest.service.RoleService;
import com.android.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;

	@Autowired
    private RoleService roleService;

	
    @GetMapping("/users")
    public Iterable<User> pogetAllUsers(){
    	return  userService.findAll();
    }
    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user)
    {
    	 userService.saveUser(user);
    }


    @GetMapping("/staff/register")
    public Iterable<User> client(){
        return userService.findAll();
    }

    @PostMapping(path = "/staff/register",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@Valid @RequestBody User user,@RequestParam String level)
    {
         Role  role =  roleService.findByRoleName(level);
         if (role == null)
         {
             role = new Role(level);

         }
         if(userService.findUserByUsername(user.getUsername()) != null)
         {
             throw new BadCredentialsException("User with username: " + user.getUsername() + " already exists");
         }
         userService.saveUser(user,level);
    }


    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    }
    
}
