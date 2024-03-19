package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.ComicDto;
import com.comic.serviceapi.entity.ComicEntity;
import com.comic.serviceapi.repository.ComicRepository;

@Service
public class ComicServiceImpl implements ComicService{

	@Autowired
	private ComicRepository comicRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void store(ComicDto comicDto) {
		ComicEntity comicEntity = toComicEntity(comicDto);
		comicRepo.save(comicEntity);
	}

	@Override
	public void delete(ComicDto comicDto) {
		ComicEntity comicEntity = toComicEntity(comicDto);
		comicRepo.delete(comicEntity);
	}

	@Override
	public void changeStatus(Integer id, Byte status) {
		comicRepo.changeStatus(id, status);
	}
	
	@Override
	public Optional<ComicDto> findById(Integer id) {
		return comicRepo.findById(id).map(e -> toComicDto(e));
	}

	@Override
	public List<ComicDto> findAll() {
		return comicRepo.findAll().stream().map(e -> toComicDto(e)).toList();
	}

	@Override
	public List<ComicDto> findByTitleContains(String title) {
		return comicRepo.findByTitleContains(title).stream().map(e -> toComicDto(e)).toList();
	}

	@Override
	public Optional<ComicDto> findByTitle(String title) {
		return comicRepo.findByTitle(title).map(e -> toComicDto(e));
	}

	private ComicEntity toComicEntity(ComicDto comicDto) {
		return modelMapper.map(comicDto, ComicEntity.class);
	}
	
	private ComicDto toComicDto(ComicEntity e) {
		return modelMapper.map(e, ComicDto.class);
	}

}
