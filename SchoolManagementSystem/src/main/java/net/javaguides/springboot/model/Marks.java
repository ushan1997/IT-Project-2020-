package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="exam_marks")
public class Marks {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exam_marks_id")
	public int exam_marks_id;
	
	@Column(name="exam_id")
	public int exam_id;
	
	@Column(name="student_id")
	public int student_id;
	
	@Column(name="marks")
	private int marks;
	

	
	public int getExam_marks_id() {
		return exam_marks_id;
	}
	public void setExam_marks_id(int exam_marks_id) {
		this.exam_marks_id = exam_marks_id;
	}
	public int getExam_id() {
		return exam_id;
	}
	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}

	

	
}
