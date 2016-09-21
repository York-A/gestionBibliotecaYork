package com.ipartek.formacion.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.mappers.BookMapper;

@Repository
public class BookDAOImp implements BookDAO  {

	@Autowired(required=true)
	private DataSource dataSource;
	//private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		//this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
	@Override
	public List<Book> getAll() {
		List <Book> books=null;
		
		
		
		return books;
	}

	@Override
	public void delete(int id) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("deleteBook");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codBook", id);	
		Map<String,Object> out=jdbcCall.execute(in);
		
	}

	@Override
	public Book getById(int id) {
		Book book=new Book();
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getBookById");
				//.returningResultSet("bookResult", new BookMapper());
		SqlParameterSource in=new MapSqlParameterSource().addValue("codBook", id);
		Map<String,Object>out=jdbcCall.execute(in);
		book.setIdBook(id);
		book.setTitle((String)out.get("title"));
		book.setAuthor((String)out.get("author"));
		book.setIsbn((String)out.get("isbn"));
		
		return book;
	}

	@Override
	public Book update(Book b) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("updateBook");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codBook", b.getTitle()).addValue("title", b.getTitle()).addValue("author", b.getAuthor()).addValue("isbn", b.getIsbn());	
		Map<String,Object> out=jdbcCall.execute(in);
		System.out.println((Integer)out.get("idBook"));
		b.setIdBook((Integer)out.get("idBook"));
		return b;
	}

	@Override
	public Book create(Book b) {
		
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("insertBook");
		SqlParameterSource in=new MapSqlParameterSource().addValue("title", b.getTitle()).addValue("author", b.getAuthor()).addValue("isbn", b.getIsbn());	
		Map<String,Object> out=jdbcCall.execute(in);
		System.out.println((Integer)out.get("codBook"));
		b.setIdBook((Integer)out.get("codBook"));
		return b;
		
	}

}
