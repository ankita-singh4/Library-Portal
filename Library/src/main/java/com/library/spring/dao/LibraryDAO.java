package com.library.spring.dao;

import java.util.List;

import com.library.spring.model.Book;

public interface LibraryDAO {

	public void updateBook(Book b);
	public List<Book> listBooks();
	public Book getBookById(int id);
	public List<Book> search(String type, String key);
}
