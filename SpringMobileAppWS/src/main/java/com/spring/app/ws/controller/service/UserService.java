package com.spring.app.ws.controller.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.app.ws.shared.dto.UserDto;

public interface UserService extends UserDetailsService{
	public UserDto createUser(UserDto userDto);
	public UserDto getUser(String email);
	public UserDto getUserById(String id);
	public UserDto updateUser(String id, UserDto userDto);
	public void deleteUser(String id);
	public List<UserDto> getUsers(int page, int limit);
		

}
