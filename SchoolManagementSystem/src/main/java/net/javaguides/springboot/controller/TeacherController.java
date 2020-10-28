package net.javaguides.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.javaguides.springboot.model.Teacher;
import net.javaguides.springboot.service.TeacherService;

@Controller
public class TeacherController {

	@Autowired
	private TeacherService teacherService;
	
	// display list of teachers
	@GetMapping(value="/viewTeachers")
	public String viewHomePage(Model model,String keyword) {

		if(keyword!=null) {
			
		model.addAttribute("listTeacher",teacherService.findTeacher(keyword));
		
		}else {
		model.addAttribute("listTeacher",teacherService.getAllTeachers());
		}
		return "viewTeachers";	
	}
	
	@GetMapping(value="/showNewTeacherForm")
	public String showNewTeacherForm(Model model) {
		// create model attribute to bind form data
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "new_teacher";
	}
	
	@PostMapping(value="/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		// save employee to database
		this.teacherService.saveTeacher(teacher);
		return "redirect:/viewTeachers";
	}
	
	@GetMapping(value="/updateTeacher/{teacher_id}")
	public String showTeacherUpdate(@PathVariable ( value = "teacher_id") long teacher_id, Model model) {
		
		// get employee from the service
		Teacher teacher = teacherService.getTeachersById(teacher_id);
		
		// set employee as a model attribute to pre-populate the form
		model.addAttribute("teacher",teacher );
		return "update_teacher";
	}
	
	@GetMapping(value="/deleteTeacher/{teacher_id}")
	public String deleteTeacher(@PathVariable (value = "teacher_id") long teacher_id) {
		
		// call delete employee method 
		this.teacherService.deleteTeachersById(teacher_id);
		return "redirect:/viewTeachers";
	}
	

//	
//	
//	@GetMapping(value="/page/{pageNo}")
//	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
//			@RequestParam("sortField") String sortField,
//			@RequestParam("sortDir") String sortDir,
//			Model model) {
//		int pageSize = 5;
//		
//		Page<Teacher> page = employeeService.findPaginated(pageNo, pageSize, sortField, sortDir);
//		List<Teacher> listEmployees = page.getContent();
//		
//		model.addAttribute("currentPage", pageNo);
//		model.addAttribute("totalPages", page.getTotalPages());
//		model.addAttribute("totalItems", page.getTotalElements());
//		
//		model.addAttribute("sortField", sortField);
//		model.addAttribute("sortDir", sortDir);
//		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
//		
//		model.addAttribute("listEmployees", listEmployees);
//		return "index";
//	}
}
