package com.comic.serviceapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.comic.serviceapi.dto.CategoryDto;
import com.comic.serviceapi.service.CategoryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<CategoryDto>> findAll(
			@RequestParam(name="q", defaultValue="") String name) {
		List<CategoryDto> categoryDtos = categoryService.findByNameContains(name);
		return ResponseEntity.status(HttpStatus.OK).body(categoryDtos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<CategoryDto>> findById(@PathVariable Integer id) {
		Optional<CategoryDto> categoryDto = categoryService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(categoryDto);
	}
	
	@PostMapping("")
	public ResponseEntity<String> save(@RequestBody CategoryDto categoryDto) {
		Optional<CategoryDto> categoryByName = categoryService.findByName(categoryDto.getName());
		if (categoryByName.isPresent()) {
			log.info("Name exists!");
			return ResponseEntity.status(HttpStatus.IM_USED).body("Name is exists!");
		}
		
		log.info("Create category success!");
		categoryService.store(categoryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Create Category success!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,
			@RequestBody CategoryDto categoryDto) {
		Optional<CategoryDto> categoryByName = categoryService.findByName(categoryDto.getName());
		if (categoryByName.isPresent() && !categoryDto.getName().equals(categoryByName.get().getName())) {
			log.info("Name is exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Name is exists!");
		}
		
		categoryDto.setId(id);
		categoryService.store(categoryDto);
		log.info("Update category success!");
		return ResponseEntity.status(HttpStatus.OK).body("Update is success");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		Optional<CategoryDto> categoryByName = categoryService.findById(id);
		
		if (categoryByName.isEmpty()) {
			log.info("Create doesn't exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Category doesn't exists");
		}
		
		categoryService.delete(categoryByName.get());
		log.info("Delete category success!");
		return ResponseEntity.status(HttpStatus.CREATED).body("Delete Category success!");
	}
}
