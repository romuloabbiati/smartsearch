package com.smartgroup.smartsearch.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.smartgroup.smartsearch.entities.enums.Platform;

public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private Platform platform;
	
	private Genre genre;
	
	private List<Record> records = new ArrayList<>();
	
	public Game() {}
	
	public Game(Long id, String title, Platform platform) {
		this.id = id;
		this.title = title;
		this.platform = platform;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Platform getPlatform() {
		return platform;
	}
	
	public void setPlatform(Platform platform) {
		this.platform = platform;
	}
	
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	public List<Record> getRecords() {
		return records;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}

}
