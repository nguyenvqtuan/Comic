package com.comic.serviceapi.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "comics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ComicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String title;
	
	@Column
	private String image;
	
	@Column
	private long view;

	@Column
	private String description;
	
	@Column(columnDefinition=" INT(11) NOT NULL COMMENT '0 for no action, 1 for in-progress, 2 for pending, 3 for done'")
	private byte status;
	
	@Column
	private long follow;
	
	@ManyToOne
	@JoinColumn(name="id_category")
	private CategoryEntity category;
	
	@OneToMany(mappedBy="comic")
	private List<ComicChapterEntity> comicChapters;
	
	@OneToMany(mappedBy="comic")
	private List<ComicCommentEntity> comicComments;
}
