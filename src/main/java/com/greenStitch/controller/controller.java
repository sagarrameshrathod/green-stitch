package com.greenStitch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greenStitch.entity.signUp;
import com.greenStitch.services.services;

@Controller
public class controller {
	
	@Autowired
	services service;
	
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	
	@GetMapping("/signIn")
	public String sign() {
		return "signIn";
	}
	
	@GetMapping("/signUp")
	public String signU() {
		return "signUp";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("id")int id, 
			@RequestParam("name")String name, 
			@RequestParam("email")String email, 
			@RequestParam("password")String password) 
	{
		boolean idExist = service.id(id);
		boolean emailExist=service.checkEmail(email);
		if(!idExist && !emailExist) {
			signUp user = new signUp();
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			service.addUsers(user);

			return "signIn";
		}
		else {
			return "signUp";
		}
	}
	
	@PostMapping("/login")
	public String validate(@RequestParam("email")String email,
				@RequestParam("password")String password) {
		boolean val=service.validate(email, password);
		if(val==true) {
			return "welcome";
		}
		else {
			return "signIn";
		}
	}

}
