package com.ipartek.formacion.service.interfaces;

import java.util.List;

import com.ipartek.formacion.dao.persistence.Book;

public interface BookService {

	public List<Book> getAll();
	public Book getById(int id);
	public void delete(int id);
	public Book update(Book b);
	public Book create(Book b);
}
