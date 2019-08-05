package com.hotel.users.response;

import java.io.Serializable;

import com.hotel.users.bean.UserBean;

public class SaveUserResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8026039629065926309L;
    private UserBean userBean;
    
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}
}
