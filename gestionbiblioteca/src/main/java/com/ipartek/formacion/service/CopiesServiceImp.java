package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.CopyDAOImp;
import com.ipartek.formacion.dao.persistence.Copy;
import com.ipartek.formacion.service.interfaces.CopyService;

public class CopiesServiceImp implements CopyService{

	@Autowired
	CopyDAOImp cDAO;
	
	
	
	public void setcDAO(CopyDAOImp cDAO) {
		this.cDAO = cDAO;
	}

	@Override
	public List<Copy> getAll() {
		List<Copy> copies=cDAO.getAll();
		return copies;
	}

	@Override
	public Copy getById(int id) {
		Copy c=cDAO.getById(id);
		return c;
	}

	@Override
	public Copy update(Copy c) {
		Copy cpy=cDAO.update(c);
		return cpy;
	}

	@Override
	public Copy create(Copy c) {
		Copy cpy=cDAO.create(c);
		return cpy;
	}

	@Override
	public void delete(int id) {
		cDAO.delete(id);
		
	}

}
