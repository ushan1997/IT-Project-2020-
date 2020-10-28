package net.javaguides.springboot.service;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Exam;
import net.javaguides.springboot.repository.ExamRepository;

@Service
public class ExamServiceImpl implements ExamService{

	@Autowired
	private ExamRepository er;
	
	@Override
	public List<Exam> getAllExam() {
		
		return er.findAll();//get all the instance from exam entity
	
	}

	@Override
	public void saveExams(Exam exam) {
		
//		Optional<Exam>  optional = er.getAllTeacherName();
//
//		if(optional.isPresent()){
		this.er.save(exam);//save()-> insert data to the new entity like "insert new values into table "
		
	}

	@Override
	public Exam getExamById(int exam_id) {
		Optional<Exam> optional =er.findById(exam_id);
		/*Optional object type not contain null values,When it has value it returns "true",to function Optional.isPresent()*/
		/*findByID()  Retrieves an entity by its id.*/

		Exam exam =null;//make empty before new values going to add
		
		if(optional.isPresent()) {//if optional.isPresent() null throw exception
			exam = optional.get();//update new values to entity
		}else {
			throw new RuntimeException("Exam not found for id :: "+exam_id);//Throw exception 
		}
		return exam;//return entity
	}

	@Override
	public void deleteExamById(int exam_id) {
		this.er.deleteById(exam_id);//delete values of entity given id
		
	}

	//Get exams by keyword(Search)
	@Override
	public List<Exam> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return er.findByKeyword(keyword);//custom made function
	}

	@Override
	public int convertNametoId(String name) {
		// TODO Auto-generated method stub
		return er.convertNametoId(name);
	}

	public List <String> AllTeachersNames() {
		// TODO Auto-generated method stub
		return er.AllTeachersNames();//custom made function
	}
	
}
