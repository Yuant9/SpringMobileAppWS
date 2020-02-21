package com.spring.app.ws.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users implements Serializable {

	private static final long serialVersionUID = -810883734542193706L;
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String userId;

	@Column(nullable=false,length = 30)
	private  String firstName;
	
	@Column(nullable=false,length = 30)
	private String lastName;
	
	@Column(nullable=false,length =100)
	private String email;
	
	@Column(nullable=false)
	private String password;
	
	@Column(nullable=false)
	private String encryptedPassword;
	
	private String emailverificationToken;
	
	@Column(nullable=false)
	private Boolean emailVerificationStatus = false;
	
	
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

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

}
