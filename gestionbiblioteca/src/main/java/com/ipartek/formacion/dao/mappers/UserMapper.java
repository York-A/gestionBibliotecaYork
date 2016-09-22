package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.persistence.User;

public class UserMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rS, int rowNum) throws SQLException {
		User u=new User();
		u.setIdUser(rS.getInt("idUser"));
		u.setUserName(rS.getString("nameUser"));
		u.setUserSurname(rS.getString("surnameUser"));
		u.setbDate(rS.getDate("bDate"));
		u.setEmail(rS.getString("email"));
		u.setPassword(rS.getString("password"));
		return u;
	}

}
