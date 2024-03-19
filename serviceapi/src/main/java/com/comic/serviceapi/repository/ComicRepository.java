package com.comic.serviceapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comic.serviceapi.entity.ComicEntity;

@Repository
public interface ComicRepository extends JpaRepository<ComicEntity, Integer>{
	List<ComicEntity> findByTitleContains(String title);
	Optional<ComicEntity> findByTitle(String title);
}
