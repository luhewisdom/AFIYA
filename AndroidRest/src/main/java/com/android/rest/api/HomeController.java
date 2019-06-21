package com.android.rest.api;


import com.android.rest.domain.User;
import com.android.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path="/",produces="application/json")
@CrossOrigin(origins="*")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    }

    @PostMapping(path = "/registerClient",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user)
    {
        userService.saveUser(user);
    }
}
