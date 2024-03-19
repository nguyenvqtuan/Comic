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

import com.comic.serviceapi.dto.ComicDto;
import com.comic.serviceapi.service.ComicService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/comic")
@Slf4j
public class ComicController {

	@Autowired
	private ComicService comicService;
	
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<ComicDto>> search(
			@RequestParam(value="q", defaultValue="") String title) {
		List<ComicDto> ComicDtos = comicService.findByTitleContains(title);
		return ResponseEntity.status(HttpStatus.OK).body(ComicDtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ComicDto>> findById(@PathVariable Integer id) {
		Optional<ComicDto> comicDto = comicService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(comicDto);
	}
	
	@PostMapping("")
	public ResponseEntity<String> save(@RequestBody ComicDto ComicDto) {
		Optional<ComicDto> comicByTitle = comicService.findByTitle(ComicDto.getTitle());
		if (comicByTitle.isPresent()) {
			log.info("Title exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title is exists!");
		}
		
		log.info("Create comic success!");
		comicService.store(ComicDto);
		return ResponseEntity.status(HttpStatus.CREATED).body("Create comic success!");
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<String> changeStatus(@PathVariable Integer id,
			@RequestParam(name="status", required=true) Byte status) {
		Optional<ComicDto> comicDto = comicService.findById(id);
		if (comicDto.isEmpty()) {
			log.info("Comic not found!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comic not found!");
		}
		comicService.changeStatus(id, status);
		return ResponseEntity.status(HttpStatus.OK).body("Change status success!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> update(@PathVariable Integer id,
			@RequestBody ComicDto ComicDto) {
		Optional<ComicDto> comicByTitle = comicService.findByTitle(ComicDto.getTitle());
		if (comicByTitle.isPresent() && !ComicDto.getTitle().equals(comicByTitle.get().getTitle())) {
			log.info("Title is exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Title is exists!");
		}
		
		ComicDto.setId(id);
		comicService.store(ComicDto);
		log.info("Update comic success!");
		return ResponseEntity.status(HttpStatus.OK).body("Update is success");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id) {
		Optional<ComicDto> comicByName = comicService.findById(id);
		
		if (comicByName.isEmpty()) {
			log.info("Create doesn't exists!");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("comic doesn't exists");
		}
		
		comicService.delete(comicByName.get());
		log.info("Delete comic success!");
		return ResponseEntity.status(HttpStatus.CREATED).body("Delete comic success!");
	}
}
