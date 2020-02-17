package com.spring.app.ws.service.iml;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder bcrypt;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		if(userRepo.findByEmail(userDto.getEmail())!=null)throw new RuntimeException("user already exists!");
		User  userEntity = new  User();
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setEncryptedPassword(bcrypt.encode(userDto.getPassword()));;
		userEntity.setUserId(utils.generateRandomString(10));

		User storedUser = userRepo.save(userEntity);
		UserDto returnUser = new UserDto();
		BeanUtils.copyProperties(storedUser, returnUser);
		
		return returnUser;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}}
