package com.spring.app.ws.service.iml;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.app.ws.controller.service.UserService;
import com.spring.app.ws.io.entity.Users;
import com.spring.app.ws.repository.UserRepository;
import com.spring.app.ws.response.UserDetail;
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
	public UserDto getUserById(String id) {
		Users user = userRepo.findByUserId(id);
		
		if(user == null) {
			throw new UsernameNotFoundException(id);
		}
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(user, userDto);
		return userDto;
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users  user = userRepo.findByEmail(email);
		if(user==null) throw new UsernameNotFoundException(email);
		return new User(user.getEmail(),user.getEncryptedPassword(),new ArrayList<>());
	}
	
	@Override
	public UserDto updateUser(String id, UserDto userDto) {
		Users user = userRepo.findByUserId(id);
		
		if(user == null) {
			throw new UsernameNotFoundException(id);
		};
		
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());

		Users storedUser = userRepo.save(user);
		UserDto returnUser = new UserDto();

		BeanUtils.copyProperties(storedUser, returnUser);
		
		return returnUser;
	}
	
	@Override
	public void deleteUser(String id) {
		Users user = userRepo.findByUserId(id);
		
		if(user == null) {
			throw new UsernameNotFoundException(id);
		};
		
		userRepo.delete(user);
		
	}
	
	@Override
	public List<UserDto> getUsers(int page, int limit){
		Pageable pageable = PageRequest.of(page, limit);
		Page<Users> userPage = userRepo.findAll(pageable);
		List<Users> users  = userPage.getContent();
		List<UserDto>  returnUsers = new ArrayList<>();
		
		for(Users userDto : users) {
			UserDto userDetail = new UserDto();
			BeanUtils.copyProperties(userDto, userDetail);
			returnUsers.add(userDetail);
		}
		return returnUsers;
	}
	
}
