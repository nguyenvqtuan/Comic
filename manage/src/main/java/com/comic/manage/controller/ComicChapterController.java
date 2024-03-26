package com.comic.manage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comic.manage.dto.ComicChapterDto;
import com.comic.manage.feignclient.ComicChapterClient;
import com.comic.manage.service.GoogleDriveService;

@Controller
@RequestMapping("/comic/chapter")
public class ComicChapterController {

	@Autowired
	private GoogleDriveService googleDriveService;
	
	@Autowired
	private ComicChapterClient comicChapterClient;
	
	@GetMapping("")
	public String index(Model model) {
		ResponseEntity<List<ComicChapterDto>> comicChapters = comicChapterClient.findAll();
		model.addAttribute("comicChapters", comicChapters.getBody());
		return "/comic-chapter/table.html";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("comicChapter", new ComicChapterDto());
		model.addAttribute("comicChapters", comicChapterClient.findAll().getBody());
		return "/comic-chapter/add.html";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, 
			Model model) {
		Optional<ComicChapterDto> comicChapter = comicChapterClient.findById(id).getBody();
		
		if (comicChapter.isEmpty()) {
			return "redirect:/comic/chapter";
		}
		model.addAttribute("comicChapter", comicChapter.get());
		model.addAttribute("comicChapters", comicChapterClient.findAll().getBody());
		return "/comic-chapter/edit.html";
	}
	
	@GetMapping("/{id}/upload")
	public String uploadForm(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		return "comic-chapter/upload.html";
	}
	
	@PostMapping(value="")
	public String insert(@ModelAttribute ComicChapterDto comicChapterDto, RedirectAttributes redir) {
		ResponseEntity<String> added = comicChapterClient.add(comicChapterDto);
		redir.addFlashAttribute("message", added.getBody());
		return "redirect:/comic/chapter";
	}
	
	@PutMapping(value="/{id}")
	public String update(@PathVariable Integer id, 
			@ModelAttribute ComicChapterDto comicChapterDto, 
			@RequestParam("file") MultipartFile file, RedirectAttributes redir) {
		Optional<ComicChapterDto> comicChapter = comicChapterClient.findById(id).getBody();
		comicChapterDto.setContent(comicChapter.get().getContent());
		ResponseEntity<String> updated = comicChapterClient.update(id, comicChapterDto);
		redir.addFlashAttribute("message", updated.getBody());

		return "redirect:/comic/chapter";
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attr) {
		Optional<ComicChapterDto> comicChapter = comicChapterClient.findById(id).getBody();
		Arrays.asList(comicChapter.get().getContent().split(";")).stream().forEach(f -> {
			googleDriveService.deleteFile(f);
		});
		ResponseEntity<String> delete = comicChapterClient.delete(id);
		attr.addFlashAttribute("message", delete.getBody());
		
		return "redirect:/comic/chapter";
	}
	
	@PostMapping(value="/upload")
	@ResponseBody
	public ResponseEntity<?> upload(@RequestParam("myfile") MultipartFile[] files) {
		StringBuilder fileNames = new StringBuilder();
		Arrays.asList(files).stream().forEach(f -> {
			String fileId = googleDriveService.uploadFile(f);
			fileNames.append(fileId + ";");
		});
		return ResponseEntity.status(HttpStatus.OK).body(fileNames.toString());
	}
	
	
	@PostMapping(value="/{id}/upload")
	public String upload(@PathVariable Integer id, 
			@RequestParam String content, RedirectAttributes redir) {
		// Remove all content previous
		ComicChapterDto comicChapter = comicChapterClient.findById(id).getBody().get();
		Arrays.asList(comicChapter.getContent().split(";")).stream().forEach(f -> {
			googleDriveService.deleteFile(f);
		});
		
		redir.addFlashAttribute("message", "Upload success");
		comicChapterClient.uploadContent(id, content);
		return "redirect:/comic/chapter";
	}
}
