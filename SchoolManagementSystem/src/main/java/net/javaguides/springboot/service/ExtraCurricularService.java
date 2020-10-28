package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.ExtraCurricular;



@Service
public interface ExtraCurricularService {

	@Autowired 
	
	//get all extraCurricular
	List<ExtraCurricular> getAllExtraCurricular();
	
	//save activity_name
	void saveDetails(ExtraCurricular extraCurricular);

	//update extraCurricular
	ExtraCurricular getStudentById(long extracurricular_id);

	//delete extraCurricular
	void deleteStudentById(long extracurricular_id);
	
	
	//get students 
     List <ExtraCurricular> findByKeyword (String keyword);	
     
   
	
}
