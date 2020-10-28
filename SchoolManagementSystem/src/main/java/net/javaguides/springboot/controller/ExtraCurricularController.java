package net.javaguides.springboot.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.io.OutputStream;
import javax.servlet.ServletOutputStream;
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
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.ExtraCurricular;
import net.javaguides.springboot.service.ExtraCurricularReportService;
import net.javaguides.springboot.service.ExtraCurricularService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class ExtraCurricularController {
	
	
	@Autowired
	private ExtraCurricularService extraCurricularService;
	
	@Autowired
	private ExtraCurricularReportService ers;
	
	//display list 
	
	@GetMapping("/listofExtra")
	public String ViewHomePage(Model model,String keyword) {
		model.addAttribute("ListOfStdents",extraCurricularService.getAllExtraCurricular() );
		
		if(keyword != null) {
			
		model.addAttribute("ListOfStdents",extraCurricularService.findByKeyword(keyword));
			
		}
		return "ViewExtraCurricular";
		
	}
	
	
	@GetMapping ("/newExtraDetailsForm")
	public String viewDetailsForm(Model model) {
		
		ExtraCurricular extraCurricular =new  ExtraCurricular();
		model.addAttribute("extraCurricular",extraCurricular);	
		return "newExtra";
		
	}

	@PostMapping("/saveExtraDetails")
	public String saveDetails(@ModelAttribute("extraCurricular")ExtraCurricular  extraCurricular ) {
		
		extraCurricularService.saveDetails(extraCurricular);
		
		return "redirect:/listofExtra";
	}
	
	
	//Teacher update
	@GetMapping("/showFormForUpdate/{extracurricular_id}")
	public String showFormForUpdate(@PathVariable (value = "extracurricular_id")long extracurricular_id,Model model) {
		
		
		ExtraCurricular extraCurricular = extraCurricularService. getStudentById(extracurricular_id);
		
		model.addAttribute("extraCurricular",extraCurricular);
		return "update_extracurricular";
	}
	
	
	//Teacher delete
	@GetMapping("/deleteExtra/{extracurricular_id}")
	public String deleteStudent(@PathVariable (value = "extracurricular_id")long extracurricular_id,Model model) {
		
		
		this.extraCurricularService.deleteStudentById(extracurricular_id);
		
		return "redirect:/listofExtra";
	}
	
	
	
	
	//report
	
	 @RequestMapping(value = "/reportGenerationOfExtra", method = RequestMethod.GET)
	 public String export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"ExtraCurricularReport.pdf\""));

	  OutputStream out = response.getOutputStream();
	                                          
	  jasperPrint = ers.exportReport();
	  
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	  
	  return "redirect:/newExtraDetailsForm";
	 }
	
	
	
}
