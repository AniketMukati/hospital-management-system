package com.springSecurity.repositary.userImplmt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.springSecurity.customException.ResourceNotFoundException;
import com.springSecurity.entity.Patient;
import com.springSecurity.repositary.CustomUserService;
import com.springSecurity.repositary.UserRepositary;



@Component
public class UserRepositaryService implements CustomUserService {
	
	
	
	Logger log = LoggerFactory.getLogger(CustomUserService.class);
	
	
	@Autowired
	UserRepositary userRepo;
	
	
	public Patient insertPatient(Patient patient) {
		
		log.info("inside insertPatient method :--------");
		
		patient.setId(patient.getId());
		patient.setDoctor(patient.getDoctor());
		
		System.out.println(patient.getId());
		
		patient.setIsActive("yes");
		
		System.out.println(patient.getDoctor());
		
		System.out.println("-------------------------------------------------------");
		
//		Patient savedPatient = null; 
//		try {
//			
//			savedPatient =  userRepo.setPatientInfoById(patient.Id,patient.address,patient.disease,patient.getDoctor() , patient.email , patient.name , patient.getAddmitted_Date());
//			
//			
//		} catch (Exception e) {
//			log.info("opps insertPatient method :--------");
//			System.out.println("Opps error!!!!!!!!!!!");
//
//		}
		

		System.out.println("-------------------------------------------------------");
		
		Patient savedPatient =  userRepo.save(patient);
		System.out.println(savedPatient);
		return savedPatient;
	}
	
	
	public Patient Patient(Patient patient) {
		
		Patient savedPatient =  userRepo.save(patient);
		System.out.println(savedPatient);
		return savedPatient;
	}
	
	
	
	public Patient updatePatient(Patient patient) {
		
		
	//	Patient updatePatient = userRepo.upd
		
		Optional<Patient> optional = null;
		
		try {
			
	//		optional = userRepo.updatePatientById(patient.getId(),patient.getAddress() , patient.getDisease(),patient.getDoctor(), patient.getEmail(),patient.name,patient.getAddmitted_Date());
			
			
		} catch (Exception e) {
			
			System.out.println("error i updateeee");
			
		}
	 	
		return optional.get();
	}
	
	
	
//	public boolean deletePatient(int id) {
//		
//		boolean flag = true;
//		
//		
//		Optional<Patient> patient = this.getPatientById(id);
//		
//		if (patient.isEmpty()) {
//			
//			flag = false;
//			
//			return flag; 
//		} 
//		
//		userRepo.delete(patient.get());
//
//		return flag;
//	}
	
	
	
//	public void deletePatient2(int id) {
//		
//		try {
//						
//			Optional<Patient> patient = this.getPatientById(id);
//			userRepo.deleteById(id);
//
//			
//		} catch (Exception e) {
//			System.out.println("error delete");
//			
//		
//		}
//		
//	}
	
	
	
	public Optional<Patient> getPatientById(@RequestParam("id") int id) {
		Optional<Patient> patient = null;
		
//		Patient patient = userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException(" Patient ", "patient_ID ",id));
		
		try {
			
			patient = userRepo.findById(id);
		//	patient = userRepo.findById(id).stream().filter(p->"yes".equals(p.getIsActive())).findFirst();
		}catch (Exception e) {
			System.out.println(" patieNt is not prest with id : " + id);
			throw new ResourceNotFoundException("Patient","patient ID ", id);
			
		}
		System.out.println(patient);
		
		return patient;
	}
	
	
	
	


	@Override
	public List<Patient> getAllPatient() {


		List<Patient> patientList =  new ArrayList<>();
		
		try {
			patientList =   userRepo.findAll().stream().filter(p-> p.getIsActive().equals("yes")).collect(Collectors.toList());
			
			
		}catch (Exception e) {
			System.out.println(" patieNt is not prest : ");
		
		}
		System.out.println(patientList);
		return patientList;
		
		
	}


	@Override
	public Patient deletePatient(Patient patient) {
		
		patient.setIsActive("no");
		
		Patient deletedPatient1 = userRepo.save(patient);
		
		
		
		return deletedPatient1;
	}
	
	
	
	
	
	
	
	
	
		
	
}
