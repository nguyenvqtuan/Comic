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

import com.comic.serviceapi.dto.ComicChapterDto;
import com.comic.serviceapi.service.ComicChapterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comic/chapter")
@Slf4j
public class ComicChapterController {
	@Autowired
	private ComicChapterService comicChapterService;
	
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<ComicChapterDto>> findAll(
			@RequestParam(name="q", defaultValue="") String name) {
		List<ComicChapterDto> comicChapterDtos = comicChapterService.findByTitleContains(name);
		return ResponseEntity.status(HttpStatus.OK).body(comicChapterDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ComicChapterDto>> findById(@PathVariable Integer id) {
		Optional<ComicChapterDto> comicChapterDto = comicChapterService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(comicChapterDto);
	}
	
	@PostMapping("")
	public ResponseEntity<String> save(@RequestBody ComicChapterDto comicChapterDto) {
		Optional<ComicChapterDto> comicChapterByTitle = comicChapterService.findByTitle(comicChapterDto.getTitle());
		if (comicChapterByTitle.isPresent()) {
			log.info("Title is exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title is exists!");
		}
		
		log.info("Create comic chapter success!");
		comicChapterService.store(comicChapterDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Create Comic Chapter success!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,
			@RequestBody ComicChapterDto comicChapterDto) {
		Optional<ComicChapterDto> comicByTitle = comicChapterService.findByTitle(comicChapterDto.getTitle());
		if (comicByTitle.isPresent() && !comicChapterDto.getTitle().equals(comicByTitle.get().getTitle())) {
			log.info("Title is exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title is exists!");
		}
		
		comicChapterDto.setId(id);
		comicChapterService.store(comicChapterDto);
		log.info("Update comic chapter success!");
		return ResponseEntity.status(HttpStatus.OK).body("Update is success");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		Optional<ComicChapterDto> comicChapterByTitle = comicChapterService.findById(id);
		
		if (comicChapterByTitle.isEmpty()) {
			log.info("Comic chapter doesn't exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comic Chapter doesn't exists");
		}
		
		comicChapterService.delete(comicChapterByTitle.get());
		log.info("Delete comic chapter success!");
		return ResponseEntity.status(HttpStatus.CREATED).body("Delete Comic Chapter success!");
	}
	
}
