package com.library.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Author")
	private String author;
	
	@Column(name="Status")
	@Enumerated(EnumType.STRING)
	private Status status;
	
	@Column(name="genre")
	private String genre;
	
	@Column(name="ISBN")
	private String ISBN;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Enumerated(EnumType.STRING)
    public Status getStatus() {
        return status;
    }
	
	@Enumerated(EnumType.STRING)
    public void setStatus(Status status) {
        this.status = status;
    }
	
	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	@Override
	public String toString(){
		return "id="+id+", title="+title+", author="+author+", genre="+genre+", status="+status+", ISBN="+ISBN;
	}
}
