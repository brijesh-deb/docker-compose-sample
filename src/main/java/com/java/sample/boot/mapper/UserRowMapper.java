package com.java.sample.boot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.java.sample.boot.entity.User;

public class UserRowMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		User user = new User();
		user.setId(rs.getInt("id"));
		user.setColumn1(rs.getString("column1"));
		user.setColumn2(rs.getString("column2"));
		user.setColumn3(rs.getString("column3"));
		user.setColumn4(rs.getString("column4"));
		return user;
	}
}
