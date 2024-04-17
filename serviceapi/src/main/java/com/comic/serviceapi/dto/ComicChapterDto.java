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
public class ComicChapterDto {
	
	private int id;
	private int numOrder;
	private String title;
	private String content;
	private int comicId;
	
	private LocalDate createdAt;
	private LocalDate updatedAt;
}
