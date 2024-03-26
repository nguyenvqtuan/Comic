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

import com.comic.manage.dto.ComicChapterDto;

@FeignClient(name = "comic-chapter", url="http://localhost:8081/comic/chapter")
public interface ComicChapterClient {

	@GetMapping("")
	public ResponseEntity<List<ComicChapterDto>> findAll();
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ComicChapterDto>> findById(@PathVariable Integer id);
	
	@PostMapping("")
	public ResponseEntity<String> add(@RequestBody ComicChapterDto comicChapterDto);
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id, @RequestBody ComicChapterDto categoryDto);
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id);

	@PostMapping("/{id}/upload")
	public ResponseEntity<String> uploadContent(@PathVariable Integer id, @RequestParam String content);
}
