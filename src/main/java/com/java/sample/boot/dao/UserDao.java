package com.java.sample.boot.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.java.sample.boot.entity.User;
import com.java.sample.boot.repository.UserRepository;

@Component
public class UserDao {

	@Autowired
	UserRepository userRepository;
	
	public List<User> getAllUsers() throws Exception{
		List<User> userList =userRepository.findAll();
		if(null==userList||userList.isEmpty()){
			throw new Exception("No Data Found");
		}
		return userList;
	}

	public User getUserByID(long id) throws Exception{
		User user =userRepository.findByID(id);
		if(null==user){
			throw new Exception("No Data Found");
		}
		return user;
	}
}
