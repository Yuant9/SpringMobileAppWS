package com.spring.app.ws.service.iml;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.ws.controller.service.UserService;
import com.spring.app.ws.io.entity.User;
import com.spring.app.ws.repository.UserRepository;
import com.spring.app.ws.shared.Utils;
import com.spring.app.ws.shared.dto.UserDto;


@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	Utils utils;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		if(userRepo.findByEmail(userDto.getEmail())!=null)throw new RuntimeException("user already exists!");
		User  userEntity = new  User();
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId(utils.generateRandomString(10));

		User storedUser = userRepo.save(userEntity);
		UserDto returnUser = new UserDto();
		BeanUtils.copyProperties(storedUser, returnUser);
		
		return returnUser;
	}}
