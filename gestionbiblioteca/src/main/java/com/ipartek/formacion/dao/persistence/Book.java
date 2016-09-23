package com.ipartek.formacion.dao.persistence;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private int idBook;
	private String title;
	private String author;
	private String isbn;
	private List<Copy>copies;
	
	public Book() {
		super();
		this.setIdBook(-1);
		this.setTitle("");
		this.setAuthor("");
		this.setIsbn("");
//		this.setCopies(new ArrayList<Copy>());
	}

	public int getIdBook() {
		return idBook;
	}

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

//	public List<Copy> getCopies() {
//		return copies;
//	}
//
//	public void setCopies(List<Copy> copies) {
//		this.copies = copies;
//	}
//	
	
	
	
	
}
