package com.comic.serviceapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ComicChapterDto {
	
	private int id;
	private int numOrder;
	private String title;
	private String content;
}
