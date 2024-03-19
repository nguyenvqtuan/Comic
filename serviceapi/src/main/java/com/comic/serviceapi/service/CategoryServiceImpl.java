package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.CategoryDto;
import com.comic.serviceapi.entity.CategoryEntity;
import com.comic.serviceapi.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void store(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = toCategoryEntity(categoryDto);
		categoryRepo.save(categoryEntity);
	}

	@Override
	public void delete(CategoryDto categoryDto) {
		CategoryEntity categoryEntity = toCategoryEntity(categoryDto);
		categoryRepo.delete(categoryEntity);
	}

	@Override
	public Optional<CategoryDto> findById(Integer id) {
		return categoryRepo.findById(id).map(e -> toCategoryDto(e));
	}

	@Override
	public List<CategoryDto> findAll() {
		return categoryRepo.findAll().stream().map(e -> toCategoryDto(e)).toList();
	}

	@Override
	public List<CategoryDto> findByNameContains(String name) {
		return categoryRepo.findByNameContains(name).stream().map(e -> toCategoryDto(e)).toList();
	}
	
	@Override
	public Optional<CategoryDto> findByName(String name) {
		return categoryRepo.findByName(name).map(e -> toCategoryDto(e));
	}

	private CategoryEntity toCategoryEntity(CategoryDto categoryDto) {
		return modelMapper.map(categoryDto, CategoryEntity.class);
	}
	
	private CategoryDto toCategoryDto(CategoryEntity categoryEntity) {
		return modelMapper.map(categoryEntity, CategoryDto.class);
	}
}
