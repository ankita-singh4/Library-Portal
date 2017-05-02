package com.library.spring.service;

import java.util.List;

import com.library.spring.dao.Question;

public interface QuestionService {

		
	public void addQuestion(Question q);
	public void editQuestion(Question q );
	public List<Question> listQuestions();
	public Question getQuestionById(int id);
	public void Delete(int id);
		
	
}
