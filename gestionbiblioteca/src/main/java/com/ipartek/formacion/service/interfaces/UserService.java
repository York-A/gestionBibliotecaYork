package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.User;


public interface UserService {

	public List<User>getAll();
	public User getById(int id);
	public User update(User u);
	public User create(User u);
	public void delete(int id);
	
}
