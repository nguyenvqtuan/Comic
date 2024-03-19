package com.comic.serviceapi.entity;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
public class UserEntity {

	@Id
	@Column(name = "username")
	private String userName;

	@Column
	private String fullName;

	@Column
	private String password;
	
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	@Column
	private boolean enable;

	@Column
	private String role;
	
	@OneToMany(mappedBy="user")
	private List<ComicCommentEntity> comicComments;
}
