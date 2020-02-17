package com.spring.app.ws.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.ws.controller.service.UserService;
import com.spring.app.ws.model.request.UserDetailsRequest;
import com.spring.app.ws.response.UserDetail;
import com.spring.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("users")   //https://localhost:8080/users
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get user was called";
	}
	
	@PostMapping
	public UserDetail createUser(@RequestBody UserDetailsRequest userDetailRequest) {
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailRequest, userDto);
		UserDto createdUser = userService.createUser(userDto);
	
		UserDetail returnValue = new UserDetail();
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}

}
