package com.library.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.spring.dao.BookDAO;
import com.library.spring.model.Book;

@Service
public class SearchByTitle implements SearchBooks {

	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	@Transactional
	public List<Book> search(String key) {
		return this.bookDAO.search("title",key);
	}

}
