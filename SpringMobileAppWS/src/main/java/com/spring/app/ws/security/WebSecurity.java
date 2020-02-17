package com.spring.app.ws.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.spring.app.ws.controller.service.UserService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	private final UserService userDetailsService ;
	private final BCryptPasswordEncoder bCryptpasswordEncoder ;
	private static final String SIGN_UP_URL = "/users";
	
	public WebSecurity(UserService userDetailsService, BCryptPasswordEncoder bCryptpasswordEncoder) {
		super();
		this.userDetailsService = userDetailsService;
		this.bCryptpasswordEncoder = bCryptpasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST,SIGN_UP_URL)
		.permitAll().anyRequest().authenticated();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth)throws Exception{
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptpasswordEncoder);
	}

	
}
