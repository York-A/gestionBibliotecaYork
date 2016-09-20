package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Copy;

public interface CopyDAO {

	public List<Copy>getAll();
	public void delete(int id);
	public Copy getById(int id);
	public Copy update(Copy c);
	public Copy create(Copy c);
}
