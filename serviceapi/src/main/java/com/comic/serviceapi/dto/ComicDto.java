package com.comic.serviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComicDto {

private int id;
	
	private String title;
	private String image;
	private long view;
	private String description;
	private byte status;
	private long follow;
}