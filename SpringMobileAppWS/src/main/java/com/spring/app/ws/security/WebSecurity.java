package com.spring.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.app.ws.controller.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	private final UserService userDetailsService ;
	private final BCryptPasswordEncoder bCryptpasswordEncoder ;
	private static final String SIGN_UP_URL = "/users/login";
	
	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptpasswordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.bCryptpasswordEncoder = bCryptpasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,SIGN_UP_URL)
		.permitAll().anyRequest().authenticated().and().addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS); 
		//tell http not to create http session, be statelesss,since
		//most APIs need to be authorized except login
	}
	
	//encode  password by BCryptPasswordEncoder
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptpasswordEncoder);
	}
	
	public AuthenticationFilter getAuthenticationFilter() throws Exception{
		final AuthenticationFilter filter  = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/users/login");
		return filter;
	}

	
}
