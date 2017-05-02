package com.library.spring.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.library.spring.model.Book;
import com.library.spring.model.BorrowedBooks;
import com.library.spring.model.Users;

@Repository
public class LibraryDAOImpl implements LibraryDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(LibraryDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void updateBook(Book p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Book updated successfully, Book Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks(Users user) {
		Session session = this.sessionFactory.getCurrentSession();
		//List<Book> booksList = session.createQuery("from Book").list();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BorrowedBooks> criteria = builder.createQuery(BorrowedBooks.class);//.add( Restrictions.like(type, "%"+key+"%"));
		Root<BorrowedBooks> root = criteria.from( BorrowedBooks.class );
		criteria.select( root );
		
		final Join join = root.join("user");
		
		Predicate predicate = builder.equal(join.get("userId"), user.getUserId());
		
		criteria.where( predicate );
		
		List<BorrowedBooks> booksList = session.createQuery(criteria).getResultList();
		List<Book> userBooks = new ArrayList<Book>(); 
		for(BorrowedBooks p : booksList){
			userBooks.add(this.getBookById(p.getBook().getBookId()));
		}
		for(Book p : userBooks){
			logger.info("Book List::"+p);
		}
		return userBooks;
	}

	@Override
	public Book getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Book p = (Book) session.load(Book.class, new Integer(id));
		logger.info("Book loaded successfully, Book details="+p);
		return p;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> search(String type, String key) {
		Session session = this.sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Book> criteria = builder.createQuery(Book.class);//.add( Restrictions.like(type, "%"+key+"%"));
		Root<Book> root = criteria.from( Book.class );
		criteria.select( root );
		criteria.where( builder.equal( root.get(type), key ) );
		List<Book> booksList = session.createQuery(criteria).getResultList();
		for(Book p : booksList){
			logger.info("Book List::"+p);
		}
		return booksList;
	}

	@Override
	public void borrowBook(Book b, Users user) {
		System.out.println("Borrowing Books");
		BorrowedBooks bb = new BorrowedBooks();
		
		System.out.println(user.getUserId());
		
		bb.setBook(b);
		bb.setUser(user);
		bb.setDueDate(bb.calculateDueDate());	
		
		System.out.println(bb.getUser().getUserId());
		
		Session session = this.sessionFactory.getCurrentSession();
        session.save(bb);
        logger.info("Book borrowed successfully, book Details="+b);
		
	}

	@Override
	public void extendBook(BorrowedBooks b) {
		b.setDueDate(b.calculateDueDate());
		Session session = this.sessionFactory.getCurrentSession();
        session.update(b);
        logger.info("Book extended successfully");
		
		
	}

	@Override
	public BorrowedBooks getBorrowedBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		//List<Book> booksList = session.createQuery("from Book").list();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<BorrowedBooks> criteria = builder.createQuery(BorrowedBooks.class);//.add( Restrictions.like(type, "%"+key+"%"));
		Root<BorrowedBooks> root = criteria.from( BorrowedBooks.class );
		criteria.select( root );
		
		final Join join = root.join("book");
		
		Predicate predicate = builder.equal(join.get("bookId"), id);
		
		criteria.where( predicate );
		
		List<BorrowedBooks> booksList = session.createQuery(criteria).getResultList();
		for(BorrowedBooks p : booksList){
			logger.info("Book List::"+p);
		}
		return booksList.get(0);
	}

	@Override
	public void returnBook(BorrowedBooks bb) {
		Session session = this.sessionFactory.getCurrentSession();
        BorrowedBooks b = (BorrowedBooks) session.load(BorrowedBooks.class, new Integer(bb.getBorrowId()));
        if(null != b){
            session.delete(b);
        }
		
	}

}
