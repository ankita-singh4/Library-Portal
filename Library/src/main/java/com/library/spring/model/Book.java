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
	
	@Column(name="bookName")
	private String bookName;
	
	@Column(name="bookAuthor")
	private String bookAuthor;
	
	@Column(name="bookStatus")
	@Enumerated(EnumType.STRING)
	private Status bookStatus;
	
	@Column(name="bookGenre")
	private String bookGenre;
	
	@Column(name="bookISBN")
	private String bookISBN;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookTitle(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
	@Enumerated(EnumType.STRING)
    public Status getBookStatus() {
        return bookStatus;
    }
	
	@Enumerated(EnumType.STRING)
    public void setBookStatus(Status Status) {
        this.bookStatus = Status;
    }
	
	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	
	public String getBookISBN() {
		return bookISBN;
	}

	public void setBookISBN(String bookISBN) {
		this.bookISBN = bookISBN;
	}
	
	@Override
	public String toString(){
		return "id="+id+", title="+bookName+", author="+bookAuthor+", genre="+bookGenre+", status="+bookStatus+", ISBN="+bookISBN;
	}
}
