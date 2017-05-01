package com.library.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.validator.constraints.NotEmpty;
import com.library.spring.model.Status;

@DynamicInsert
@Entity
@Table(name="BOOK")
public class Book {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	@Column(name="bookName")
	private String bookName;
	
	@NotEmpty
	@Column(name="bookAuthor")
	private String bookAuthor;
	
	@Column(name="bookStatus", nullable = false, columnDefinition = "enum('Available','Borrowed') default 'Available'")
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

	public void setBookName(String bookName) {
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
    public void setBookStatus(Status status) {
        this.bookStatus = status;
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
