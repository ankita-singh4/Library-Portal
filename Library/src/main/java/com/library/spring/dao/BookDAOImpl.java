package com.library.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.library.spring.model.Book;


@Repository
public class BookDAOImpl implements BookDAO {
    
    private static final Logger logger = LoggerFactory.getLogger(BookDAOImpl.class);

    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addBook(Book b) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(b);
        logger.info("Book saved successfully, book Details="+b);
    }

    
    @Override
    public void removeBook(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Book b = (Book) session.load(Book.class, new Integer(id));
        if(null != b){
            session.delete(b);
        }
        logger.info("Book deleted successfully, book details="+b);
    }
    
    public boolean checkBook(int id){
		System.out.println("In Check Book at DAO");
		Session session = sessionFactory.openSession();
		boolean bookFound = false;
		//Query using Hibernate Query Language
		//String SQL_QUERY =" from Users as o where o.userName=? and o.userPassword=?";
		String SQL_QUERY =" from Book as o where o.id=?";
		Query query = session.createQuery(SQL_QUERY);
		query.setParameter(0,id);
		//query.setParameter(1,userPassword);
		List list = query.list();

		if ((list != null) && (list.size() > 0)) {
			bookFound= true;
		}
		
		if (bookFound == false)
		{
			System.out.println("Book is not available");
		}
		session.close();
		return bookFound;              
   }
    
    
    @Override
    public Book getBookById(int id) {
        Session session = this.sessionFactory.getCurrentSession();        
        Book b = (Book) session.load(Book.class, new Integer(id));
        logger.info("Book loaded successfully, Book details="+b);
        return b;
    }

}