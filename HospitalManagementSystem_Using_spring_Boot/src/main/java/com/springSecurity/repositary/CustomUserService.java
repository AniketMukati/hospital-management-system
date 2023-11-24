package com.springSecurity.repositary;

import java.util.List;
import java.util.Optional;

import com.springSecurity.entity.Patient;

public interface CustomUserService {

	Patient insertPatient(Patient patient);
	
	Patient deletePatient(Patient patient);
	
	Patient updatePatient(Patient patient);
	
	List<Patient> getAllPatient();
	
	Optional<Patient> getPatientById(int id);
	
	
	
	
	
	
}
