package com.springSecurity.securityConfig;

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springSecurity.UserRepositaryLogin.UserRepositaryLogin;
import com.springSecurity.UserRepositaryLogin.UserServiceLoginImpl;
import com.springSecurity.payload.*;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	public UserServiceLoginImpl userRepoLogin;
	
	
	@Autowired
	private UserRepositaryLogin userLoginUser;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		
		
		User user =  userLoginUser.findByEmail(username).orElseThrow(()-> new RuntimeException("user not foud"));
		
		log.info("---------------CustomUserDetailsService class is ");
		
		
		return user;
	}

}
