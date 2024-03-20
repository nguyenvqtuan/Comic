package com.comic.manage.feignclient;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.comic.manage.dto.CategoryDto;

@FeignClient(value="category", url="http://localhost:8081/category")
public interface CategoryClient {

	@GetMapping("")
	public ResponseEntity<List<CategoryDto>> findAll(@RequestParam("q") String name);
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CategoryDto>> findById(@PathVariable Integer id);
	
	@PostMapping("")
	public ResponseEntity<String> add(@RequestBody CategoryDto categoryDto);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody CategoryDto categoryDto);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id);
}
