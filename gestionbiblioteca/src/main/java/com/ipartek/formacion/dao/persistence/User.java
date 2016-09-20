package com.ipartek.formacion.dao.persistence;

import java.util.Date;

public class User {

	private int idUser;
	private String userName;
	private String userSurname;
	private Date bDate;
	private String email;
	private String password;
	
	
	public User() {
		super();
		this.setIdUser(-1);
		this.setUserName("");
		this.setUserSurname("");
		this.setbDate(new Date());
		this.setEmail("");
		this.setPassword("");
	}


	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserSurname() {
		return userSurname;
	}


	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}


	public Date getbDate() {
		return bDate;
	}


	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
}
