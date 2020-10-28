package net.javaguides.springboot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.javaguides.springboot.model.ExtraCurricular;
import net.javaguides.springboot.repository.ExtraCurricularRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class ExtraCurricularReportService {

	public ExtraCurricularRepository er;
	

	public JasperPrint exportReport() throws FileNotFoundException, JRException{
		
		String filePath ="C:\\Users\\User\\Downloads";
		
		List<ExtraCurricular> extra=er.findAll();
		
		File file =ResourceUtils.getFile("classpath:extracurricular.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasourse = new JRBeanCollectionDataSource(extra);
		
		Map<String, Object> map = new HashMap<>();
		map.put("Created By", "extra");
		
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, map,datasourse);
        
		return jasperprint;
		
		
	}
	
	
}
