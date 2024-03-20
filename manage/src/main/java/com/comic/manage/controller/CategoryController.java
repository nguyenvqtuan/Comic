package com.comic.manage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		return "/category/edit.html";
	}
}
