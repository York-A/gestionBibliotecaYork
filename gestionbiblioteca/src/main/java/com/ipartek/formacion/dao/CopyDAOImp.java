package com.ipartek.formacion.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.ipartek.formacion.dao.interfaces.BookDAO;
import com.ipartek.formacion.dao.interfaces.CopyDAO;
import com.ipartek.formacion.dao.mappers.BookMapper;
import com.ipartek.formacion.dao.mappers.CopyMapper;
import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.persistence.Copy;


@Repository
public class CopyDAOImp implements CopyDAO{

	@Autowired(required=true)
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	
	
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@Override
	public List<Copy> getAll() {
		List<Copy> copies=null;
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getAllCopy").returningResultSet("copies", new CopyMapper());
		SqlParameterSource in=new MapSqlParameterSource();	
		Map<String,Object> out=jdbcCall.execute(in);
		copies=(List)out.get("copies");
		
		return copies;
	}

	@Override
	public void delete(int id) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("deleteCopy");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codCopy", id);	
		Map<String,Object> out=jdbcCall.execute(in);
		
	}

	@Override
	public Copy getById(int id) {

		Copy c=new Copy();
		
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getCopyById");
		c.setIdCopy(id);
		SqlParameterSource in=new MapSqlParameterSource().addValue("codCopy", c.getIdCopy());
		Map<String,Object>out=jdbcCall.execute(in);
		//c.setBook(getFullBook((Integer)out.get("out_book")));
		c.setnPages((Integer)out.get("out_npages"));
		c.setPublisher((String)out.get("out_publisher"));
		c.setRent((Integer)out.get("out_rent"));
return c;
	}

	@Override
	public Copy update(Copy c) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("updateBook");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codCopy", c.getIdCopy()).addValue("book", c.getBook().getIdBook()).addValue("publisher", c.getPublisher()).addValue("nPages", c.getnPages());	
		Map<String,Object> out=jdbcCall.execute(in);
		return c;
	}

	@Override
	public Copy create(Copy c) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("insertCopy");
		SqlParameterSource in=new MapSqlParameterSource().addValue("book", c.getBook().getIdBook()).addValue("publisher", c.getPublisher()).addValue("nPages", c.getnPages());	
		Map<String,Object> out=jdbcCall.execute(in);
		c.setIdCopy((Integer)out.get("codcopy"));
		
		
		return c;
	}
	
	public Book getFullBook(int id){
		Book b=null;
		ClassPathXmlApplicationContext contx=new ClassPathXmlApplicationContext("classpath:/spring.xml");
		BookDAO bDAO=contx.getBean(BookDAOImp.class);
		
		b=bDAO.getById(id);
		contx.close();
		return b;
	}

	@Override
	public Copy rent(Copy c, int idU) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("rentCopy");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codCopy", c.getIdCopy()).addValue("codUser", idU);	
		Map<String,Object> out=jdbcCall.execute(in);
		
		c.setRent(idU);
		return c ;
	}

}
