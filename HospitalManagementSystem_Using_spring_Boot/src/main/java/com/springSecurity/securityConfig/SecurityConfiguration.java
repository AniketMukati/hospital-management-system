package com.springSecurity.securityConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
@EnableMethodSecurity
public class SecurityConfiguration {

	 @Bean
	    public PasswordEncoder passwordEncoder() {
	        log.info("passwordEncoder method is called");
	        return new BCryptPasswordEncoder();
	    }

//	    @Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth
//	            .inMemoryAuthentication()
//	            .withUser("user")
//	            .password("$2a$12$kMxmyYrwORY97uMIJdYWLOQ1ewojSvFTG/fIT6R7qI.YANLOBVla2")
//	            .roles("USER");
//	    }

	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http.authorizeRequests(authorizeRequests ->
	            authorizeRequests
	                .requestMatchers(new AntPathRequestMatcher("/home/**")).authenticated()
	                .anyRequest().authenticated()
	        )
	        .formLogin(); // Assuming form-based login is used

	        // Disable CSRF (Cross-Site Request Forgery) protection
	        http.csrf().disable();

	        // Disable CORS (Cross-Origin Resource Sharing)
	        http.cors().disable();

	        return http.build();
	    }
	

	    
// 	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
		http.csrf(csrf-> csrf.disable())
			.cors(cors->cors.disable())
			.authorizeHttpRequests(auth-> auth
							.requestMatchers(new AntPathRequestMatcher("/home/**")).authenticated()
							.requestMatchers(new AntPathRequestMatcher("/generatetoken","/userRegistration")).permitAll()
							.anyRequest().authenticated());
						
	//					.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
	//					.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		
	//	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
					
		
		
		
		return http.build();
	}
	    
	    
	    
	    
	    
	    
	    
	    
	    
	
////	
//	@Bean
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception  {
//		http.csrf(csrf-> csrf.disable())
//			.cors(cors->cors.disable())
//			.authorizeHttpRequests(auth-> auth
//							.requestMatchers("/home/**").authenticated()
//							.requestMatchers("/generatetoken","/auth/login").permitAll()
//							.anyRequest().authenticated())
//						
//	//					.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
//						.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//		
//	//	http.addFilterBefore(filter,UsernamePasswordAuthenticationFilter.class);
//					
//		
//		
//		
//		return http.build();
//	}
	
	
	  @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		  
		  	log.info("authenticationManager method is called");
		  	
	        return builder.getAuthenticationManager();
	    }
	  }
	
