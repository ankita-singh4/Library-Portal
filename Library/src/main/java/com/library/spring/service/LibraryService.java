package com.library.spring.service;

import java.util.List;

import com.library.spring.model.Book;
import com.library.spring.model.BorrowedBooks;
import com.library.spring.model.Users;

public interface LibraryService {

	public void updateBook(Book p);
	public List<Book> listBooks(Users user);
	public Book getBookById(int id);
	public void borrowBook(Book b, Users user);
	public void extendBook(BorrowedBooks b);
	public BorrowedBooks getBorrowedBookById(int id);
	public void returnBook(BorrowedBooks bb);
	
}
