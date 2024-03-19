package com.comic.serviceapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comic.serviceapi.entity.ComicChapterEntity;

@Repository
public interface ComicChapterRepository extends JpaRepository<ComicChapterEntity, Integer>{
	List<ComicChapterEntity> findByTitleContains(String title);
	Optional<ComicChapterEntity> findByTitle(String title);
}
