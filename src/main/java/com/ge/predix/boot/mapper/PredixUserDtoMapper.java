package com.ge.predix.boot.mapper;

import com.ge.predix.boot.dto.PredixUserDto;
import com.ge.predix.boot.entity.PredixUser;

public class PredixUserDtoMapper {

	public static PredixUserDto mapUserDto(PredixUser user){
		if(null==user){
			return null;
		}
		PredixUserDto userDto = new PredixUserDto();
		userDto.setColumn1(user.getColumn1());
		userDto.setColumn2(user.getColumn2());
		userDto.setColumn3(user.getColumn3());
		userDto.setColumn4(user.getColumn4());
		userDto.setId(user.getId());
		return userDto;
	}
	
	public static PredixUser mapUserEntity(PredixUserDto userDto){
		if(null==userDto){
			return null;
		}
		PredixUser user = new PredixUser();
		user.setColumn1(userDto.getColumn1());
		user.setColumn2(userDto.getColumn2());
		user.setColumn3(userDto.getColumn3());
		user.setColumn4(userDto.getColumn4());
		user.setId(userDto.getId());
		return user;
	}
}
