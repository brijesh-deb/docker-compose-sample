package com.ge.predix.boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ge.predix.boot.entity.PredixUser;

public class PredixUserRowMapper implements RowMapper<PredixUser>
{

	@Override
	public PredixUser mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		PredixUser predixUser = new PredixUser();
		predixUser.setId(rs.getInt("id"));
		predixUser.setColumn1(rs.getString("column1"));
		predixUser.setColumn2(rs.getString("column2"));
		predixUser.setColumn3(rs.getString("column3"));
		predixUser.setColumn4(rs.getString("column4"));
		return predixUser;
	}
}
