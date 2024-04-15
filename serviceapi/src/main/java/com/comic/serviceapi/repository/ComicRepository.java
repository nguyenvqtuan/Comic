package com.comic.serviceapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.comic.serviceapi.entity.ComicEntity;

@Repository
@Transactional
public interface ComicRepository extends JpaRepository<ComicEntity, Integer>{
	
	List<ComicEntity> findByTitleContains(String title);
	Optional<ComicEntity> findByTitle(String title);
	
	@Modifying
	@Query("UPDATE ComicEntity SET status = ?2 WHERE id = ?1")
	void changeStatus(Integer id, Byte status);
	
	@Query(value="SELECT c FROM ComicEntity c WHERE category.name LIKE %?1% ORDER BY view, follow DESC LIMIT ?2")
	List<ComicEntity> searchByPopular(String category, Integer size);
	
	@Query(nativeQuery=true, value="SELECT c.* FROM comics c WHERE c.category LIKE %?1% ORDER BY c.view DESC LIMIT ?2")
	List<ComicEntity> searchByView(String category, Integer size);
}
