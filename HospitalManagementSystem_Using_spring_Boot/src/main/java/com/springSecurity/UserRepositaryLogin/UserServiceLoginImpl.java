package com.springSecurity.UserRepositaryLogin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.springSecurity.customException.ResourceNotFoundException;
import com.springSecurity.payload.User;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class UserServiceLoginImpl {
	
	
	@Autowired
	private UserRepositaryLogin userLogin;
	
	
	public User getUserByEmail(String username) {
		User user = userLogin.findByEmail(username).orElseThrow(()-> new ResourceNotFoundException(" username "," email " + username, 0));
		
		
		return user;
	}
	
	
	
	public User createUser(User user) {
		
	
		
		 User savedUser = userLogin.save(user);
		
		
		return savedUser;
	}
	
	
	public Optional<User> getUserById(int userid) {	
		
		 Optional<User> optional = userLogin.findById(userid);
		
		
		return optional;
	}
	
	
	public Optional<User> getUserByEmailCheck(String userid) {	
		
		 Optional<User> optional = userLogin.findByEmail(userid);
		
		
		return optional;
	}
	
	
	public List<User> getAllUsers() {	

		 List<User> userList =(List<User>) userLogin.findAll().stream().filter(u->u.getRole().equals("ROLE_USER")).collect(Collectors.toList());
		
		 System.out.println(userList);
		
		 log.info("getAllUsers is called ");
		 
//		 List<User> userList =(List<User>) userLogin.findAll().stream().filter(u->u.getAuthorities().stream().filter(a->a.equals("ADMIN")).collect(Collectors.toList()));
		
		
		return userList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
