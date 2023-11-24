package com.springSecurity.customException;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionClass {


    @ExceptionHandler(AccessDeniedException.class)
    public String handleExceptions( AccessDeniedException exception , Model model ) {
        model.addAttribute("msg","you cant acces this page");
        
        model.addAttribute("msg2","you are normal user ! only admin caN access");
        
        return "Exceptions/AccessDeniedPage";
    }
    
    
    @ExceptionHandler(Exception.class)
    public String handleException2( Exception exception , Model model ) {
        model.addAttribute("msg","oops something wrong");
        
        model.addAttribute("msg2","sorry!");
        
        return "Exceptions/AccessDeniedPage";
    }
    
    @ExceptionHandler(Error.class)
    public String handleException3( Error e , Model model ) {
        model.addAttribute("msg","oops something wrong");
        
        model.addAttribute("msg2","sorry!");
        
        return "Exceptions/AccessDeniedPage";
    }
    
	
	
}
