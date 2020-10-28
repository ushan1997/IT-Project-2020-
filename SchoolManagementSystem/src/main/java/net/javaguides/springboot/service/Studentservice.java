package net.javaguides.springboot.service;
import java.util.List;
import org.springframework.stereotype.Service;
import net.javaguides.springboot.model.Student;
import net.sf.jasperreports.engine.JasperPrint;

@Service
public interface Studentservice {
	List<Student> getAllStudents();
	void saveStudent(Student student);
	Student getStudentbyId(int student_id);
	void deleteStudentbyID(int student_id);
	 
	public List<Student> findByKeyword(String keyword);
//	void ProfilebyID(int student_id);

	List<Student> findAll();
	
	

}
