package com.hotel.users.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotel.users.dto.UserDTO;

@Repository
public interface IUsersRepositry extends CrudRepository<UserDTO, Long>{

	public UserDTO findByEmailId(String emailId);
	
}
