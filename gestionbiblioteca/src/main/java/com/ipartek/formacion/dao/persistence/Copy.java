package com.ipartek.formacion.dao.persistence;

public class Copy {

	private int idCopy;
	private int book;
	private String publisher;
	private int nPages;
	
	
	public Copy() {
		super();
		this.setIdCopy(-1);
		this.setBook(-1);
		this.setPublisher("");
		this.setnPages(-1);
	}


	public int getIdCopy() {
		return idCopy;
	}


	public void setIdCopy(int idCopy) {
		this.idCopy = idCopy;
	}


	public int getBook() {
		return book;
	}


	public void setBook(int book) {
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
	
	
	
	
}
