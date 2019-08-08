package com.hotel.users.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.hotel.users.bean.UserBean;
import com.hotel.users.dto.UserDTO;

public interface UsersService extends UserDetailsService{

	
	public UserDTO saveUser(UserBean user);
	
	public UserDTO loadUserByEmailId(String emailId);

}
