package com.springSecurity.controller;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springSecurity.customException.ResourceNotFoundException;
import com.springSecurity.entity.Patient;
import com.springSecurity.repositary.UserRepositary;
import com.springSecurity.repositary.userImplmt.UserRepositaryService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MainPageController {
	
	
	@Autowired
	UserRepositaryService userRepo;
	
//	@RequestMapping("/delete/{id}")
//	public String loginPage(@PathVariable("id") int id) {
//		  try {
//			  System.out.println(id);
//				userRepo.deletePatient2(id);
//
//			  
//		} catch (Exception e) {
//			System.out.println("error delelter");
//		
//		}
//		
//		
//		
//		return "showpatientdetails";
//	}
//	
	
	
	@RequestMapping("/Mloginpageuser")
	public String loginPage1() {
		  
		
		return "loginpage";
	}
	
	
	
	
	@RequestMapping("/Mloginpageuser2")
	public String loginPage2() {
		  
		
		return "loginpage";
	}
	
	
	
	
	@RequestMapping("/Mloginpageusers3")
	public String loginPage3() {
		  
		
		return "loginpage";
	}
	
	
	
	@RequestMapping("/deletepatient/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ModelAndView loginPage5(@PathVariable("id") int id) {
		  

		
		System.out.println(id);
		
	//	int pid = Integer.parseInt(id);
		
		ModelAndView model = new ModelAndView();
		
		Optional<Patient> patient = null ;
		
		try {
			patient = userRepo.getPatientById(id);
			System.out.println(patient);
		}
		catch (Exception e) {
			System.out.println("patient is not prest : ");
			
			throw new ResourceNotFoundException("Patiet" , "patiet Id ", id );
		}
		model.addObject("patient", patient.get());
		model.addObject("msg","confirm delete the user : ");
		model.setViewName("ConfirmDelete");

		log.info("MainPageController method is called deletePatiet : ");

		
	

	return model;
	}
	
	
	
	@RequestMapping("/Mloginpageusers12")
	public String loginPage4() {
		  
		
		return "loginpage";
	}
	

}
