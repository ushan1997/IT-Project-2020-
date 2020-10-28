package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.model.Exam;

@Service
public interface ExamService {

	List<Exam> getAllExam();
	void saveExams(Exam exam);
	Exam getExamById(int exam_id);
	void deleteExamById(int exam_id);
	List <Exam> findByKeyword(String keyword);
	int convertNametoId( String name);
	List <String> AllTeachersNames();
	
}
