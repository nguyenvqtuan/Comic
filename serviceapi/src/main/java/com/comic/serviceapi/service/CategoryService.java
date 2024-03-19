package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import com.comic.serviceapi.dto.CategoryDto;

public interface CategoryService {

	public void store(CategoryDto categoryDto);
	public void delete(CategoryDto categoryDto);
	
	public Optional<CategoryDto> findById(Integer id);
	public List<CategoryDto> findAll();
	public List<CategoryDto> findByNameContains(String name);
	public Optional<CategoryDto> findByName(String name);
}
