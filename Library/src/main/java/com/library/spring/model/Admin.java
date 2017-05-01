package com.library.spring.model;

public class Admin extends Users {
	
	public Admin(Users u)
	{
		this.userName = u.getUserName();
		this.userPassword = u.getUserPassword();
		this.userType = "Admin";
		super.setProfile(u.getProfile());
	}
	
	public void setUserType(String userType)
	{
	
	}
	
	public String redirect()
	{
		return "redirect:/staffhome";
	}

}
