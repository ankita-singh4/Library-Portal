package com.library.spring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.library.spring.model.Users;

import com.library.spring.service.SignupService;


@Controller
public class SignupController {
	
private SignupService signupService;
private Users user;
	
	@Autowired(required=true)
	@Qualifier(value="signupService")
	public void setSignupService(SignupService ss){
		this.signupService = ss;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String showSignup(@ModelAttribute("user") Users user, Model model) {
		System.out.println(user.getUserType());
		UserFactory uf = new UserFactory();
		this.user = uf.createUser(user);
		model.addAttribute("user", user);		
		return "signup";
	}
	
	
	//For adding  a person
	@RequestMapping(value= "/signup/add", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") Users u){
		
		System.out.println("Inside Add User");
		
			u.setUserType(user.getUserType());
		
			//System.out.println("before addUser");
			//new person, add it
			this.signupService.addUser(u);
			//System.out.println("after addUser");
			
		return "redirect:/login";
		
	}
}	
