package net.javaguides.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import net.javaguides.springboot.model.Marks;
import net.javaguides.springboot.repository.MarksRepository;

@Service
public class MarksServiceImpl implements MarksService{

	@Autowired
	private MarksRepository MarksRepository;

	@Override//get all marks of students
	public List<Marks> getAllExamMarks() {
		
		return MarksRepository.findAll();
	}

	@Override//save marks of the student
	public void saveExamMarks(Marks marks) {
		
		this.MarksRepository.save(marks);
	}

	@Override//update marks of students
	public Marks getMarksById(int exam_marks_id) {
		Optional <Marks>optional = MarksRepository.findById(exam_marks_id);
		Marks marks=null;
		if(optional.isPresent()) {
			marks = optional.get();
		}
		else {
			throw new RuntimeException("Marks not found"+exam_marks_id);
		}
		return marks;
	}

	@Override//delete marks of students
	public void deleteMarksById(int exam_marks_id) {
		// TODO Auto-generated method stub
		this.MarksRepository.deleteById(exam_marks_id);
	}

	@Override
	public List<Marks> findByKeyword(String keyword) {
		return this.MarksRepository.findByKeyword(keyword);
	
	}

	@Override
	public List<String> AllExamsId() {
		
		return MarksRepository.AllExamsId();//custom made function
	}
	
	@Override
	public List<String> AllStudentId() {
		// TODO Auto-generated method stub
		return MarksRepository.AllStudentId();//custom made function
	}

	@Override
	public int getExamId(String keyword) {
		// TODO Auto-generated method stub
		return MarksRepository.convertExamNameToId(keyword);
	}

	
	
	
	
}
