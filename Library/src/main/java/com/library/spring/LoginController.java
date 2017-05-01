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


import com.library.spring.model.Users;
import com.library.spring.service.*;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

	
	@Autowired
	public LoginService loginService;
	
	/*
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService ls){
		this.loginService = ls;
	}
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		Users loginForm = new Users();
		model.put("loginForm", loginForm);
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(Users loginForm, BindingResult result,
			Map model) {

		
		if (result.hasErrors()) {
			return "login";
		}
		
		//System.out.println(loginForm.getUserName());
		//System.out.println(loginForm.getUserPassword());
		boolean userExists = loginService.checkLogin(loginForm.getUserName(),
                loginForm.getUserPassword());
		if(userExists){
			model.put("loginForm", loginForm);
			//return "loginSuccess";
			return "staffpage";
		}
		
		else{
			//result.rejectValue("userName","invaliduser");
			model.put("loginForm", loginForm);
			return "login";
		}

	}

}



