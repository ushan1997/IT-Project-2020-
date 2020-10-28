package net.javaguides.springboot.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.javaguides.springboot.model.Pricewinner;
import net.javaguides.springboot.repository.PricewinnerRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class PriceWinnersReportService {

	@Autowired
	public PricewinnerRepository pwr;

	public JasperPrint exportReport(/**get format of report PDF/word*/) throws FileNotFoundException, JRException {
		
		String filePath ="C:\\Users\\User\\Download";
		
		List<Pricewinner> pricewinner =pwr.findAll();//get list of all exams
		
		//load file and compile it
		
		File file =ResourceUtils.getFile("classpath:PriceWinnerRepo.jrxml");
		
		JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
		
		JRBeanCollectionDataSource datasourse = new JRBeanCollectionDataSource(pricewinner);
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("Created By", "PriceWinner");
		
		JasperPrint jasperprint = JasperFillManager.fillReport(jasperReport, map,datasourse);

		
		return jasperprint;
	}
	
}
