package net.javaguides.springboot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.javaguides.springboot.model.SportEvent;
import net.javaguides.springboot.repository.EventRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;



@Service
public class SportEventReportService {
	
	@Autowired
	private EventRepository evtRepo;

	public JasperPrint exportReport(/**get format of report PDF/word*/) throws FileNotFoundException, JRException {
		
		String filePath ="C:\\Users\\User\\Download";
		
		List<SportEvent> sportevent =evtRepo.findAll();//get list of all exams
		
		//load file and compile it
		
		File file =ResourceUtils.getFile("classpath:sportevent.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasourse = new JRBeanCollectionDataSource(sportevent);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("Created By", "sportevent");
		
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, map, datasourse);
		return jasperprint;
	}
}
