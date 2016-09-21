package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Copy;

public interface CopyService {

	public List<Copy> getAll();
	public Copy getById(int id);
	public Copy update(Copy c);
	public Copy create(Copy c);
	public void delete(int id);
	
	
}
