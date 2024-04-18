package com.comic.serviceapi.service;

import java.util.Optional;

import com.comic.serviceapi.dto.UserDto;

public interface UserService {

	Optional<UserDto> findByUserName(String userName);
	void store(UserDto userDto);
}
