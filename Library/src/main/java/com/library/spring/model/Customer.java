package com.library.spring.model;

public class Customer extends Users {
	
	public Customer(Users u)
	{
		this.setUserId(u.getUserId());
		this.userName = u.getUserName();
		this.userPassword = u.getUserPassword();
		this.userType = "Customer";
		super.setProfile(u.getProfile());
	}
	
	public void setUserType(String userType)
	{
	
	}
	
	public String redirect()
	{
		return "redirect:/books";
	}

}
