package com.library.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.spring.dao.BookDAO;
import com.library.spring.model.Book;


	@Service
	public class BookServiceImpl implements BookService {
		
		private BookDAO bookDAO;

		public void setBookDAO(BookDAO bookDAO) {
			this.bookDAO = bookDAO;
		}

		@Override
		@Transactional
		public void addBook(Book b) {
			this.bookDAO.addBook(b);
		}

		@Override
		@Transactional
		public void removeBook(int id) {
			this.bookDAO.removeBook(id);
		}
		
		 @Override
		 @Transactional
	     public boolean checkBook(int id){
	              System.out.println("In Service class...Checking Book");
	              return this.bookDAO.checkBook(id);
	       }
		 
		 @Override
		 @Transactional
			public Book getBookById(int id) {
				return this.bookDAO.getBookById(id);
			}

	}
	