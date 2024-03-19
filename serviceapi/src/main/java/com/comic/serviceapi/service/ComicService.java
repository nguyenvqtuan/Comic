package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import com.comic.serviceapi.dto.ComicDto;

public interface ComicService {

	public void store(ComicDto comicDto);
	public void delete(ComicDto comicDto);
	public void changeStatus(Integer id, Byte status);
	
	public Optional<ComicDto> findById(Integer id);
	public List<ComicDto> findAll();
	public List<ComicDto> findByTitleContains(String title);
	public Optional<ComicDto> findByTitle(String title);
}
