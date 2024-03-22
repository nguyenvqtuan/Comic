package com.comic.manage.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.comic.manage.service.GoogleDriveService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private GoogleDriveService googleDriveService;
	
	@GetMapping("")
	public String all() throws Exception {
		googleDriveService.getFiles();
		return "/test/index.html";
	}
	
	@PostMapping("")
	public String upload(@RequestParam("file") MultipartFile multipartFile) {
		googleDriveService.uploadFile(multipartFile);
		return "redirect:/test";
	}
	
	@GetMapping("/a")
	public String test() throws GeneralSecurityException, IOException {
		googleDriveService.findById();
		return "/test/index.html";
	}
}
