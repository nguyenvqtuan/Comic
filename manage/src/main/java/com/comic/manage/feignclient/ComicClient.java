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

import com.comic.manage.dto.ComicDto;

@FeignClient(name="comic", url="http://localhost:8081/comic")
public interface ComicClient {

	@GetMapping("")
	public ResponseEntity<List<ComicDto>> findAll();
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ComicDto>> findById(@PathVariable Integer id);
	
	@PostMapping("")
	public ResponseEntity<String> add(@RequestBody ComicDto categoryDto);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody ComicDto categoryDto);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id);
}
