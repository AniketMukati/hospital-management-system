package com.springSecurity.doctorRepositary.doctorService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springSecurity.doctorRepositary.doctorRepositary;
import com.springSecurity.entity.Doctor;

@Component
public class DoctorRepositaryService {
		
	@Autowired
	doctorRepositary doctorRepo;
	
	public ArrayList<Doctor> getAllDoctors() {
		
		ArrayList<Doctor> listOfDoctor = (ArrayList<Doctor>) doctorRepo.findAll();
		
		return listOfDoctor;
	}
	
	
	public Doctor saveDoctor(Doctor doctor) {
		
		Doctor savedDoctor =	doctorRepo.save(doctor);
		System.out.println(savedDoctor);
		
		return savedDoctor;
	}
	
	
	public Doctor getDoctorById(String doctorId) {
		System.out.println("------------------");
		Doctor doctorById =	doctorRepo.getReferenceById(doctorId);
		System.out.println(doctorId);
		return doctorById;
	}
	
	
}
