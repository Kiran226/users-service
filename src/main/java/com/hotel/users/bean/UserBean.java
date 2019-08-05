package com.hotel.users.bean;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1787065778963782583L;
    @NotNull(message = "EmailId Cannot be null")
    @Email(message = "Incorrect Email")
    @Size(min=12)
	private String emailId;
    @NotNull(message = "First Name Cannot be null")
	private String firstName;
    @NotNull(message = "last Name Cannot be null")
	private String lastName;
    @NotNull(message = "Password Cannot be null")
    @Size(min = 8, max = 15,message = "Password length should be min 8 and max 15 characters")
	private String password;
	private Long   id;
	private String userId;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
