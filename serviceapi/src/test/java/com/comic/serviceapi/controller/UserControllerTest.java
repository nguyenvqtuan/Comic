package com.comic.serviceapi.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.comic.serviceapi.service.UserService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value=UserController.class)
public class UserControllerTest {

private static final String END_POINT = "/user";
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	@Test
	public void findByUserNameWithSuccess() throws Exception {
		String userName = "userName";
		String requestURI = END_POINT + "/" + userName;
		mockMvc.perform(get(requestURI)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
}
