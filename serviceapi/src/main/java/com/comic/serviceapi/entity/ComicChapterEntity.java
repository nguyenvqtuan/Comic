package com.comic.serviceapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comic_chapters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComicChapterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private int numOrder;

	@Column
	private String title;

	// Save link image
	@Column
	private String content;

	@ManyToOne
	@JoinColumn(name = "id_comic")
	private ComicEntity comic;
}
