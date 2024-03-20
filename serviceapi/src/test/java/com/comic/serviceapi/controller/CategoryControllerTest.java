package com.comic.serviceapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.comic.serviceapi.dto.CategoryDto;
import com.comic.serviceapi.service.CategoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value=CategoryController.class)
public class CategoryControllerTest {

	private static final String END_POINT = "/category";
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@MockBean
	private CategoryService categoryService;
	
	@Test
	public void findAllWithSuccess() throws Exception {
		mockMvc.perform(get(END_POINT)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void findByIdWithSuccess() throws Exception {
		Integer categoryId = 101;
		String requestURI = END_POINT + "/" + categoryId;
		mockMvc.perform(get(requestURI)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test
	public void addReturnCreated() throws Exception {
		CategoryDto categoryDto = CategoryDto.builder()
				.name("name").description("description").idCategory(1).build();

		String requestBody = objectMapper.writeValueAsString(categoryDto);
		mockMvc.perform(post(END_POINT).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(requestBody))
		   .andExpect(status().isCreated());
	}
	
	@Test
	public void updateWithSuccess() throws Exception {
		CategoryDto categoryDto = CategoryDto.builder()
				.name("name").description("description").idCategory(1).build();
		String requestBody = objectMapper.writeValueAsString(categoryDto);
		
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
}
