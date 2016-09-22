package com.ipartek.formacion.dao.persistence;

public class Copy {

	private int idCopy;
	private Book book;
	private String publisher;
	private int nPages;
	private int rent;
	
	public Copy() {
		super();
		this.setIdCopy(-1);
		this.setBook(new Book());
		this.setPublisher("");
		this.setnPages(-1);
		this.setRent(-1);
	}


	public int getIdCopy() {
		return idCopy;
	}


	public void setIdCopy(int idCopy) {
		this.idCopy = idCopy;
	}


	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public int getnPages() {
		return nPages;
	}


	public void setnPages(int nPages) {
		this.nPages = nPages;
	}


	public int getRent() {
		return rent;
	}


	public void setRent(int rent) {
		this.rent = rent;
	}
	
	
	
	
}
