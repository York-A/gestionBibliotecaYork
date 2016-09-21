package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rS, int arg1) throws SQLException {
		Book b=new Book();
		b.setIdBook(rS.getInt("idBook"));
		b.setTitle(rS.getString("title"));
		b.setAuthor(rS.getString("author"));
		b.setIsbn(rS.getString("isbn"));
		
		return b;
	}

}
