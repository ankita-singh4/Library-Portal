package com.library.spring.service;

import java.util.List;

import com.library.spring.model.Book;

public interface BookService {

	public void addBook(Book p);
	public void updateBook(Book p);
	public List<Book> listBooks();
	public Book getBookById(int id);
	public void removeBook(int id);
	
}
