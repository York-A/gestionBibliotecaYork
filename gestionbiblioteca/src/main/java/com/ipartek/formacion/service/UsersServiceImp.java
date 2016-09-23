package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.dao.UserDAOImp;
import com.ipartek.formacion.dao.persistence.User;
import com.ipartek.formacion.service.interfaces.UserService;

@Service
public class UsersServiceImp implements UserService{

	@Autowired
	UserDAOImp uDAO;
	
	
	public void setuDAO(UserDAOImp uDAO) {
		this.uDAO = uDAO;
	}

	@Override
	public List<User> getAll() {
		List<User>users=uDAO.getAll();
		return users;
	}

	@Override
	public User getById(int id) {
		User u=uDAO.getById(id);
		return u;
	}

	@Override
	public User update(User u) {
		User usr=uDAO.update(u);
		return usr;
	}

	@Override
	public User create(User u) {
		User usr=uDAO.create(u);
		return usr;
	}

	@Override
	public void delete(int id) {
		uDAO.delete(id);
	}

}
