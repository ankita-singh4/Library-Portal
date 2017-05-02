package com.library.spring.dao;

public interface QuestionDAO {
	public void addQuestion(Question q);
	public void editQuestion(Question q );
	public List<Question> listQuestions();
	public Question getQuestionById(int id);
	public void Delete(int id);

}
