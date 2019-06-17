package com.android.rest.configrations;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private NoOpPasswordEncoder passwordEncoder;

	@Autowired
	private CustomAccessDeniedHandler accessDeniedHandler;


	@Autowired
	private RestAuthenticationEntryPoint restAuthenticationEntryPoint;

	@Autowired
	private MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler;

	private SimpleUrlAuthenticationFailureHandler myFailureHandler = new SimpleUrlAuthenticationFailureHandler();

	@Autowired
	private UserDetailsService userDetailsService;



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.userDetailsService(userDetailsService)
				  .passwordEncoder(passwordEncoder);
	}
	  
	 @Override
	  protected void configure(HttpSecurity http) throws Exception {


		 http.csrf().disable()
				 .authorizeRequests()
				 .and()
				 .exceptionHandling()
				 .accessDeniedHandler(accessDeniedHandler)
				 .authenticationEntryPoint(restAuthenticationEntryPoint)
				 .and()
				 .authorizeRequests()
				 .antMatchers("/").permitAll()
				 .antMatchers("/hospitals").permitAll()
				 .antMatchers("/user").permitAll()
				 .antMatchers("/user/staff/**").hasAuthority("SUPER")
				 .and()
				 .formLogin()
				 .successHandler(mySuccessHandler)
				 .failureHandler(myFailureHandler)
				 .and()
				 .httpBasic()
				 .and()
				 .logout();


		     //.;
	     	
	  }
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
		 
	 }

	 
}