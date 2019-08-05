package com.hotel.users.request;

import java.io.Serializable;

public class LoginRequest implements Serializable{

	private static final long serialVersionUID = -8849773137406028113L;
    private String emailId;
    private String password;
    
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
