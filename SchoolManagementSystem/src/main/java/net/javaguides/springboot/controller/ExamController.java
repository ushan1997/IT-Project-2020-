package net.javaguides.springboot.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Exam;
import net.javaguides.springboot.service.ExamReportService;
import net.javaguides.springboot.service.ExamService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

//@RestController
//@RequestMapping("/demo")
@Controller
public class ExamController {

	
	@Autowired
	private ExamService es;
	
	@Autowired
	private ExamReportService ers;
	
	@GetMapping(value="/listExam")
	public String viewHomePage(Model model,String keyword) {
		
		if(keyword!=null) {
			
			model.addAttribute("listExam",es.findByKeyword(keyword));
		}
		else {
		model.addAttribute("listExam",es.getAllExam());
		}
		
		return "viewExam";
	}
	
	@GetMapping("/showNewExamForm")//calling shownew form
	public String showNewExamForm(Model model) {
		Exam exam= new Exam();
		model.addAttribute("exam",exam);
		return "newExam";//go to new exam html;
		
	}
	
	@PostMapping("/saveExams")//Post method
	public String saveExam(@ModelAttribute("exam") Exam exam) {
		this.es.saveExams(exam);
		return "redirect:/listExam";
	}
	
	
	@GetMapping("/updateExam/{exam_id}")
	public String showFormUpdate(@PathVariable ( value ="exam_id") int exam_id,Model model) {
		//get exam from service
		
		Exam exam = es.getExamById(exam_id);
		
		//set exam as a model attribute to pre populate the form
		model.addAttribute("exam",exam);
		return "updateExam";
	
	}
	
	
	@GetMapping("/deleteExam/{exam_id}")
	public String deleteExam(@PathVariable ( value ="exam_id") int exam_id) {
		
		//call delete exam method
		this.es.deleteExamById(exam_id);
		
		return "redirect:/listExam";
		
	}

	@RequestMapping(value="/teacherNameAutoComplete")
	@ResponseBody
	public List<String> teacherNameAutoComplete(@RequestParam(value="term",required=false,defaultValue="111") String term){
//		List <String> suggestions = new ArrayList<String>();
//		suggestions.add("ushan");
//		suggestions.add("Anuka");
//		suggestions.add("Gunaratne");
		List<String> suggestions=es.AllTeachersNames();
		System.out.println(suggestions);
		return suggestions;
	}
	
	@RequestMapping(value="/convertNameToId")
	@ResponseBody
	public int convertNameToId(String name) {
		int id=es.convertNametoId(name);
		System.out.println("id is ="+id);
		return id;
	}
	
//	@GetMapping(value="/report/{format}")
//	public String genarateReport(@PathVariable (value="format") String format) throws FileNotFoundException, JRException {
//		
//		return ers.exportReport(format);
//	}
	
	 @RequestMapping(value = "/exportExamPdf", method = RequestMethod.GET)//Report Generation
	 public String export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ExamsInfoReport.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = ers.exportReport();
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	  
	  return "redirect:/listExam";
	 }
	
}
