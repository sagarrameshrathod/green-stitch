package com.greenStitch.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greenStitch.entity.signUp;

public interface repository extends JpaRepository<signUp, Integer>{
	
    boolean existsByEmail(String email);
	
	signUp getByEmail(String email);
}
