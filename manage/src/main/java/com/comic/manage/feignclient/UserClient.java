package com.comic.manage.feignclient;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.comic.manage.dto.UserDto;

@FeignClient(name="user",url="http://localhost:8081/user")
public interface UserClient {

	@GetMapping("/{userName}")
	Optional<UserDto> findByUserName(@PathVariable String userName);
}
