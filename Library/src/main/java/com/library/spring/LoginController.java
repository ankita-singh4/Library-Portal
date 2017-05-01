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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Map;


import com.library.spring.model.*;
import com.library.spring.service.*;
//import com.library.spring.UserFactory;

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
	public String processForm(@ModelAttribute("loginForm") Users loginForm, BindingResult result,
			Map model, RedirectAttributes redirectAttributes) {

		
		if (result.hasErrors()) {
			return "login";
		}
		
		//System.out.println(loginForm.getUserName());
		//System.out.println(loginForm.getUserPassword());
		Users u = loginService.checkLogin(loginForm.getUserName(),
                loginForm.getUserPassword());
		if(u == null){
			//result.rejectValue("userName","invaliduser");
			model.put("loginForm", loginForm);
			return "login";
		}
		
		else{
			UserFactory uf = new UserFactory();
			Users user = uf.createUser(u);
			//System.out.println(loginForm.getUserName());
			redirectAttributes.addFlashAttribute("user", user);
			model.put("loginForm", loginForm);
			//System.out.println("loginSuccess");
			//System.out.println(loginForm.redirect());
			return loginForm.redirect();
		}

	}

}



