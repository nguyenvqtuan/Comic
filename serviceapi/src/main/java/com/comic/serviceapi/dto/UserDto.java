package com.comic.serviceapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class UserDto {

	private String userName;
	private String fullName;
	private String password;
	private boolean enable;
	private String role;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
