package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



import net.javaguides.springboot.model.Marks;
import net.javaguides.springboot.service.MarksService;

@Controller
public class MarksController {

	@Autowired
	private  MarksService mr;

	@GetMapping(value="/listOfAllMarks")
	public String showMarksPage(Model model,String keyword) {
		
		if(keyword!=null) {
			model.addAttribute("listOfMarks",mr.findByKeyword(keyword));
		}else {
		model.addAttribute("listOfMarks",mr.getAllExamMarks());
		}
		return "viewMarks";	
	}
	
	
	@GetMapping(value="/showNewMarksForm")
	public String showNewMarksFormPage(Model model) {
		
		Marks marks=new Marks();
		model.addAttribute("listmarks",marks);
		
		return "newMarks";
		
	}
	
	@PostMapping(value="/saveMarks")
	public String saveMarks(@ModelAttribute("listmarks") Marks marks) {
		
		this.mr.saveExamMarks(marks);
		
		return "redirect:/showNewMarksForm";

	}
	
	@GetMapping(value="/updateMarks/{exam_marks_id}")
	public String updateMarks(@PathVariable(value="exam_marks_id")int exam_marks_id,Model model) {
		
		Marks marks= mr.getMarksById(exam_marks_id);
		model.addAttribute("updateMarks",marks);
		return "updateMarks";
		
	}
	
	@GetMapping(value="/deleteMarks/{exam_marks_id}")
	public String deleteMarks(int exam_marks_id) {
		mr.deleteMarksById(exam_marks_id);
		return "redirect:/listOfMarks";
	}
	
	@RequestMapping(value="/ExamIdAutoComplete")
	@ResponseBody
	public List<String> ExamIdAutoComplete(@RequestParam(value="term",required=false,defaultValue="111") String term){

		List<String> suggestions=mr.AllExamsId();
		System.out.println(suggestions);
		return suggestions;
	}
	

	@RequestMapping(value="/StudentIdAutoComplete")
	@ResponseBody
	public List<String> StudentIdAutoComplete(@RequestParam(value="term",required=false,defaultValue="111") String term){

		List<String> suggestions=mr.AllStudentId();
		System.out.println(suggestions);
		return suggestions;
	}
	
	@RequestMapping(value="/findExamId")
	public String viewHomePage(Model model,String keyword) {
		
		int ExamId=0;
		if(keyword!=null) {
			ExamId =mr.getExamId(keyword);
			model.addAttribute("ExamId", ExamId);
		}
		
		System.out.println(ExamId);
		return "redirect:/showNewMarksForm";
	}

	
	
	
//	public List<String> ExamNameAutoComplete(@RequestParam(value="term",required=false,defaultValue="111") String term){
//
//		List<String> suggestions=mr.AllExamsNames();
//		System.out.println(suggestions);
//		return suggestions;
//	}
	
}
