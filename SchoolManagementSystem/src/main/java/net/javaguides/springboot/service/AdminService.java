package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Admin;

@Service
public interface AdminService {

	List<Admin> getAllAdmins( );
	void saveAdmin(Admin admin);
	Admin getAdminById(int admin_id);
	void deleteAdminById(int admin_id);
	List <Admin> findAdminById(int admin_id);
}
