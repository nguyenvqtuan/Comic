package com.comic.serviceapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.comic.serviceapi.dto.UserDto;
import com.comic.serviceapi.service.UserService;

@RestController("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{userName}")
	public ResponseEntity<?> find(@PathVariable String userName) {
		Optional<UserDto> user = userService.findByUserName(userName);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
