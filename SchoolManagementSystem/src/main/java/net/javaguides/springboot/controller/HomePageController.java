package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaguides.springboot.service.ExamService;

import org.springframework.*;
import org.springframework.beans.factory.annotation.Autowired;

@Controller  
public class HomePageController {

	@Autowired
	private ExamService es;
	
	@RequestMapping(value="/")
	   public String displayHome()  
	    {  
	        return "Home";  
	    }   
	
	@RequestMapping(value="/AdminDashboard")
	   public String displayAdminDashBoard()  
	    {  
	        return "AdminDashboard";  
	    }   
	@RequestMapping(value="/ContactUs")
	   public String displayContactUs()  
	    {  
	        return "ContactUs";  
	    }   
	
	
//	@RequestMapping("/header")   
//		public String header() {
//		
//		return "header";
//	}
	
	
}
