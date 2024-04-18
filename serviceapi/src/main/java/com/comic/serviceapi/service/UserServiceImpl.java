package com.comic.serviceapi.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.UserDto;
import com.comic.serviceapi.entity.UserEntity;
import com.comic.serviceapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private static final String ROLE_USER = "USER";
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private ModelMapper model;
	
	public Optional<UserDto> findByUserName(String userName) {
		return userRepo.findByUserName(userName).map(e -> toUserDto(e));
	}
	
	@Override
	public void store(UserDto userDto) {
		UserEntity userEntity = toUserEntity(userDto);
		userRepo.save(userEntity);
	}
	
	private UserDto toUserDto(UserEntity userEntity) {
		return model.map(userEntity, UserDto.class);
	}
	
	private UserEntity toUserEntity(UserDto userDto) {
		UserEntity res = model.typeMap(UserDto.class, UserEntity.class)
		.addMappings(mapper -> {
			mapper.map(src -> ROLE_USER, UserEntity::setRole);
			mapper.map(src-> 1, UserEntity::setEnable);
		})
		.map(userDto);
		res.setPassword(passwordEncoder.encode(userDto.getPassword()));
		return res;
	}
}
