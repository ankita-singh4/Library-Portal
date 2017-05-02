package com.library.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.spring.dao.LibraryDAO;
import com.library.spring.model.Book;

@Service
public class SearchBooksImpl implements SearchBooks {

	private LibraryDAO libraryDAO;
	
	public void setLibraryDAO(LibraryDAO libraryDAO) {
		this.libraryDAO = libraryDAO;
	}

	@Override
	@Transactional
	public List<Book> search(String type, String key) {
		return this.libraryDAO.search(type,key);
	}

}
