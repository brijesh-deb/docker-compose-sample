package com.ge.predix.boot.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ge.predix.boot.entity.PredixUser;
import com.ge.predix.boot.mapper.PredixUserRowMapper;

@Repository
public class PredixUserRepository
{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional(readOnly=true)
    public List<PredixUser> findAll() 
    {
        return jdbcTemplate.query("select * from user_form",new PredixUserRowMapper());
    }

	@Transactional(readOnly=true)
	public PredixUser findByID(long id)
	{
		return jdbcTemplate.queryForObject("select * from user_form where id=?", 
				new Object[]{id},
				new PredixUserRowMapper());
	}
}
