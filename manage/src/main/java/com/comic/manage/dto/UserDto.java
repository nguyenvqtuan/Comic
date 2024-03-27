package com.comic.manage.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDto {
	private String userName;
	private String fullName;
	private String password;
	private boolean enable;
	private String role;
}
