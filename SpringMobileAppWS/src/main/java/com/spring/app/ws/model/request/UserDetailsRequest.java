package com.spring.app.ws.model.request;

public class UserDetailsRequest {
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	public String getPassword() {
		return password;
	}
	public void setUserId(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
