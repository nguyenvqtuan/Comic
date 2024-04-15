package com.comic.serviceapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.ComicDto;
import com.comic.serviceapi.entity.ComicEntity;
import com.comic.serviceapi.repository.CategoryRepository;
import com.comic.serviceapi.repository.ComicRepository;

@Service
public class ComicServiceImpl implements ComicService{

	@Autowired
	private ComicRepository comicRepo;
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public void store(ComicDto comicDto) {
		ComicEntity comicEntity = toComicEntity(comicDto);
		comicEntity.setCategory(categoryRepo.findById(comicDto.getCategoryId()).get());
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
	
	@Override
	public List<ComicDto> searchRating(String type, String category, Integer size) {
		List<ComicDto> res = new ArrayList<>();
		switch(type) {
		case "popular":
			res = searchByPopular(category, size);
			break;
		case "view":
			res = searchByView(category, size);
			break;
		case "like":
			res = searchByLike(category, size);
			break;
		case "comment":
			res = searchByComment(category, size);
			break;
		default:
		}
		return res;
	}
	
	private List<ComicDto> searchByPopular(String category, Integer size) {
		List<ComicEntity> res = comicRepo.searchByPopular(category, size);
		return res.stream().map(e -> toComicDto(e)).toList();
	}
	
	private List<ComicDto> searchByView(String category, Integer size) {
		List<ComicEntity> res = comicRepo.searchByView(category, size);
		return res.stream().map(e -> toComicDto(e)).toList();
	}
	
	private List<ComicDto> searchByLike(String category, Integer size) {
		// TODO
		return new ArrayList<>();
	}
	private List<ComicDto> searchByComment(String category, Integer size) {
		// TODo
		return new ArrayList<>();
	}
	
	private ComicEntity toComicEntity(ComicDto comicDto) {
		return modelMapper.map(comicDto, ComicEntity.class);
	}
	
	private ComicDto toComicDto(ComicEntity e) {
		return modelMapper.map(e, ComicDto.class);
	}

}
