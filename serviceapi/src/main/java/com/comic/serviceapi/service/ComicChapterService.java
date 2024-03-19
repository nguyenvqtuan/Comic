package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import com.comic.serviceapi.dto.ComicChapterDto;

public interface ComicChapterService {

	public void store(ComicChapterDto ComicChapterDto);
	public void delete(ComicChapterDto ComicChapterDto);
	
	public Optional<ComicChapterDto> findById(Integer id);
	public List<ComicChapterDto> findAll();
	public List<ComicChapterDto> findByTitleContains(String title);
	public Optional<ComicChapterDto> findByTitle(String title);
}
