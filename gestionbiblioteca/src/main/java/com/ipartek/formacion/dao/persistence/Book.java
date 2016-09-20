package com.ipartek.formacion.dao.persistence;

public class Book {

	private int idBook;
	private String title;
	private String author;
	private String isbn;
	
	public Book() {
		super();
		this.setIdBook(-1);
		this.setTitle("");
		this.setAuthor("");
		this.setIsbn("");
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
	
	
	
	
	
}
