package com.java.sample.boot.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.sample.boot.entity.User;
import com.java.sample.boot.mapper.UserRowMapper;

@Repository
public class UserRepository
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
    public List<User> findAll() 
    {
        return jdbcTemplate.query("select * from user_form",new UserRowMapper());
    }

	@Transactional(readOnly=true)
	public User findByID(long id)
	{
		return jdbcTemplate.queryForObject("select * from user_form where id=?", 
				new Object[]{id},
				new UserRowMapper());
	}
}
