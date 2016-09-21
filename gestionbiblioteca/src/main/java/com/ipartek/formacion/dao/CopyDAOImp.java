package com.ipartek.formacion.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import com.ipartek.formacion.dao.interfaces.CopyDAO;
import com.ipartek.formacion.dao.persistence.Copy;


@Repository
public class CopyDAOImp implements CopyDAO{

	@Autowired(required=true)
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		this.jdbcTemplate=new JdbcTemplate(dataSource);
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}
	
	@Override
	public List<Copy> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Copy getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Copy update(Copy c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Copy create(Copy c) {
		// TODO Auto-generated method stub
		return null;
	}

}
