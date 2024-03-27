package com.comic.manage.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.comic.manage.dto.UserDto;
import com.comic.manage.feignclient.UserClient;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserClient userClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = userClient.findByUserName(username)
	        		.orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
	        
		return new CustomUserDetails(user);
	}
}
