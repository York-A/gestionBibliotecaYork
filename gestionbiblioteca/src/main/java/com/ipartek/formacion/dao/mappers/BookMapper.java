package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.BookDAOImp;
import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.persistence.Book;

public class BookMapper implements RowMapper<Book> {

	@Override
	public Book mapRow(ResultSet rS, int arg1) throws SQLException {
		Book b=new Book();
		BookDAO bDAO=new BookDAOImp();
		b.setIdBook(rS.getInt("idBook"));
		b.setTitle(rS.getString("title"));
		b.setAuthor(rS.getString("author"));
		b.setIsbn(rS.getString("isbn"));
//		b.setCopies(bDAO.getCopiesOf(b.getIdBook()));
		
		return b;
	}

}
