package com.comic.serviceapi.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.UserDto;
import com.comic.serviceapi.entity.UserEntity;
import com.comic.serviceapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper model;
	
	public Optional<UserDto> findByUserName(String userName) {
		return userRepo.findByUserName(userName).map(e -> toUserDto(e));
	}
	
	private UserDto toUserDto(UserEntity userEntity) {
		return model.map(userEntity, UserDto.class);
	}
	
	private UserEntity toUserEntity(UserDto userDto) {
		return model.map(userDto, UserEntity.class);
	}
}
