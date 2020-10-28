package net.javaguides.springboot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.javaguides.springboot.model.Exam;
import net.javaguides.springboot.repository.ExamRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ExamReportService {
	
	@Autowired
	public ExamRepository er;

	public JasperPrint exportReport(/**get format of report PDF/word*/) throws FileNotFoundException, JRException {
		
		String filePath ="C:\\Users\\user\\Downloads";
		
		List<Exam> exams =er.findAll();//get list of all exams
		
		//load file and compile it
		
		File file =ResourceUtils.getFile("classpath:exams.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasourse = new JRBeanCollectionDataSource(exams);
		
		Map<String, Object> map = new HashMap<>();
		map.put("Created By", "Exams");
		
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, map,datasourse);
		
//		if(reportFormat.equalsIgnoreCase("html")) {
//			JasperExportManager.exportReportToHtmlFile(jasperprint,filePath+"\\Exams.html");
//		}
//		if(reportFormat.equalsIgnoreCase("pdf")) {
//			JasperExportManager.exportReportToPdfFile(jasperprint,filePath+"\\Exams.pdf");
//		}
		
//		return "redirect:/listExam";
		
		return jasperprint;
	}
	
}
