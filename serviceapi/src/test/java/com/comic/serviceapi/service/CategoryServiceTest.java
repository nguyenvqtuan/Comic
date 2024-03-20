package com.comic.serviceapi.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
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

import com.comic.serviceapi.dto.CategoryDto;
import com.comic.serviceapi.entity.CategoryEntity;
import com.comic.serviceapi.repository.CategoryRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class CategoryServiceTest {

	@Mock
	CategoryRepository repository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	CategoryServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenFindAll_shouldReturnList() {
		// 1. create mock data
		List<CategoryEntity> categories = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			categories.add(new CategoryEntity());
		}

		when(repository.findAll()).thenReturn(categories);
		List<CategoryDto> categoryDtos = service.findAll();
		assertThat(categoryDtos.size()).isEqualTo(categories.size());
		verify(repository).findAll();
	}

	@Test
	void whenFindById_ShouldReturnEmpty() {
		Optional<CategoryEntity> category = Optional.empty();
		int id = 1;
		when(repository.findById(id)).thenReturn(category);
		service.findById(id);
		assertTrue(category.isEmpty());
		verify(repository).findById(id);
	}

	@Test
	void whenAdd_ShouldSuccess() {
		CategoryDto categoryDto = getCategoryDto();
		CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);
		service.store(categoryDto);
		verify(repository, times(1)).save(categoryEntity);
	}
	
	@Test
	void whenDelete_ShouldSuccess() {
		CategoryDto categoryDto = getCategoryDto();
		CategoryEntity categoryEntity = modelMapper.map(categoryDto, CategoryEntity.class);
		service.delete(categoryDto);
		verify(repository, times(1)).delete(categoryEntity);
	}

	private CategoryDto getCategoryDto() {
		CategoryDto res = new CategoryDto();
		res.setName("name");
		res.setDescription("description");
		res.setIdCategory(1);
		return res;
	}
}
