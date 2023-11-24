package com.springSecurity.doctorRepositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springSecurity.entity.Doctor;

public interface doctorRepositary extends JpaRepository<Doctor, String> {
	
	

}