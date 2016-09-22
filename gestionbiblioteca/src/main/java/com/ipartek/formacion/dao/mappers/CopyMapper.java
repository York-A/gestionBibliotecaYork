package com.ipartek.formacion.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ipartek.formacion.dao.CopyDAOImp;
import com.ipartek.formacion.dao.persistence.Copy;

public class CopyMapper implements RowMapper<Copy>{

	private CopyDAOImp cDAO;
	@Override
	public Copy mapRow(ResultSet rS, int rowNum) throws SQLException {
		Copy c=new Copy();
		c.setIdCopy(rS.getInt("idBook"));
		c.setPublisher(rS.getString("publisher"));
		c.setnPages(rS.getInt("nPages"));
		c.setRent(rS.getInt("rent"));
		c.setBook(cDAO.getFullBook(rS.getInt("book")));
		
		return c;
	}

	
}
