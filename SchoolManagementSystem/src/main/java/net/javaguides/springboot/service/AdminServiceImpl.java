package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;


import net.javaguides.springboot.model.Admin;
import net.javaguides.springboot.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository arp;
	
	@Override
	public List<Admin> getAllAdmins() {
		
		return arp.findAll();
	}

	@Override
	public void saveAdmin(Admin admin) {
		
		this.arp.save(admin);
	}

	@Override
	public Admin getAdminById(int admin_id) {
		
		Optional<Admin> optional = arp.findById(admin_id);
		
		Admin admin =null;
		if(optional.isPresent()) {
			admin = optional.get();
		}else {
			throw new RuntimeException("Admin not found"+admin_id);
		}
		
		return admin;
	}

	@Override
	public void deleteAdminById(int admin_id) {
		
		this.arp.deleteById(admin_id);
		
	}

	@Override
	public List<Admin> findAdminById(int admin_id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
