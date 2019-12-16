package com.accenture.lkm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logindetail")
public class LoginEntity {

	@Id
	private String username;
	private String password;
	
	public LoginEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginEntity(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginEntity [username=" + username + ", password=" + password + "]";
	}
	
}
