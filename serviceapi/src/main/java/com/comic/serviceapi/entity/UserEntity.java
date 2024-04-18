package com.comic.serviceapi.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

	@Id
	@Column(name = "username")
	private String userName;

	@Column
	private String fullName;

	@Column
	private String password;
	
	@Column
	private boolean enable;

	@Column
	private String role;
	
	@CreatedDate
	private LocalDate createdAt;
	
	@LastModifiedDate
	private LocalDate updatedAt;
	
	@OneToMany(mappedBy="user")
	private List<ComicCommentEntity> comicComments;
}
