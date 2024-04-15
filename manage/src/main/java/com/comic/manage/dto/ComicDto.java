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
public class ComicDto {

	private int id;
	
	private String title;
	private String image;
	private long view;
	private String description;
	private byte status;
	private long follow;
	
	private int categoryId;
}
