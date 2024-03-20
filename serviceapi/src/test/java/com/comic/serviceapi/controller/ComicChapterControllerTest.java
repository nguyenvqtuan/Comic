package com.comic.serviceapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.comic.serviceapi.dto.ComicChapterDto;
import com.comic.serviceapi.service.ComicChapterService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value=ComicChapterController.class)
public class ComicChapterControllerTest {
	
	private static final String END_POINT = "/comic/chapter";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ComicChapterService service;
	
	@Test
	public void findAllWithSuccess() throws Exception {
		mockMvc.perform(get(END_POINT)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void findByIdWithSuccess() throws Exception {
		Integer comicChapterId = 101;
		String requestURI = END_POINT + "/" + comicChapterId;
		mockMvc.perform(get(requestURI)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void addReturnCreated() throws Exception {
		ComicChapterDto comicChapterDto = getComicChapterDto();
		String requestBody = objectMapper.writeValueAsString(comicChapterDto);
		mockMvc.perform(post(END_POINT).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(requestBody))
		   .andExpect(status().isCreated());
	}
	
	@Test
	public void updateWithSuccess() throws Exception {
		ComicChapterDto comicChapterDto = getComicChapterDto();
		String requestBody = objectMapper.writeValueAsString(comicChapterDto);
		
		String requestUri = END_POINT + "/" + 1;
		mockMvc.perform(put(requestUri).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(requestBody))
		   .andExpect(status().isOk());
	}
	
	@Test
	public void deleteWithBadRequest() throws Exception {
		String requestUri = END_POINT + "/" + 1;
		mockMvc.perform(put(requestUri).accept(MediaType.APPLICATION_JSON))
		   .andExpect(status().isBadRequest());
	}
	
	private ComicChapterDto getComicChapterDto() {
		
		ComicChapterDto comicChapterDto = ComicChapterDto.builder()
				.title("title").content("abc.jpg,abc1.jpg")
				.numOrder(1).build();
		return comicChapterDto;

	}
}
