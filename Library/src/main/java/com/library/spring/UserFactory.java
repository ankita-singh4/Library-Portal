package com.library.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;


import com.library.spring.model.*;
import com.library.spring.service.*;

@Controller
//@RequestMapping(value = "/login")
public class UserFactory {

	
	//@Autowired
	//public LoginService loginService;
	
	/*
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService ls){
		this.loginService = ls;
	}
	 */

	public Users createUser(Users u)
	{
		Users user;
		
		if(u.getUserType().equals("Customer"))
			user = new Customer(u);
		else if(u.getUserType().equals("Staff"))
			user = new Staff(u);
		else
			user = new Admin(u);
		
		return user;
			
	}

}