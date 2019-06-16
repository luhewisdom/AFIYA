package com.android.rest.configrations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class PasswordEncoderConfig {
	
	
	@Bean
	 public NoOpPasswordEncoder passwordEncoder() 
	 {
	    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	 }

}
