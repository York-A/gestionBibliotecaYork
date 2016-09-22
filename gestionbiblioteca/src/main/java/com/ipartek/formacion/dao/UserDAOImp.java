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

import com.ipartek.formacion.dao.interfaces.UserDAO;
import com.ipartek.formacion.dao.mappers.BookMapper;
import com.ipartek.formacion.dao.mappers.UserMapper;
import com.ipartek.formacion.dao.persistence.Book;
import com.ipartek.formacion.dao.persistence.User;

@Repository
public class UserDAOImp implements UserDAO{
	
	@Autowired(required=true)
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.dataSource=dataSource;
		this.jdbcCall = new SimpleJdbcCall(dataSource);
	}

	@Override
	public List<User> getAll() {
		List<User>users=null;
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getAllUser").returningResultSet("users", new UserMapper());
		SqlParameterSource in=new MapSqlParameterSource();	
		Map<String,Object> out=jdbcCall.execute(in);
		users=(List)out.get("users");
		return users;
	}

	@Override
	public void delete(int id) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("deleteUser");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codUser", id);	
		Map<String,Object> out=jdbcCall.execute(in);
		
	}

	@Override
	public User getById(int id) {
		User user=new User();
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("getUserById");
		user.setIdUser(id);		
		SqlParameterSource in=new MapSqlParameterSource().addValue("codUser", user.getIdUser());
		Map<String,Object>out=jdbcCall.execute(in);
		
		System.out.println((String)out.get("out_nameuser"));
		
		user.setbDate((java.util.Date)out.get("out_bdate"));
		user.setEmail((String)out.get("out_email"));
		user.setPassword((String)out.get("out_password"));
		user.setUserName((String)out.get("out_nameuser"));
		user.setUserSurname((String)out.get("out_surnameuser"));
		
		return user;
	}

	@Override
	public User update(User u) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("updateUser");
		SqlParameterSource in=new MapSqlParameterSource().addValue("codUser", u.getIdUser()).addValue("nameUser", u.getUserName()).addValue("surnameUser", u.getUserSurname()).addValue("bDate", u.getbDate()).addValue("email", u.getEmail()).addValue("password", u.getPassword());	
		Map<String,Object> out=jdbcCall.execute(in);
		return u;
	}

	@Override
	public User create(User u) {
		this.jdbcCall=new SimpleJdbcCall(dataSource).withProcedureName("insertUser");
		SqlParameterSource in=new MapSqlParameterSource().addValue("nameUser", u.getUserName()).addValue("surnameUser", u.getUserSurname()).addValue("bDate", u.getbDate()).addValue("email", u.getEmail()).addValue("password", u.getPassword());	
		Map<String,Object> out=jdbcCall.execute(in);
		u.setIdUser((Integer)out.get("coduser"));
		
		return u;
	}

}
