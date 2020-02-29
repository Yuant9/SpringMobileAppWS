package com.spring.app.ws.service.iml;

import java.util.ArrayList;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.app.ws.controller.service.UserService;
import com.spring.app.ws.io.entity.Users;
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
		Users  userEntity = new  Users();
		BeanUtils.copyProperties(userDto, userEntity);
		
		userEntity.setEncryptedPassword(bcrypt.encode(userDto.getPassword()));
		userEntity.setUserId(utils.generateRandomString(10));

		Users storedUser = userRepo.save(userEntity);
		UserDto returnUser = new UserDto();
		BeanUtils.copyProperties(storedUser, returnUser);
		
		return returnUser;
	}
	
	/**get UserDto object by finding user entity from database, 
	 * then convert to userDto by copy properties 
	 */
	@Override
	public UserDto getUser(String email) {
		Users  user = userRepo.findByEmail(email);
		if(user  == null) {
			throw new UsernameNotFoundException(email);
		}
		UserDto returnUser = new UserDto();
		BeanUtils.copyProperties(user,returnUser);
		return returnUser;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users  user = userRepo.findByEmail(email);
		if(user==null) throw new UsernameNotFoundException(email);
		return new User(user.getEmail(),user.getEncryptedPassword(),new ArrayList<>());
	}}
