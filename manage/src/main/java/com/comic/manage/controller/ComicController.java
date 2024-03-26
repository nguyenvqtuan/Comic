package com.comic.manage.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comic.manage.dto.ComicDto;
import com.comic.manage.feignclient.ComicClient;
import com.comic.manage.service.GoogleDriveService;

@Controller
@RequestMapping("/comic")
public class ComicController {

	@Autowired
	private GoogleDriveService googleDriveService;
	
	enum Status {
		NO_ACTION("No action"), IN_PROGRESS("In progress"),
		PENDING("Pending"), DONE("Done");
		String mess;
		Status(String mess) {
			this.mess = mess;
		}
	}
	
	@Autowired
	private ComicClient comicClient;
	
	@GetMapping("")
	public String index(Model model) {
		ResponseEntity<List<ComicDto>> comics = comicClient.findAll();
		model.addAttribute("comics", comics.getBody());
		return "/comic/table.html";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("comic", new ComicDto());
		model.addAttribute("comics", comicClient.findAll().getBody());
		model.addAttribute("statuses", getListStatus());
		return "/comic/add.html";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, 
			Model model) {
		Optional<ComicDto> comic = comicClient.findById(id).getBody();
		
		if (comic.isEmpty()) {
			return "redirect:/comic";
		}
		model.addAttribute("comic", comic.get());
		model.addAttribute("comics", comicClient.findAll().getBody());
		model.addAttribute("statuses", getListStatus());
		return "/comic/edit.html";
	}
	
	@PostMapping(value="")
	public String insert(@ModelAttribute ComicDto comicDto, 
			@RequestParam("file") MultipartFile file, RedirectAttributes redir) {
		String fileId = googleDriveService.uploadFile(file);
		comicDto.setImage(fileId);
		ResponseEntity<String> added = comicClient.add(comicDto);
		redir.addFlashAttribute("message", added.getBody());
		return "redirect:/comic";
	}
	
	@PutMapping(value="/{id}")
	public String update(@PathVariable Integer id, 
			@ModelAttribute ComicDto comicDto, 
			@RequestParam("file") MultipartFile file, RedirectAttributes redir) {
		Optional<ComicDto> comic = comicClient.findById(id).getBody();
		String imageFile = null == file ? comic.get().getImage() : googleDriveService.uploadFile(file);
		comicDto.setImage(imageFile);
		ResponseEntity<String> updated = comicClient.update(id, comicDto);
		redir.addFlashAttribute("message", updated.getBody());

		return "redirect:/comic";
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attr) {
		Optional<ComicDto> comic = comicClient.findById(id).getBody();
		googleDriveService.deleteFile(comic.get().getImage());
		
		ResponseEntity<String> delete = comicClient.delete(id);
		attr.addFlashAttribute("message", delete.getBody());
		
		return "redirect:/comic";
	}
	
	private List<String> getListStatus() {
		return Arrays.asList(Status.values()).stream().map(e -> e.mess).toList();
	}
}
