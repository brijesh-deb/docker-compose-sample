package com.java.sample.boot.mapper;

import com.java.sample.boot.dto.UserDto;
import com.java.sample.boot.entity.User;

public class UserDtoMapper {

	public static UserDto mapUserDto(User user){
		if(null==user){
			return null;
		}
		UserDto userDto = new UserDto();
		userDto.setColumn1(user.getColumn1());
		userDto.setColumn2(user.getColumn2());
		userDto.setColumn3(user.getColumn3());
		userDto.setColumn4(user.getColumn4());
		userDto.setId(user.getId());
		return userDto;
	}
	
	public static User mapUserEntity(UserDto userDto){
		if(null==userDto){
			return null;
		}
		User user = new User();
		user.setColumn1(userDto.getColumn1());
		user.setColumn2(userDto.getColumn2());
		user.setColumn3(userDto.getColumn3());
		user.setColumn4(userDto.getColumn4());
		user.setId(userDto.getId());
		return user;
	}
}
