package com.spring.app.ws.shared.dto;

import java.io.Serializable;

/**
 * user database transfer object
 * @author yuan
 *
 */
public class UserDto implements Serializable{
	
	private static final long serialVersionUID = -2850463152438707411L;
	private long id;
	private String userId;
	private  String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encryptedPassword;
	private String emailverificationToken;
	private String emailVerificationStatus;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEncryptedPassword() {
		return encryptedPassword;
	}
	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}
	public String getEmailverificationToken() {
		return emailverificationToken;
	}
	public void setEmailverificationToken(String emailverificationToken) {
		this.emailverificationToken = emailverificationToken;
	}
	public String getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	public void setEmailVerificationStatus(String emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	
	
}
