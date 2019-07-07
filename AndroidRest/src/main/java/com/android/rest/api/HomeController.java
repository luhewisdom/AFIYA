package com.android.rest.api;


import com.android.rest.configrations.JWT.JwtTokenProvider;
import com.android.rest.domain.Hospital;
import com.android.rest.domain.HospitalModel;
import com.android.rest.domain.User;
import com.android.rest.service.HospitalService;
import com.android.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path="/",produces="application/json")
@CrossOrigin(origins="*")
public class HomeController {

    @Autowired
    private UserService userService;
    @Autowired
    private HospitalService hospitalService;
    @Autowired
    JwtTokenProvider jwtTokenProvider;
    @Autowired
    AuthenticationManager authenticationManager;


    @GetMapping("/access-denied")
    public String accessDenied(){
        return "access_denied";
    }



    @PostMapping("/login")
    public ResponseEntity signin(@RequestParam(name = "username") String username , @RequestParam(name = "password") String password ) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            String token = jwtTokenProvider.createToken(username, userService.findUserByUsername(username).getRoles());
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUsername(username);
            loginResponse.setToken(token);
            return new ResponseEntity<>(loginResponse, HttpStatus.OK);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }


    @PostMapping(path = "/registerClient",consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@Valid @RequestBody User user)
    {
        userService.saveUser(user);
    }

    @GetMapping
    public Iterable<HospitalModel> allHospital()
    {
        return HospitalModel.getHosoopitalModel((List<Hospital>) hospitalService.findAll());
    }
}
