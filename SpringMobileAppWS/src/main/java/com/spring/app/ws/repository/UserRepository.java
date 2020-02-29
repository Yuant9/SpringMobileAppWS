package com.spring.app.ws.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.ws.io.entity.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long> {

	public Users  findByEmail(String email);

	public Users findByUserId(String userId);
}