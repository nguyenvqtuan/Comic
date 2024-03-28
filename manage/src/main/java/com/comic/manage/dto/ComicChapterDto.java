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
public class ComicChapterDto {
	private int id;
	private int numOrder;
	private String title;
	private String content;
	private int comicId;
}
