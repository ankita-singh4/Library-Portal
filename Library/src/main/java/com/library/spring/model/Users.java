package com.library.spring.model;

import java.util.List;
import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Entity
@Table(name = "users")
@SuppressWarnings("serial")
public class Users{
	
	@Id
	@Column(name="userId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userId;
	
	
	@Column(name = "user_name")
	String userName;

	@Column(name = "user_password")
	String userPassword;
	
	@Column(name = "user_type")
	String userType;

	private Profile profile;
	
	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	} 

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	
	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}
	

	@Embedded
	public Profile getProfile() {
		return profile;
	}


	public void setProfile(Profile profile) {
		this.profile = profile;
	}


	public String redirect()
	{
		return "redirect:/books";
	}
	

	
	
}