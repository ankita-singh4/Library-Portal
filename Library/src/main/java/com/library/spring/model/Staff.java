package com.library.spring.model;

public class Staff extends Users {
	
	public Staff(Users u)
	{
		this.userName = u.getUserName();
		this.userPassword = u.getUserPassword();
		this.userType = "Staff";
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
