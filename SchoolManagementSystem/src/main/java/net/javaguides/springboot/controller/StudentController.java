package net.javaguides.springboot.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.jar.JarException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.service.StudentReportService;
import net.javaguides.springboot.service.Studentservice;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;


@Controller
public class StudentController {


		@Autowired
		private Studentservice studentService;
		//display list of student
		@Autowired
		private StudentReportService srs;
		
		@GetMapping(value="/ViewStudent")
		public String viewHomePage(Model model, String keyword) {
	
			if(keyword !=null) {
				model.addAttribute("listStudents", studentService.findByKeyword(keyword));
			}else {
				model.addAttribute("listStudents", studentService.getAllStudents());
			}
				
			return "ViewStudent";
		}
		
	
		
		@GetMapping("/showNewStudentForm")
		public String showNewStudentForm(Model model) {
			
			Student student = new Student();
			model.addAttribute("student" , student);
			
			return "new_student";
		}
		
		@PostMapping("/saveStudent")
		public String saveStudent(@ModelAttribute("student") Student student) {
			studentService.saveStudent(student);
			
		return "redirect:/ViewStudent";	
		}
		
		
		@GetMapping("/showStudentFormForUpdate/{student_id}")
		public String showFormForUpdate(@PathVariable ( value = "student_id") int student_id, Model model) {
			
			Student student= studentService.getStudentbyId(student_id);
			
			model.addAttribute("student" , student);
			return "update_student";
		}
		
		
		@GetMapping("/deleteStudent/{student_id}")
		public String deleteStudent(@PathVariable (value = "student_id") int student_id) {
			this.studentService.deleteStudentbyID(student_id);
			return "redirect:/ViewStudent";
			
		}
		
		@GetMapping("/ViewStudentProfile/{student_id}")
		public String Profile(@PathVariable (value = "student_id") int student_id,Model model) {
			
			Student student= studentService.getStudentbyId(student_id);
			model.addAttribute("student",student);
			return "ViewStudentProfile";
		}
		
		 @RequestMapping(value = "/exportStudentPdf", method = RequestMethod.GET)
		 public String export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
		  JasperPrint jasperPrint = null;

		  response.setContentType("application/x-download");
		  response.setHeader("Content-Disposition", String.format("attachment; filename=\"Studentdetails.pdf\""));

		  OutputStream out = response.getOutputStream();
		  jasperPrint =srs.exportReport();
		  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		  
		  return "redirect:/ViewStudent";
		 }
		
	

}
