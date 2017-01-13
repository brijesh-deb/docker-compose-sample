package com.ge.predix.boot.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ge.predix.boot.dto.PredixUserDto;
import com.ge.predix.boot.service.UserService;

@RestController
@RequestMapping("av/tm/dataService")
public class UserController {

	@Autowired
	UserService userService; 
	
	@RequestMapping(value="userForms",method=RequestMethod.GET)
	public List<PredixUserDto> getAllUserDetails(@Context HttpServletResponse servletResponse) 
	{
		System.out.println(" Inside UserController: getAllUserDetails");
		try {
			servletResponse.setHeader("Access-Control-Allow-Origin", "*");
			return userService.getAllUsers();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value="userForm/{id}",method=RequestMethod.GET)
	public PredixUserDto getUserDetails(@PathVariable(value="id") Long id,@Context HttpServletResponse servletResponse) 
	{
		System.out.println(" Inside UserController: getUserDetails");
		servletResponse.setHeader("Access-Control-Allow-Origin", "*");
		PredixUserDto userDto = null;
		try {
			userDto=userService.getById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return userDto;
	}
}
