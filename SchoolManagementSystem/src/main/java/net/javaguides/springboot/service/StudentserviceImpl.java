package net.javaguides.springboot.service;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.repository.Studentrepository;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public class StudentserviceImpl implements Studentservice {

	@Autowired
	private Studentrepository studentrepository;
	
	
	@Override
	public List<Student> getAllStudents() {
		return studentrepository.findAll(); 
	}


	@Override
	public void saveStudent(Student student) {
		this.studentrepository.save(student);
		
	}


	@Override
	public Student getStudentbyId(int student_id) {
		Optional<Student> optional = studentrepository.findById(student_id);
		Student student = null;
		if(optional.isPresent()) {
			
			student  = optional.get();
			
		}else {
			
			
			throw new RuntimeException("Student not found in Id : "+student_id);
			
		}
		return student;
	}


	@Override
	public void deleteStudentbyID(int student_id) {
		this.studentrepository.deleteById(student_id);
		
	}


	@Override
	public List<Student> findByKeyword(String keyword) {
		
		return studentrepository.findByKeyword(keyword);
	}


	

	@Override
	public List<Student> findAll() {
		return studentrepository.findAll();
	}





//	@Override
//	public void ProfilebyID(int student_id) {
//		return;
//		
//	}
	
       
	
}
