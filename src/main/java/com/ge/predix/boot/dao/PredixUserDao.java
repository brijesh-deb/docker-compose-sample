package com.ge.predix.boot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ge.predix.boot.entity.PredixUser;
import com.ge.predix.boot.repository.PredixUserRepository;

@Component
public class PredixUserDao {

	@Autowired
	PredixUserRepository userRepository;
	
	public List<PredixUser> getAllUsers() throws Exception{
		List<PredixUser> predixUserList =userRepository.findAll();
		if(null==predixUserList||predixUserList.isEmpty()){
			throw new Exception("No Data Found");
		}
		return predixUserList;
	}

	public PredixUser getUserByID(long id) throws Exception{
		PredixUser predixUser =userRepository.findByID(id);
		if(null==predixUser){
			throw new Exception("No Data Found");
		}
		return predixUser;
	}
}
