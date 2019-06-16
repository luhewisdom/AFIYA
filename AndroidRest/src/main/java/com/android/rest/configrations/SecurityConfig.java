package com.android.rest.configrations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private NoOpPasswordEncoder passwordEncoder;



	@Autowired
	private UserDetailsService userDetailsService;


	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	private MySavedRequestAwareAuthenticationSuccessHandler mySavedRequestAwareAuthenticationSuccessHandler;

	  @Override
	  protected void configure(AuthenticationManagerBuilder auth)
	      throws Exception {
		  auth.userDetailsService(userDetailsService)
		  .passwordEncoder(passwordEncoder);
		  auth.inMemoryAuthentication()
				  .withUser("admin").password(passwordEncoder.encode("adminPass")).roles("SUPER");
	  } 
	  
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {


		// http.cors().and().csrf().disable();

		 http
				 .csrf().disable()
				 .exceptionHandling()
				 .authenticationEntryPoint(restAuthenticationEntryPoint)
				 .and()
				 .authorizeRequests()
				 .antMatchers("/").permitAll()
				 .antMatchers("/hospital").permitAll()
				 .antMatchers("/user").permitAll()
				 .antMatchers("/").authenticated()
				 .antMatchers("/api/admin/**").hasRole("ADMIN")
				 .and()
				 .formLogin()
				 .successHandler(mySavedRequestAwareAuthenticationSuccessHandler)
				 .failureHandler((AuthenticationFailureHandler) mySavedRequestAwareAuthenticationSuccessHandler)
				 .and()
				 .logout();

		     //.antMatchers("/api/hospital").hasAuthority("hospital");
	     	
	  }
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
		 
	 }

	 
}