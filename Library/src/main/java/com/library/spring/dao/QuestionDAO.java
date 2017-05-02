package com.library.spring.dao;

import java.util.List;

import com.library.spring.model.Question;

public interface QuestionDAO {
	public void addQuestion(Question q);
	public void editQuestion(Question q );
	public List<Question> listQuestions();
	public Question getQuestionById(int id);
	public void removeQuestion(int id);

}