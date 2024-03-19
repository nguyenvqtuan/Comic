package com.comic.serviceapi.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class ComicEmbededId implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column
	private int id;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="id_comic")
	private int idComic;
}
