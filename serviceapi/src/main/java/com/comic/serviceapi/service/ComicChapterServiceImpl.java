package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.ComicChapterDto;
import com.comic.serviceapi.entity.ComicChapterEntity;
import com.comic.serviceapi.repository.ComicChapterRepository;

@Service
public class ComicChapterServiceImpl implements ComicChapterService{

	@Autowired
	private ComicChapterRepository comicRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void store(ComicChapterDto comicChapterDto) {
		ComicChapterEntity comicEntity = toComicChapterEntity(comicChapterDto);
		comicRepo.save(comicEntity);
	}

	@Override
	public void delete(ComicChapterDto comicChapterDto) {
		ComicChapterEntity comicEntity = toComicChapterEntity(comicChapterDto);
		comicRepo.delete(comicEntity);
	}

	@Override
	public Optional<ComicChapterDto> findById(Integer id) {
		return comicRepo.findById(id).map(e -> toComicChapterDto(e));
	}

	@Override
	public List<ComicChapterDto> findAll() {
		return comicRepo.findAll().stream().map(e -> toComicChapterDto(e)).toList();
	}

	@Override
	public List<ComicChapterDto> findByTitleContains(String title) {
		return comicRepo.findByTitleContains(title).stream().map(e -> toComicChapterDto(e)).toList();
	}
	
	@Override
	public Optional<ComicChapterDto> findByTitle(String title) {
		return comicRepo.findByTitle(title).map(e -> toComicChapterDto(e));
	}

	private ComicChapterEntity toComicChapterEntity(ComicChapterDto comicChapterDto) {
		return modelMapper.map(comicChapterDto, ComicChapterEntity.class);
	}
	
	private ComicChapterDto toComicChapterDto(ComicChapterEntity comicEntity) {
		return modelMapper.map(comicEntity, ComicChapterDto.class);
	}
}
