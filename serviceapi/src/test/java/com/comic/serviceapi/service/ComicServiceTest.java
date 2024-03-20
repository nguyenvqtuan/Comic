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

import com.comic.serviceapi.dto.ComicDto;
import com.comic.serviceapi.entity.ComicEntity;
import com.comic.serviceapi.repository.ComicRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ComicServiceTest {

	@Mock
	ComicRepository repository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	ComicServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenFindAll_shouldReturnList() {
		// 1. create mock data
		List<ComicEntity> comics = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			comics.add(new ComicEntity());
		}

		when(repository.findAll()).thenReturn(comics);
		List<ComicDto> comicDtos = service.findAll();
		assertThat(comicDtos.size()).isEqualTo(comics.size());
		verify(repository).findAll();
	}

	@Test
	void whenFindById_ShouldReturnEmpty() {
		Optional<ComicEntity> comic = Optional.empty();
		int id = 1;
		when(repository.findById(id)).thenReturn(comic);
		service.findById(id);
		assertTrue(comic.isEmpty());
		verify(repository).findById(id);
	}

	@Test
	void whenAdd_ShouldSuccess() {
		ComicDto comicDto = getComicDto();
		ComicEntity comicEntity = modelMapper.map(comicDto, ComicEntity.class);
		service.store(comicDto);
		verify(repository, times(1)).save(comicEntity);
	}
	
	@Test
	void whenDelete_ShouldSuccess() {
		ComicDto comicDto = getComicDto();
		ComicEntity comicEntity = modelMapper.map(comicDto, ComicEntity.class);
		service.delete(comicDto);
		verify(repository, times(1)).delete(comicEntity);
	}

	private ComicDto getComicDto() {
		ComicDto res = new ComicDto();
		res.setTitle("title");
		res.setDescription("description");
		res.setImage("img.jpg");
		res.setFollow(1l);
		res.setStatus((byte) 1);
		res.setView(1l);
		return res;
	}
}
