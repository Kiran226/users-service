package com.hotel.users.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class UserDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3335284457607936734L;
	@Id
	@GeneratedValue
    private Long   id;
	@Column(nullable = false,length = 120,unique = true)
	private String emailId;
	@Column(nullable = false,length = 50)
	private String firstName;
	@Column(nullable = false,length = 50)
	private String lastName;
	@Column(nullable = false)
	private String userId;
	@Column(nullable = false)
	private String encrptPassword;
	
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

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEncrptPassword() {
		return encrptPassword;
	}
	public void setEncrptPassword(String encrptPassword) {
		this.encrptPassword = encrptPassword;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
