package com.library.spring.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.library.spring.model.Question;



@Repository
public class QuestionDAOImpl implements QuestionDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(QuestionDAOImpl.class);

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@Override
	public void addQuestion(Question q) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(q);
		logger.info("Question successfully added"+q);
	}

	@Override
	public void editQuestion(Question q) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(q);
		logger.info("question updated successfully"+q);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> listQuestions() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Question> QuestionList = session.createQuery("from Question").list();
		for(Question q : QuestionList){
			logger.info("Question List::"+q);
		}
		return QuestionList;
	}

	@Override
	public Question getQuestionById(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Question q = (Question) session.load(Question.class, new Integer(id));
		logger.info("Question loaded successfully="+q);
		return q;
	}

	@Override
	public void removeQuestion(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Question q = (Question) session.load(Question.class, new Integer(id));
		if(null != q){
			session.delete(q);
		}
		logger.info("Question deleted successfully="+q);
	}

}