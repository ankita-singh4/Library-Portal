package com.library.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.spring.dao.LibraryDAO;
import com.library.spring.model.Book;

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
	public List<Book> listBooks() {
		return this.libraryDAO.listBooks();
	}

	@Override
	@Transactional
	public Book getBookById(int id) {
		return this.libraryDAO.getBookById(id);
	}

}
