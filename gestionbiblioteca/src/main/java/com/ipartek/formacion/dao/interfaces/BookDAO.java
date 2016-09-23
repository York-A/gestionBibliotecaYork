package com.ipartek.formacion.dao.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.persistence.Copy;

public interface BookDAO {

	public List<Book>getAll();
	public void delete(int id);
	public Book getById(int id);
	public Book update(Book b);
	public Book create(Book b);
//	public List<Copy>getCopiesOf(int id);
}
