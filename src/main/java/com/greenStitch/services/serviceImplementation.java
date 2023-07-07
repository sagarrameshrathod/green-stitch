package com.greenStitch.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenStitch.entity.signUp;
import com.greenStitch.repository.repository;

@Service
public class serviceImplementation implements services{
	
	@Autowired
	repository repo;
	
	@Override
	public String addUsers(signUp user) {
		repo.save(user);
		return "Sudent added successfully!";
	}
	
	@Override
	public boolean id(int id) {
		return repo.existsById(id);
	}

	@Override
	public boolean checkEmail(String email) {
		return repo.existsByEmail(email);
	}

	@Override
	public boolean validate(String email, String password) {
		if(repo.existsByEmail(email)) {
			signUp u=repo.getByEmail(email);
			String dbPassword=u.getPassword();
			if(password.equals(dbPassword)) {
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false; 
		}
	}

}
