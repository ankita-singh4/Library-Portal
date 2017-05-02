package com.library.spring.service;

import java.util.List;

import com.library.spring.model.Question;

public interface QuestionService {

		
	public void addQuestion(Question q);
	public void updateQuestion(Question q);
	public List<Question> listQuestions();
	public Question getQuestionById(int id);
	public void removeQuestion(int id);
		
	
}