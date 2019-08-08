package com.hotel.users.securtiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.hotel.users.service.UsersService;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private Environment environment;
	private UsersService usersService;
	private BCryptPasswordEncoder bCryptoPasswordEncoder;
	@Autowired
	public WebSecurity(Environment environment,UsersService usersService,BCryptPasswordEncoder bCryptoPasswordEncoder) {
		this.environment = environment;
		this.usersService = usersService;
		this.bCryptoPasswordEncoder=bCryptoPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/users/**").permitAll().and().addFilter(getAuthenticationFilter());
		http.headers().frameOptions().disable();

	}
	

	@SuppressWarnings("unused")
	private AuthenticationFilter getAuthenticationFilter() throws Exception {
		AuthenticationFilter authFilter = new AuthenticationFilter(environment,usersService,authenticationManager());
		authFilter.setFilterProcessesUrl("/userLogin");
		authFilter.setAuthenticationManager(authenticationManager());
		return authFilter;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.userDetailsService(usersService).passwordEncoder(bCryptoPasswordEncoder);
	}
}
