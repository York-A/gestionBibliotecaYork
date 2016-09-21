package com.ipartek.formacion.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.service.interfaces.BookService;

public class BooksServiceImp implements BookService{

	@Autowired
	BookDAO bDAO;

	public void setbDAO(BookDAO bDAO) {
		this.bDAO = bDAO;
	}

	@Override
	public List<Book> getAll() {
		List<Book> books=bDAO.getAll();
		return books;
	}

	@Override
	public Book getById(int id) {
		Book b=bDAO.getById(id);
		return b;
	}

	@Override
	public void delete(int id) {
		bDAO.delete(id);
		
	}

	@Override
	public Book update(Book b) {
		Book book=bDAO.update(b);
		return book;
	}

	@Override
	public Book create(Book b) {
		Book book=bDAO.create(b);
		return book;
	}

}
