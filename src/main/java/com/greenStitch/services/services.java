package com.greenStitch.services;

import com.greenStitch.entity.signUp;

public interface services {
	
		String addUsers(signUp user);
		
		boolean id(int id);
		
		boolean checkEmail(String email);
		
		boolean validate(String email, String password);
}
