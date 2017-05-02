package com.library.spring.model;

import java.sql.Date;
import java.util.Calendar;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.library.spring.model.Users;
import com.library.spring.model.Book;

@Entity
@Table(name = "borrowedbooks")
public class BorrowedBooks {
	
	@Id
	@Column(name="borrowId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int borrowId;
	
	@ManyToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name = "userId")
    private Users user;

	@OneToOne//(cascade = {CascadeType.ALL})
    @JoinColumn(name = "bookId")
    private Book book;
	
	@Column(name="dueDate")
	private Date dueDate;
	

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public int getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(int borrowId) {
		this.borrowId = borrowId;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	
	public Date calculateDueDate()
	{
		Calendar c = Calendar.getInstance();
		Date today = new Date(c.getTimeInMillis());
		c.add(Calendar.DATE,21);
		Date due = new Date(c.getTimeInMillis());
		
		return due;
	}
}
