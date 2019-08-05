package com.hotel.users.service;

import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hotel.users.bean.UserBean;
import com.hotel.users.dto.UserDTO;
import com.hotel.users.repo.IUsersRepositry;

@Service
public class UserServiceImpl implements UsersService{

	@Autowired
	IUsersRepositry usersRepo;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDTO saveUser(UserBean user) {
		UserDTO userto = new UserDTO();
		BeanUtils.copyProperties(user, userto);
		userto.setUserId(UUID.randomUUID().toString());
		userto.setEncrptPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		usersRepo.save(userto);
		return userto;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userto = new UserDTO();
		userto = usersRepo.findByEmailId(username);
		return userto;
	}

}
