package com.springSecurity.UserRepositaryLogin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository; 

import com.springSecurity.payload.User;

public interface UserRepositaryLogin extends JpaRepository<User, Integer> {
	
	
	Optional<User> findByEmail(String email);
	
	
	
}
