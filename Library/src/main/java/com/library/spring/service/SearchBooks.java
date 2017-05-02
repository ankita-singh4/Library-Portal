package com.library.spring.service;

import java.util.List;

import com.library.spring.model.Book;

public interface SearchBooks {
	
	public List<Book> search(String status, String key);

}
