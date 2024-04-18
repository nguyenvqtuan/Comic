package com.comic.serviceapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.comic.serviceapi.dto.JwtResponseDto;
import com.comic.serviceapi.dto.UserDto;
import com.comic.serviceapi.service.JwtService;
import com.comic.serviceapi.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserService userService;

	@Autowired
	private JwtService jwtService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody UserDto userDto) {
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(userDto.getUserName(), userDto.getPassword()));

		if (authentication.isAuthenticated()) {
			JwtResponseDto token = JwtResponseDto.builder().accessToken(jwtService.GenerateToken(userDto.getUserName()))
					.build();
			return ResponseEntity.ok().body(token);
		}
		return ResponseEntity.badRequest().body("BAD REQUEST!");
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ResponseEntity<?> signup(@RequestBody UserDto userDto) {
		if (userService.findByUserName(userDto.getUserName()).isPresent()) {
			return ResponseEntity.badRequest().body("User name exists!");
		}
		userService.store(userDto);
		JwtResponseDto token = JwtResponseDto.builder().accessToken(jwtService.GenerateToken(userDto.getUserName()))
				.build();
		return ResponseEntity.status(HttpStatus.CREATED).body(token);
	}
}
