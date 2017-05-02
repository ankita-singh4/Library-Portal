package com.library.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.spring.dao.LibraryDAO;
import com.library.spring.model.Book;
import com.library.spring.model.BorrowedBooks;
import com.library.spring.model.Users;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	private LibraryDAO libraryDAO;

	public void setLibraryDAO(LibraryDAO libraryDAO) {
		this.libraryDAO = libraryDAO;
	}

	@Override
	@Transactional
	public void updateBook(Book p) {
		this.libraryDAO.updateBook(p);
	}

	@Override
	@Transactional
	public List<Book> listBooks(Users user) {
		return this.libraryDAO.listBooks(user);
	}

	@Override
	@Transactional
	public Book getBookById(int id) {
		return this.libraryDAO.getBookById(id);
	}

	@Override
	@Transactional
	public void borrowBook(Book b, Users user) {
		this.libraryDAO.borrowBook(b, user);
		
	}

	@Override
	@Transactional
	public void extendBook(BorrowedBooks b) {
		this.libraryDAO.extendBook(b);
		
	}

	@Override
	@Transactional
	public BorrowedBooks getBorrowedBookById(int id) {
		return this.libraryDAO.getBorrowedBookById(id);
	}

	@Override
	@Transactional
	public void returnBook(BorrowedBooks bb) {
		this.libraryDAO.returnBook(bb);
		
	}

}
