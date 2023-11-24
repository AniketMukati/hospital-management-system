package com.springSecurity.authController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springSecurity.UserRepositaryLogin.UserServiceLoginImpl;
import com.springSecurity.payload.User;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class registerUser {
	
	
	@Autowired
	UserServiceLoginImpl userImpl;
	
	
	@GetMapping("/userRegistration")
	public String registerUser1() {
		
		return "userRegistration/userRegistrationPage";
	}
	
	
	@PostMapping("/register")
	public String resgisterPageUser(@ModelAttribute("User") User user,Model model) {
		
		Optional<User> optional = userImpl.getUserByEmailCheck(user.email);
		
	//	System.out.println(optional.get());
		
	log.info(" registerUser class is called  resgisterPageUser");
	
		
		if(optional.isPresent()) {
			model.addAttribute("msg","user with this email Id is allready present! ");
			
			
			return "userRegistration/userRegistrationPage";
		}
		
		User createdUser = userImpl.createUser(user);
		model.addAttribute("user",createdUser);
		log.info(" registerUser class is called  resgisterPageUser 2 ");

		
		return "userRegistration/succesLogin";
	}
	
	
	
	
	
	

}
