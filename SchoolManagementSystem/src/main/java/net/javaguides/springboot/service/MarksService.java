package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Marks;

@Service
public interface MarksService {

	List<Marks> getAllExamMarks();
	void saveExamMarks(Marks marks);
	Marks getMarksById(int exam_marks_id);
	void deleteMarksById(int exam_marks_id);
	
	List<Marks> findByKeyword(String keyword);
	
	List <String> AllExamsId();
	
	List <String> AllStudentId();
	
	
	int getExamId(String keyword);//get unknow exam id from the name
	
}
