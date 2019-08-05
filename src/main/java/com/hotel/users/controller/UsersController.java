package com.hotel.users.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.users.bean.UserBean;
import com.hotel.users.dto.UserDTO;
import com.hotel.users.request.SaveUserRequest;
import com.hotel.users.response.SaveUserResponse;
import com.hotel.users.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService userService;
	
    @GetMapping(path="/healthCheck") 
	 public String usersHealthCheck() {
		return "Users Service Instance";
	}
    @PostMapping
    public ResponseEntity<SaveUserResponse> saveUser(@Valid @RequestBody UserBean user) {
    	//UserBean user = req.getUserBean();
    	SaveUserResponse response= new SaveUserResponse();
    	UserDTO userto = userService.saveUser(user);
    	BeanUtils.copyProperties(userto, user);
    	response.setUserBean(user);
		return new ResponseEntity<SaveUserResponse>(response, HttpStatus.OK); 	
    }
}
