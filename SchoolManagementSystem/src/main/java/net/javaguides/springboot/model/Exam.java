package net.javaguides.springboot.model;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name ="exams")
public class Exam {

	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="exam_id")
	public int exam_id;

	@Column(name="exam_name")
	private String exam_name;
	
	@Column(name="year")
	private String year;
	
	@Column(name="term")
	private String term;
	
	@Column(name="exam_class")
	private int exam_class;
	
	@Column(name="subject")
	private String subject;
	
    
	@Column(name="teacher_name")
	private String teacher_name;
	
	@Column(name="exam_venue")
	private String exam_venue;
	
	@Column(name="deadline")
	private String deadline;

	
	
	public int getExam_id() {
		return exam_id;
	}

	public void setExam_id(int exam_id) {
		this.exam_id = exam_id;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public int getExam_class() {
		return exam_class;
	}

	public void setExam_class(int exam_class) {
		this.exam_class = exam_class;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}



	public String getTeacher_name() {
		return teacher_name;
	}

	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}

	public String getExam_venue() {
		return exam_venue;
	}

	public void setExam_venue(String exam_venue) {
		this.exam_venue = exam_venue;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	
	
	
	
	
}
