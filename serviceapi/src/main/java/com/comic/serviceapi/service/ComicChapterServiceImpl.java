package com.comic.serviceapi.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.comic.serviceapi.dto.ComicChapterDto;
import com.comic.serviceapi.entity.ComicChapterEntity;
import com.comic.serviceapi.repository.ComicChapterRepository;
import com.comic.serviceapi.repository.ComicRepository;

@Service
public class ComicChapterServiceImpl implements ComicChapterService{

	@Autowired
	private ComicChapterRepository comicChapterRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ComicRepository comicRepo;
	
	@Override
	public void store(ComicChapterDto comicChapterDto) {
		comicChapterDto.setNumOrder((int) comicChapterRepo.count() + 1);
		ComicChapterEntity comicChapterEntity = toComicChapterEntity(comicChapterDto);
		comicChapterEntity.setComic(comicRepo.findById(comicChapterDto.getComicId()).get());;
		comicChapterRepo.save(comicChapterEntity);
	}

	@Override
	public void delete(ComicChapterDto comicChapterDto) {
		ComicChapterEntity comicChapterEntity = toComicChapterEntity(comicChapterDto);
		comicChapterRepo.delete(comicChapterEntity);
	}

	@Override
	public void upload(Integer id, String content) {
		comicChapterRepo.upload(id, content);
	}
	
	@Override
	public Optional<ComicChapterDto> findById(Integer id) {
		return comicChapterRepo.findById(id).map(e -> toComicChapterDto(e));
	}

	@Override
	public List<ComicChapterDto> findAll() {
		return comicChapterRepo.findAll().stream().map(e -> toComicChapterDto(e)).toList();
	}
	
	@Override
	public List<ComicChapterDto> findByComicId(Integer comicId) {
		return comicChapterRepo.findByComicId(comicId).stream().map(e -> toComicChapterDto(e)).toList();
	}
	
	@Override
	public Optional<ComicChapterDto> findByTitle(String title) {
		return comicChapterRepo.findByTitle(title).map(e -> toComicChapterDto(e));
	}

	private ComicChapterEntity toComicChapterEntity(ComicChapterDto comicChapterDto) {
		return modelMapper.map(comicChapterDto, ComicChapterEntity.class);
	}
	
	private ComicChapterDto toComicChapterDto(ComicChapterEntity comicChapterEntity) {
		return modelMapper.map(comicChapterEntity, ComicChapterDto.class);
	}

}
