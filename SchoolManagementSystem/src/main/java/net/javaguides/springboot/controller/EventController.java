package net.javaguides.springboot.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.javaguides.springboot.model.Pricewinner;
import net.javaguides.springboot.model.SportEvent;
import net.javaguides.springboot.service.EventService;
import net.javaguides.springboot.service.PriceWinnersReportService;
import net.javaguides.springboot.service.SportEventReportService;
import net.sf.jasperreports.data.http.RequestMethod;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;

@Controller
public class EventController {

	
	//Display Sport Events
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private PriceWinnersReportService pwrs;
	
	@Autowired
	private SportEventReportService evtRepo;
	
	//Dashboard
	
	@GetMapping("/Eventdashboard")
	public String viewDashboardPage(Model model) {
		return "dashboard_sportevent";
	}

	
	//display list of Sport Events
	@GetMapping("/sportevent")
	public String viewEventPage(Model model, @Param("keyword") String keyword) {
		model.addAttribute("listEvents",eventService.getAllSportEvents(keyword));
		model.addAttribute("keyword", keyword);
		return "index";
	}
	
	@GetMapping("/showNewEventForm")
	public String showNewEventForm(Model model) {
		SportEvent sportevent = new SportEvent();
		model.addAttribute("sportevent", sportevent);
		return "new_sportevent";		
		
	}
	
	@PostMapping("/saveSportEvent")
	public String saveSportEvent(@ModelAttribute("sportevent") SportEvent sportevent) {
		
		eventService.saveSportEvent(sportevent);
		return "redirect:/sportevent";
		
	}
	
	@GetMapping ("/showEventFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value = "id") long id, Model model) {
		
		//get event from the service
		System.out.println(id);
		SportEvent sportevent = eventService.getSportEventById(id);
		
		//set event as a model attriute to pre-populate the form
		
		model.addAttribute("sportevent", sportevent);
		return "update_sportevent";
		
	}
	
	@GetMapping("/deleteSportEvent/{id}")
	public String deleteSportEvent(@PathVariable (value = "id") long id) {
		
		this.eventService.deleteSportEventById(id);
		return "redirect:/sportevent";
		
		
	}
	
	@GetMapping(value ="/genSportEventRepo")
	public String generateSportEventReport(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
		  JasperPrint jasperPrint = null;

		  response.setContentType("application/x-download");
		  response.setHeader("Content-Disposition", String.format("attachment; filename=\"SportEventInfoReport.pdf\""));

		  OutputStream out = response.getOutputStream();
		  jasperPrint = evtRepo.exportReport();
		  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
		  
		  return "redirect:/sportevent";
		 }
	
	
	
	
	
	//Price Winner List
	
	@GetMapping("/showPricewinnersForm")
	public String showPricewinnersForm(Model model) {
		model.addAttribute("listPricewinners",eventService.getAllPricewinners());
		return "price_winner";
		
	}
	
	
	@GetMapping("/showNewPricewinnerForm")
	public String showNewPricewinnerForm(Model model) {
		Pricewinner pricewinner = new Pricewinner();
		model.addAttribute("pricewinner", pricewinner);
		return  "new_pricewinner";
		
	}
	@PostMapping("/savePricewinner")
	public String savePricewinner(@ModelAttribute("pricewinner")Pricewinner pricewinner) {
		eventService.savePricewinner(pricewinner);
		return "redirect:/showPricewinnersForm";
	}
	
	@GetMapping("/deletePricewinner/{id}")
	public String deletePricewinner(@PathVariable (value = "id") long id) {
		
		//calling delete price winner method
		this.eventService.deletePricewinnerById(id);
		return "redirect:/showPricewinnersForm";
		
	}
	
	// /searchPricewinner
	
	
	@GetMapping("/searchPricewinner")
	public String searchPricewinner(Model model, @Param("pricekey") Integer pricekey) {
		model.addAttribute("listEvents",eventService.getAllPricewinnersByKey(pricekey));
		model.addAttribute("pricekey", pricekey);
		return "redirect:/showPricewinnersForm";
	}
	
	 @GetMapping(value = "/generatePriceWinnerList")//Report Generation
	 public String export(ModelAndView model, HttpServletResponse response) throws IOException, JRException, SQLException {
	  JasperPrint jasperPrint = null;

	  response.setContentType("application/x-download");
	  response.setHeader("Content-Disposition", String.format("attachment; filename=\"EventInfoReport.pdf\""));

	  OutputStream out = response.getOutputStream();
	  jasperPrint = pwrs.exportReport();
	  JasperExportManager.exportReportToPdfStream(jasperPrint, out);
	  
	  return "redirect:/showPricewinnersForm";
	 }
	
}
