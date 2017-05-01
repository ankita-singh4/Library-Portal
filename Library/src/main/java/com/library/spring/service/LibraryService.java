package com.library.spring.service;

import java.util.List;

import com.library.spring.model.Book;

public interface LibraryService {

	public void updateBook(Book p);
	public List<Book> listBooks();
	public Book getBookById(int id);
	
}
