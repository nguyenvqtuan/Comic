package com.comic.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping("")
	public String index() {
		return "index.html";
	}
	
	@GetMapping("/table")
	public String table() {
		return "table.html";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form.html";
	}
}
