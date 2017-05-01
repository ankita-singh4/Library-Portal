package com.library.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.library.spring.model.Book;
import com.library.spring.model.Status;

@Repository
public class BookDAOImpl implements BookDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addBook(Book p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Book saved successfully, Book Details="+p);
	}

	@Override
	public void updateBook(Book p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Book updated successfully, Book Details="+p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> listBooks() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> booksList = session.createQuery("from Book").list();
		for(Book p : booksList){
			logger.info("Book List::"+p);
		}
		return booksList;
	}

	@Override
	public Book getBookById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Book p = (Book) session.load(Book.class, new Integer(id));
		logger.info("Book loaded successfully, Book details="+p);
		return p;
	}

	@Override
	public void removeBook(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book p = (Book) session.load(Book.class, new Integer(id));
		if(null != p){
			session.delete(p);
		}
		logger.info("Book deleted successfully, book details="+p);
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

}
