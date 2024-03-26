package com.comic.serviceapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comic.serviceapi.entity.ComicChapterEntity;

@Repository
@Transactional
public interface ComicChapterRepository extends JpaRepository<ComicChapterEntity, Integer>{
	List<ComicChapterEntity> findByTitleContains(String title);
	Optional<ComicChapterEntity> findByTitle(String title);
	
	@Modifying
	@Query("UPDATE ComicChapterEntity SET content = ?2 WHERE id = ?1")
	void upload(Integer id, String content);
}
