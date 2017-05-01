package com.library.spring.dao;

import java.util.List;

import com.library.spring.model.Book;



public interface BookDAO {
	
	public void addBook(Book b);
	public void removeBook(int id);
	public boolean checkBook(int id);
	public Book getBookById(int id);
}
