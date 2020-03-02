package com.spring.app.ws.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.app.ws.controller.service.UserService;
import com.spring.app.ws.model.request.UserDetailsRequest;
import com.spring.app.ws.response.ErrorMessage;
import com.spring.app.ws.response.UserDetail;
import com.spring.app.ws.shared.dto.UserDto;

@RestController
@RequestMapping("users")   //https://localhost:8080/users
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping(path="/{id}",produces = {MediaType.APPLICATION_XML_VALUE,
			MediaType.APPLICATION_JSON_VALUE})
	public UserDetail getUser(@PathVariable String id) {
		UserDetail userDetail = new UserDetail();
		UserDto userDto = userService.getUserById(id);
		BeanUtils.copyProperties(userDto, userDetail);
		return userDetail;
	}
	
	@PostMapping
	(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
	consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserDetail createUser(@RequestBody UserDetailsRequest userDetailRequest)throws  Exception 
	{
		if(userDetailRequest.getFirstName()==null)throw new Exception(ErrorMessage.MISSING_REQUIRED_FILED.getErrorMessage());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailRequest, userDto);
		UserDto createdUser = userService.createUser(userDto);
	
		UserDetail returnValue = new UserDetail();
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	@PutMapping
	(path="/{id}",produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE},
	consumes = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public UserDetail UpdateUser(@RequestBody UserDetailsRequest userDetailRequest,@PathVariable String id)throws  Exception 
	{
		if(userDetailRequest.getFirstName()==null)throw new Exception(ErrorMessage.MISSING_REQUIRED_FILED.getErrorMessage());
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetailRequest, userDto);
		UserDto createdUser = userService.updateUser(id,userDto);
	
		UserDetail returnValue = new UserDetail();
		BeanUtils.copyProperties(createdUser, returnValue);
		
		return returnValue;
	}
	
	@DeleteMapping
	(path="/{id}")
	public Boolean DeleteUser(@PathVariable String id) {
		userService.deleteUser(id);
		return true;
	}
	
	@GetMapping
	(produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List<UserDetail> getUsers(@RequestParam (value = "page",defaultValue = "1")int page, 
			@RequestParam (value="limit",defaultValue="10")int limit){
		List <UserDto> users = userService.getUsers(page,limit);
		
		List <UserDetail> returnUsers = new ArrayList<>();

		for(UserDto userDto : users) {
			UserDetail userDetail = new UserDetail();
			BeanUtils.copyProperties(userDto, userDetail);
			returnUsers.add(userDetail);
		}
		return returnUsers;
	}

}
