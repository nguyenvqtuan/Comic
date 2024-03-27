package com.comic.serviceapi.service;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.comic.serviceapi.entity.UserEntity;
import com.comic.serviceapi.repository.UserRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserServiceTest {

	@Mock
	UserRepository repository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	UserServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenFindByUserName_ShouldReturnEmpty() {
		Optional<UserEntity> user = Optional.empty();
		String userName = "userName";
		when(repository.findByUserName(userName)).thenReturn(user);
		service.findByUserName(userName);
		assertTrue(user.isEmpty());
		verify(repository).findByUserName(userName);
	}

}
