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

import com.comic.serviceapi.dto.ComicChapterDto;
import com.comic.serviceapi.dto.ComicDto;
import com.comic.serviceapi.entity.ComicChapterEntity;
import com.comic.serviceapi.entity.ComicEntity;
import com.comic.serviceapi.repository.ComicChapterRepository;
import com.comic.serviceapi.repository.ComicRepository;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class ComicChapterServiceTest {

	@Mock
	ComicChapterRepository repository;
	
	@Mock
	ComicRepository comicRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	ComicChapterServiceImpl service;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void whenFindAll_shouldReturnList() {
		// 1. create mock data
		List<ComicChapterEntity> comicChapterChapters = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			comicChapterChapters.add(new ComicChapterEntity());
		}

		when(repository.findAll()).thenReturn(comicChapterChapters);
		List<ComicChapterDto> comicChapterDtos = service.findAll();
		assertThat(comicChapterDtos.size()).isEqualTo(comicChapterChapters.size());
		verify(repository).findAll();
	}
	
//	@Test
//	void whenFindByIdComic_shouldReturnList() {
//		// 1. create mock data
//		List<ComicChapterEntity> comicChapterChapters = new ArrayList<>();
//		for (int i = 0; i < 5; i++) {
//			comicChapterChapters.add(new ComicChapterEntity());
//		}
//		int comicId = 1;
//		when(repository.findByComicId(comicId)).thenReturn(comicChapterChapters);
//		List<ComicChapterDto> comicChapterDtos = service.findByComicId(comicId);
//		assertThat(comicChapterDtos.size()).isEqualTo(comicChapterChapters.size());
//		verify(repository).findByComicId(comicId);
//	}

	@Test
	void whenFindById_ShouldReturnEmpty() {
		Optional<ComicChapterEntity> comicChapter = Optional.empty();
		int id = 1;
		when(repository.findById(id)).thenReturn(comicChapter);
		service.findById(id);
		assertTrue(comicChapter.isEmpty());
		verify(repository).findById(id);
	}

//	@Test
//	void whenAdd_ShouldSuccess() {
//		ComicDto comicDto = getComicDto();
//		ComicEntity comicEntity = modelMapper.map(comicDto, ComicEntity.class);
//		comicRepository.save(comicEntity);
//		
//		ComicChapterDto comicChapterDto = getComicChapterDto();
//		ComicChapterEntity comicChapterEntity = modelMapper.map(comicChapterDto, ComicChapterEntity.class);
//		service.store(comicChapterDto);
//		verify(repository, times(1)).save(comicChapterEntity);
//	}
	
	@Test
	void whenDelete_ShouldSuccess() {
		ComicChapterDto comicChapterDto = getComicChapterDto();
		ComicChapterEntity comicChapterEntity = modelMapper.map(comicChapterDto, ComicChapterEntity.class);
		service.delete(comicChapterDto);
		verify(repository, times(1)).delete(comicChapterEntity);
	}

	private ComicChapterDto getComicChapterDto() {
		ComicChapterDto res = new ComicChapterDto();
		res.setTitle("title");
		res.setContent("content");
		res.setNumOrder(1);
		res.setComicId(1);
		return res;
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
