package com.ipartek.formacion.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.persistence.Copy;
import com.ipartek.formacion.dao.mappers.BookMapper;
import com.ipartek.formacion.dao.mappers.CopyMapper;

@Repository
public class BookDAOImp implements BookDAO  {

	@Autowired(required=true)
	private DataSource dataSource;
	
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
	@Override
	public List<Book> getAll() {
		List <Book> books=null;
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getAllBook").returningResultSet("books", new BookMapper());
		SqlParameterSource in=new MapSqlParameterSource();	
		Map<String,Object> out=jdbcCall.execute(in);
		books=(List)out.get("books");
//		for (Book book : books) {
//			System.out.println(book.getTitle());
//		}
		
		
		
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
		book.setIdBook(id);		
		SqlParameterSource in=new MapSqlParameterSource().addValue("codBook", book.getIdBook());
		Map<String,Object>out=jdbcCall.execute(in);
		System.out.println((Integer)out.get("out_id"));
		System.out.println((String)out.get("out_author"));
		book.setTitle((String)out.get("out_title"));
		book.setAuthor((String)out.get("out_author"));
		book.setIsbn((String)out.get("out_isbn"));
//		book.setCopies(this.getCopiesOf(id));
		return book;
	}

	@Override
	public Book update(Book b) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("updateBook");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codBook", b.getIdBook()).addValue("title", b.getTitle()).addValue("author", b.getAuthor()).addValue("isbn", b.getIsbn());	
		Map<String,Object> out=jdbcCall.execute(in);
		return b;
	}

	@Override
	public Book create(Book b) {
		
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("insertBook");
		SqlParameterSource in=new MapSqlParameterSource().addValue("title", b.getTitle()).addValue("author", b.getAuthor()).addValue("isbn", b.getIsbn());	
		Map<String,Object> out=jdbcCall.execute(in);
		b.setIdBook((Integer)out.get("codbook"));
		return b;
		
	}
//	@Override
//	public List<Copy> getCopiesOf(int id) {
//
//		List<Copy> copies=null;
//		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getCopiesOfBook").returningResultSet("copies", new CopyMapper());
//		SqlParameterSource in=new MapSqlParameterSource().addValue("codBook", id);	
//		Map<String,Object> out=jdbcCall.execute(in);
//		copies=(List)out.get("copies");
//		
//		
//		return copies;
//	}

}
