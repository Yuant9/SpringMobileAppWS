package com.spring.app.ws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")   //https://localhost:8080/users
public class UserController {
	@GetMapping
	public String getUser() {
		return "get user was called";
	}

}
