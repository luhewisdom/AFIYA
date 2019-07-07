package com.android.rest.configrations;


import com.android.rest.configrations.JWT.JwtSecurityConfigurer;
import com.android.rest.configrations.JWT.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private NoOpPasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider jwtTokenProvider;

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


		 http.csrf().disable().sessionManagement()
				 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				 .authorizeRequests()
				 .antMatchers("/hospital/**").permitAll()
				 .antMatchers("/user/**").hasAuthority("SUPER")
				 .antMatchers("/staff/**").hasAuthority("STAFF")
				 .antMatchers("/appoint/**").hasAuthority("client")
				 .and()
				 .exceptionHandling()
				 .authenticationEntryPoint(restAuthenticationEntryPoint)
				 .and()
				 .logout()
				 .logoutSuccessHandler(logoutSuccessHandler())
				 .and()
				 .apply(new JwtSecurityConfigurer(jwtTokenProvider));
	  }
	 @Override
	 public void configure(WebSecurity webSecurity) throws Exception {
		 
		 webSecurity.ignoring()
		 			.antMatchers("/resources/**","/static/**","/css/**","/js/**","/images/**");
		 
	 }
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public LogoutSuccessHandler logoutSuccessHandler() {
		return new CustomLogoutSuccessHandler();
	}
	 
}