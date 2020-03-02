package com.spring.app.ws.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.spring.app.ws.io.entity.Users;

@Repository
public interface UserRepository extends PagingAndSortingRepository<Users, Long> {

	public Users  findByEmail(String email);

	public Users findByUserId(String userId);
}