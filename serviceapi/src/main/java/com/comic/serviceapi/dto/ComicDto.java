package com.comic.serviceapi.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ComicDto {

	private int id;
	
	private String title;
	private String image;
	private long view;
	private String description;
	private byte status;
	private String statusStr;
	private long follow;
	
	private int categoryId;
	private String categoryName;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
	
	private int countChapter;
}
