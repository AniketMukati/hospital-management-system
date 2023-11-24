package com.springSecurity.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.springSecurity.UserRepositaryLogin.UserServiceLoginImpl;
import com.springSecurity.doctorRepositary.doctorService.DoctorRepositaryService;
import com.springSecurity.entity.Doctor;
import com.springSecurity.entity.Patient;
import com.springSecurity.payload.User;
import com.springSecurity.repositary.userImplmt.UserRepositaryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RestController;

//import com.springSecurity.entity.User;

@Controller
//@RestController

@RequestMapping("/home")
@Slf4j
public class HomeController {
	
	@Autowired
	UserRepositaryService userservice;
	
	@Autowired
	UserServiceLoginImpl userlogin;
	

	
	@Autowired
	DoctorRepositaryService doctorRepo;
	
	
	@RequestMapping("/homehtml")
	public String createUser() {
		  
		
		return "home";
	}
	
	
	@RequestMapping("/homejsp")
	public String createUsers() {
		  
		
		return "home1";
	}
	
	@RequestMapping("/loginpageuser")
	public String loginPage() {
		  
		
		return "loginpage";
	}
	
	
	
	
	@GetMapping("/insertpatient")
	@PreAuthorize("hasRole('ADMIN')")
	public String insertPatient(Model model, HttpServletRequest req) {
		
		ArrayList<Doctor> doctorList = doctorRepo.getAllDoctors();
		
		model.addAttribute("doctorList",doctorList);
		
		
		
		return "insertPatientPage";
	}
	
	
	
	@PostMapping("/afterInserting")
	public String succes(@ModelAttribute("Patient") Patient patient
								,HttpServletRequest request
								,@RequestParam("item") String d
								,Model model){
		
		
		String name = request.getParameter("name");
		System.out.println(name);
		

		
		System.out.println(patient);
		System.out.println(d);
		
//		int doctorId = Integer.parseInt(d);
//		System.out.println(doctorId);
		Doctor docterById = doctorRepo.getDoctorById(d);
		System.out.println(docterById);
	//	Doctor doctor =	patient.getDoctor();
	//	String doctor_id = doctor.getId();
		patient.setDoctor(docterById);
	//	System.out.println(doctor); 
		System.out.println(patient);
	//	doctorRepo.saveDoctor(doctor);
		Patient saved_patient = userservice.insertPatient(patient);
		
		
		model.addAttribute("patient" ,saved_patient);
		
	//	User savedUser = serviceRepo.createUser(user);  
		
		return "succes";
	}
	
	
	
	
	@GetMapping("/deletepatient")
	public String deletepatient(Model model) {	
		
		model.addAttribute("msg", "Enter the id you want to delete the patient : ");
		return "deletePatientPage";
	}
	
	
	
	
	
	@PostMapping("/confirmDeletePatient")
	public ModelAndView confirmDeletePatient(@RequestParam("Id") int id) {	
		
		System.out.println(id);
		ModelAndView model = new ModelAndView();
		
		Optional<Patient> patient = null ;
		
		try {
			patient = userservice.getPatientById(id);
			System.out.println(patient);
		}
		catch (Exception e) {
			System.out.println("patient is not prest : ");
		}
			
		
		if (patient.isEmpty()) {
				model.addObject("msg","patient is not prest : ");
				model.addObject("msg2","plz re - enter the id s ");				
				model.setViewName("deletePatientPage");
//				
				System.out.println("check");
				
				return model; 
			}
			
			model.addObject("patient", patient.get());
			model.addObject("msg","confirm delete the user : ");
			model.setViewName("ConfirmDelete");

			System.out.println("check - 2 ");

			
		
	
		return model;
	
	}
	
	
	
	
	
	
	
	@PostMapping("/deletesucces")
	public String deletesuccess(HttpSession session,Model model , HttpServletRequest request) {
		
		
		log.info("---HomeController is called deletesuccess method : ");
	
//		Patient patient = (Patient)  request.getAttribute("patient");
		System.out.println("------------------");
//		System.out.println(patient);
		 
		Patient patient = (Patient) session.getAttribute("patient");
		
		
		System.out.println(patient);
	System.out.println("success fuly fetch  the patie:");	
		
		
		
		
		try {
			userservice.deletePatient(patient); 

		} catch (Exception e) {
			System.out.println("some error in deleteing patient : ");
			e.printStackTrace();
		}
		
		
		model.addAttribute("patient",patient);
		return "redirect:showpatientdetails";
		
		
		
	}
	
	
	
	@GetMapping("/updatePatient")
	public String updatePatient() {
		
//		User savedUser = serviceRepo.createUser(user);  
		
		return "updatePatient";
	}
	
	
	@PostMapping("/updateId")
	public String updateById(@RequestParam("Id") int id , Model model) {
		
		Optional<Patient>  optional = null;
		
		try {
			
			  optional = userservice.getPatientById(id);
			
		} catch (Exception e) {
			
			System.out.println("error in update");
			
			
		}
		 
		if(optional.isEmpty()) {
			
			model.addAttribute("msg","plz check the input! ");
			model.addAttribute("msg","re - enter the id : ");
			return "updatePatient";
		}
		
		  model.addAttribute("msg","update the patient !");

		  ArrayList<Doctor> doctorList = doctorRepo.getAllDoctors();
		  
		  model.addAttribute("patient", optional.get()); 
		  model.addAttribute("doctorList", doctorList);
		
		
		
		return "confirmUpdate";
	}
	
	
	@PostMapping("/afterUpdate")
	public String updateById(@ModelAttribute("Patient")  Patient patient , Model model) {
		  
		System.out.println("check");
		
		Patient updatedPatient = null;
		
		try {
			
			updatedPatient = userservice.insertPatient(patient);

		} catch (Exception e) {
			System.out.println("error iN insert  : ");
		}
		  
		model.addAttribute("patient",updatedPatient); 
		
		return "succesUpdate";
	}
	
	
	@GetMapping("/showpatientdetails")
	public String ShowAllPatient(Model model) {
		
//		User savedUser = serviceRepo.createUser(user);  
		
		ArrayList<Patient> patientList = (ArrayList<Patient>) userservice.getAllPatient();
		
		model.addAttribute("patientList", patientList);
		
		return "MainPagePatientDetails";
	}
	
	
	@GetMapping("/findPatient")
	public String showSinglePatient() {
		
//		User savedUser = serviceRepo.createUser(user);  
		
		return "findPatient";
	}
	
	
	
	@GetMapping("/showSinglePatient")
	public String findPatient(@RequestParam("Id") int id,Model model) {
		
		Optional<Patient> optional = userservice.getPatientById(id);  
		
		 
		if(optional.isEmpty()) {
			
			model.addAttribute("msg"," id is Not presnt ! ");
			model.addAttribute("msg2"," plz! Re - enter the id : ");
			return "findPatient";
		}else if (optional.get().getIsActive().equals("no")) {
			model.addAttribute("msg"," patient is recently deleted  ! ");
			model.addAttribute("msg2"," But it is present in database with 'no' active mode: ");
			return "findPatient";
			
		}
		
		else {
			model.addAttribute("patient", optional.get());

		}
		
		
		
		
		return "singlePatientDetail";
	}
	
	
	
	@GetMapping("/registeredUser")
	public String ShowAllRegisterUser(Model model) {
		
//		User savedUser = serviceRepo.createUser(user);  
		
		log.info("-------ShowAllRegisterUser is called");
		
		ArrayList<User> userList = (ArrayList<User>) userlogin.getAllUsers();
		
		model.addAttribute("userList", userList);
		
		return "registerUserList";
	}
	
	
	
}
