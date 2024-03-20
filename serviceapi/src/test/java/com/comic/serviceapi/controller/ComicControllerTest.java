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

import com.comic.serviceapi.dto.ComicDto;
import com.comic.serviceapi.service.ComicService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value=ComicController.class)
public class ComicControllerTest {

	private static final String END_POINT = "/comic";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private ComicService service;
	
	@Test
	public void findAllWithSuccess() throws Exception {
		mockMvc.perform(get(END_POINT)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void findByIdWithSuccess() throws Exception {
		Integer comicId = 101;
		String requestURI = END_POINT + "/" + comicId;
		mockMvc.perform(get(requestURI)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void addReturnCreated() throws Exception {
		ComicDto comicDto = getComicDto();
		String requestBody = objectMapper.writeValueAsString(comicDto);
		mockMvc.perform(post(END_POINT).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(requestBody))
		   .andExpect(status().isCreated());
	}
	
	@Test
	public void updateWithSuccess() throws Exception {
		ComicDto comicDto = getComicDto();
		String requestBody = objectMapper.writeValueAsString(comicDto);
		
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
	
	private ComicDto getComicDto() {
		
		ComicDto comicDto = ComicDto.builder()
				.title("title").image("image.jpg")
				.description("description").status((byte) 1)
				.follow(1L).view(1L).build();
		return comicDto;

	}
}
