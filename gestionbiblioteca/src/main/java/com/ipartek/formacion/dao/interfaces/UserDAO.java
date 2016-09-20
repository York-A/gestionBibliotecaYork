package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.User;

public interface UserDAO {

	public List<User>getAll();
	public void delete(int id);
	public User getById(int id);
	public User update(User u);
	public User create(User u);
}
