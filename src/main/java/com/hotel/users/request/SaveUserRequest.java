package com.hotel.users.request;

import java.io.Serializable;

import com.hotel.users.bean.UserBean;

public class SaveUserRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 581675580781563862L;
	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
	
}
