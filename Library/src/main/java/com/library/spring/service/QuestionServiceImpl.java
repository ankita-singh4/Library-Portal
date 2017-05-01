package com.library.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class QuestionServiceImpl implements QuestionService {
	
	
		
		private QuestionDAO QuestionDAO;

		public void (QuestionDAO questionDAO) {
			this.questionDAO = questionDAO;
		}

		@Override
		@Transactional
		public void addQuestion(Question q) {
			this.questionDAO.addQuestion(q);
		}

		@Override
		@Transactional
		public void updateQuestion(Question q) {
			this.questionDAO.updateQuestion(q);
		}

		@Override
		@Transactional
		public List<Question> listQuestions() {
			return this.questionDAO.listQuestions();
		}

		@Override
		@Transactional
		public Question getQuestionById(int id) {
			return this.questionDAO.getQuestionById(id);
		}

		@Override
		@Transactional
		public void removeQuestion(int id) {
			this.questionDAO.removeQuestion(id);
		}

}

