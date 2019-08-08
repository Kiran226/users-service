package com.hotel.users.securtiy;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.users.dto.UserDTO;
import com.hotel.users.request.LoginRequest;
import com.hotel.users.service.UsersService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {


	private Environment environment;
	private UsersService usersService;

	public AuthenticationFilter(Environment environment,UsersService usersService,AuthenticationManager authManager) {
		this.environment = environment;
		this.usersService = usersService;
		this.setAuthenticationManager(authManager);
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		try {
			LoginRequest loginReq = new ObjectMapper().readValue(request.getInputStream(), LoginRequest.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(
					loginReq.getEmailId(), loginReq.getPassword(), new ArrayList<>()));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		String emailId = ((User) authResult.getPrincipal()).getUsername();
		UserDTO userDto = usersService.loadUserByEmailId(emailId);
		String jwt =Jwts.builder().setSubject(userDto.getUserId()).setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(environment.getProperty("jwt.expiration.time"))))
		                .signWith(SignatureAlgorithm.HS384, environment.getProperty("jwt.secretkey"))
		                .compact();
		response.setHeader("token", jwt);
		response.setHeader("UserId", userDto.getUserId());
	}
}
