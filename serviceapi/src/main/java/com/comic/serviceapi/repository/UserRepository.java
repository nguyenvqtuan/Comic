package com.comic.serviceapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comic.serviceapi.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String>{

	Optional<UserEntity> findByUserName(String userName);
}
