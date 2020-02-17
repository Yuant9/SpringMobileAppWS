package com.spring.app.ws.controller.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	public UserDto createUser(UserDto userDto);

}
