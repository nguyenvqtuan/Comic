package com.comic.serviceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comic_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComicCommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name="username")
	@MapsId("userName")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name="id_comic")
	@MapsId("idComic")
	private ComicEntity comic;
	
	@Column
	private String content;

	@Column(columnDefinition = " INT(11) NOT NULL COMMENT '0 for no reply, other for reply specific'")
	private int reply;
}
