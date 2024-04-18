package com.comic.serviceapi.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.comic.serviceapi.dto.UserDto;
import com.comic.serviceapi.entity.UserEntity;
import com.comic.serviceapi.repository.UserRepository;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper model;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepo.findByUserName(username)
        		.orElseThrow(() -> new UsernameNotFoundException("Could not find user"));
        
		return new CustomUserDetails(toUserDto(user));
	}
	
	private UserDto toUserDto(UserEntity userEntity) {
		return model.map(userEntity, UserDto.class);
	}
}
