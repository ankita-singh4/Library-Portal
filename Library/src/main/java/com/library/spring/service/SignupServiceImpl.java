package com.library.spring.service;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.spring.dao.SignupDAO;
import com.library.spring.model.Users;


@Service
public class SignupServiceImpl implements SignupService {
	
	private SignupDAO signupDAO;

	public void setSignupDAO(SignupDAO signupDAO) {
		this.signupDAO = signupDAO;
	}

	@Override
	@Transactional
	public void addUser(Users u) {
		this.signupDAO.addUser(u);
	}
}
