package com.spring.app.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.ws.io.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	public User  findByEmail(String email);
}