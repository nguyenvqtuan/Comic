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

@FeignClient(name = "comic-chapter", url="http://localhost:8081/comic/")
public interface ComicChapterClient {

	@GetMapping("{comicId}/chapter")
	public ResponseEntity<List<ComicChapterDto>> findAll(@PathVariable Integer comicId);
	
	@GetMapping("{comicId}/chapter/{id}")
	public ResponseEntity<Optional<ComicChapterDto>> findById(@PathVariable Integer comicId, @PathVariable Integer id);
	
	@PostMapping("{comicId}/chapter")
	public ResponseEntity<String> add(@PathVariable Integer comicId, @RequestBody ComicChapterDto comicChapterDto);
	
	@PutMapping("{comicId}/chapter/{id}")
	public ResponseEntity<String> update(@PathVariable Integer comicId, @PathVariable Integer id, @RequestBody ComicChapterDto categoryDto);
	
	@DeleteMapping("{comicId}/chapter/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer comicId, @PathVariable Integer id);

	@PostMapping("{comicId}/chapter/{id}/upload")
	public ResponseEntity<String> uploadContent(@PathVariable Integer comicId, @PathVariable Integer id, @RequestParam String content);
}
