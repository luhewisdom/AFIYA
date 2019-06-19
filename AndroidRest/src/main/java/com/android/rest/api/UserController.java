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
    public Iterable<User> getAllUsers(){
    	return  userService.findAll();
    }



    @GetMapping("/users/{id}")
    public User findOneUser(@PathVariable("id")Long id)
    {
        return findOneUser(id);
    }

    @PostMapping(path = "/staff/register",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerHospitalUser(@Valid @RequestBody User user,@RequestParam(defaultValue = "STAFF") String level)
    {
         if(userService.findUserByUsername(user.getUsername()) != null)
         {
             throw new BadCredentialsException("User with username: " + user.getUsername() + " already exists");
         }
         userService.saveUser(user,level);
    }
    @PostMapping(path = "/staff/register/role",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createRole(@Valid @RequestBody Role role)
    {
        roleService.save(role);
    }


    
}
