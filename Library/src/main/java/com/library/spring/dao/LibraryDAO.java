package com.library.spring.dao;

import java.util.List;

import com.library.spring.model.Book;
import com.library.spring.model.BorrowedBooks;
import com.library.spring.model.Users;

public interface LibraryDAO {

	public void updateBook(Book b);
	public List<Book> listBooks(Users user);
	public Book getBookById(int id);
	public List<Book> search(String type, String key);
	public void borrowBook(Book b, Users user);
	public void extendBook(BorrowedBooks b);
	public BorrowedBooks getBorrowedBookById(int id);
	public void returnBook(BorrowedBooks bb);
}
