package net.javaguides.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminDashBoardController {

	@GetMapping("/showStudent")
	public String showStudent() {
		return null;
		
	}
	
	//Adding new Exam
	@GetMapping("/addNewExam")
	public String addNewExam() {
		return "newExam";
		
	}
	//View the exams
//	@GetMapping("/listExam?keyword=")
//	public String viewExam() {
//		return "viewExam";
//		
//	}
	
//	//Add the exams marks
//	@GetMapping("/newExamMarks")
//	public String newExamMarks() {
//		return "newExamMarks";
//			
//	}
	
//	@GetMapping("/showStudent")
//	public String showStudent() {
//		return null;
//		
//	}
//	
//	@GetMapping("/showStudent")
//	public String showStudent() {
//		return null;
//		
//	}
	
}
