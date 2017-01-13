package com.ge.predix.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.ge.predix.boot.dao.ParentTableDao;
import com.ge.predix.boot.dao.PredixUserDao;
import com.ge.predix.boot.dto.PredixUserDto;
//import com.ge.predix.boot.entity.ChildTable;
import com.ge.predix.boot.entity.PredixUser;
//import com.ge.predix.boot.entity.Table1;
import com.ge.predix.boot.mapper.PredixUserDtoMapper;

@Service
public class UserService {

	@Autowired
	PredixUserDao predixUserDao;
	
	public List<PredixUserDto> getAllUsers() throws Exception{
		List<PredixUserDto> predixUsrDto = new ArrayList<PredixUserDto>(); 
		List<PredixUser> predixUserList =predixUserDao.getAllUsers();
		if(null==predixUserList||predixUserList.isEmpty()){
			throw new Exception("No Data Found");
		}
		else{
			for(PredixUser user :predixUserList){
				predixUsrDto.add(PredixUserDtoMapper.mapUserDto(user));
			}
		}
		return predixUsrDto;
	}

	public PredixUserDto getById(long id) throws Exception{
		PredixUserDto predixUsrDto = new PredixUserDto(); 
		PredixUser predixUser =predixUserDao.getUserByID(id);
		if(null==predixUser){
			throw new Exception("No Data Found");
		}
		else{
				predixUsrDto = PredixUserDtoMapper.mapUserDto(predixUser);
		}
		return predixUsrDto;
	}
}
