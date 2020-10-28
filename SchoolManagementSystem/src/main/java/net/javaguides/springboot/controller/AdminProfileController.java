package net.javaguides.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Prevelant.AdminPrevalent;
import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.service.AdminService;

@Controller
public class AdminProfileController {

	@Autowired
	private AdminService adminService;
	
	@GetMapping(value="/registerAdmin")
	public String addNewAdmin(Model model) {
		
		Admin admin= new Admin();
		model.addAttribute("newAdmin",admin);
		return "AdminRegisterForm";
		
	}
	
	@RequestMapping(value="/showAdminLogin")
	public String LoadLogin() {
		return "AdminLogin";
	}
	
	@PostMapping(value="/saveAdmin")
	public String saveAdmin(@ModelAttribute("newAdmin") Admin admin) {
		
		List<Admin> list= adminService.getAllAdmins();
		String username =admin.getAdmin_username();
		
		for(int i=0;i<list.size();i++) {
			
			String puserName=list.get(i).getAdmin_username();
			
			System.out.println( puserName);
			System.out.println(username);
				
				
					if(username.equals(puserName)){
						
					return "redirect:/registerAdmin";
					
					}
					else {
						
						saveAdmin1(admin);
					}
				
		}
		saveAdmin1(admin);
		return "redirect:/showAdminLogin";	
		
					
	}		

	public String saveAdmin1(Admin admin) {
		this.adminService.saveAdmin(admin);
		return "redirect:/showAdminLogin";
	}
	
	
	@GetMapping(value="/cheakAdminLogin")
	public String cheackLogin(String username,String password) {
		
		List<Admin> list= adminService.getAllAdmins();
		System.out.println(username);
		
		for(int i=0;i<list.size();i++) {
			
			
			String puserName=list.get(i).getAdmin_username();
			String ppassword=list.get(i).getPassword();
			System.out.println(puserName);
			System.out.println(ppassword);
			
			if((username.equals(puserName))&&(password.equals(ppassword))) {
				
				AdminPrevalent.currentOnlineAdmin=list.get(i);
				System.out.println(AdminPrevalent.currentOnlineAdmin.getAdmin_username());
				System.out.println(AdminPrevalent.currentOnlineAdmin.getPassword());
				
				
				return "AdminDashboard";
				
			}else if(!(username.equals(puserName))&&(password.equals(ppassword))){
				
				 continue;	
			}
			
		}
		
		return "redirect:/showAdminLogin";
	}
	
}
