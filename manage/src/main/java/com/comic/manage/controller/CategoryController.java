package com.comic.manage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.comic.manage.dto.CategoryDto;
import com.comic.manage.feignclient.CategoryClient;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryClient categoryClient;
	
	@GetMapping("")
	public String index(@RequestParam(name="q", defaultValue="") String q,
			Model model) {
		ResponseEntity<List<CategoryDto>> categories = categoryClient.findAll(q);
		model.addAttribute("categories", categories.getBody());
		return "/category/table.html";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("category", new CategoryDto());
		model.addAttribute("categories", categoryClient.findAll("").getBody());
		return "/category/add.html";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, 
			Model model) {
		Optional<CategoryDto> category = categoryClient.findById(id).getBody();
		
		if (category.isEmpty()) {
			return "redirect:/category";
		}
		model.addAttribute("category", category.get());
		model.addAttribute("categories", categoryClient.findAll("").getBody());
		return "/category/edit.html";
	}
	
	@PostMapping(value="")
	@ResponseBody
	public ResponseEntity<?> insert(@RequestBody CategoryDto categoryDto) {
		return categoryClient.add(categoryDto);
	}
	
	@PostMapping(value="/{id}")
	@ResponseBody
	public ResponseEntity<?> update(@PathVariable Integer id, 
			@RequestBody CategoryDto categoryDto) {
		return categoryClient.update(id, categoryDto);
	}
	
	@DeleteMapping(value="/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes attr) {
		ResponseEntity<String> delete = categoryClient.delete(id);
		attr.addFlashAttribute("message", delete.getBody());
		return "redirect:/category";
	}
}
