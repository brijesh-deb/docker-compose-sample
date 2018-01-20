package com.java.sample.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ge.predix.boot.dao.ParentTableDao;
import com.java.sample.boot.dao.UserDao;
import com.java.sample.boot.dto.UserDto;
//import com.ge.predix.boot.entity.ChildTable;
import com.java.sample.boot.entity.User;
//import com.ge.predix.boot.entity.Table1;
import com.java.sample.boot.mapper.UserDtoMapper;

@Service
public class UserService {

	@Autowired
	UserDao predixUserDao;
	
	public List<UserDto> getAllUsers() throws Exception{
		List<UserDto> usrDto = new ArrayList<UserDto>(); 
		List<User> userList =predixUserDao.getAllUsers();
		if(null==userList||userList.isEmpty()){
			throw new Exception("No Data Found");
		}
		else{
			for(User user :userList){
				usrDto.add(UserDtoMapper.mapUserDto(user));
			}
		}
		return usrDto;
	}

	public UserDto getById(long id) throws Exception{
		UserDto usrDto = new UserDto(); 
		User user =predixUserDao.getUserByID(id);
		if(null==user){
			throw new Exception("No Data Found");
		}
		else{
			usrDto = UserDtoMapper.mapUserDto(user);
		}
		return usrDto;
	}
}
