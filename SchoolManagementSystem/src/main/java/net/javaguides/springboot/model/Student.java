package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="student")
public class Student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "student_id")
	private int student_id ;
	
	@Column(name = "name")
	private String name ;
	
	@Column(name = "class_of_admission")
	private String class_of_admission ;
	
	@Column(name = "date_of_admission")
	private String date_of_admission;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "contact_number")
	private String contact_number;
	
	@Column(name = "date_of_birth")
	private String date_of_birth;

	@Column(name = "name_with_initials")
	private String name_with_initials;
	
	@Column(name = "religion")
	private String religion;
	
	@Column(name = "race")
	private String race;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "father_name")
	private String father_name;
	
	@Column(name = "father_contact_number")
	private String father_contact_number;
	
	@Column(name = "father_email")
	private String father_email;
	
	@Column(name = "father_job")
	private String father_job;
	
	@Column(name = "father_office_address")
	private String father_office_address;
	
	@Column(name = "mother_name")
	private String mother_name;
	
	@Column(name = "mother_contact_number")
	private String mother_contact_number;
	
	@Column(name = "mother_email")
	private String mother_email;
	
	@Column(name = "mother_job")
	private String mother_job;
	
	@Column(name = "mother_office_address")
	private String mother_office_address;
	
	@Column(name = "gurdian_name")
	private String gurdian_name;
	
	@Column(name = "gurdian_contact_number")
	private String gurdian_contact_number;
	
	@Column(name = "gurdian_email")
	private String gurdian_email;
	
	@Column(name = "gurdian_job")
	private String gurdian_job;
	
	public String getName_with_initials() {
		return name_with_initials;
	}

	public void setName_with_initials(String name_with_initials) {
		this.name_with_initials = name_with_initials;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getFather_contact_number() {
		return father_contact_number;
	}

	public void setFather_contact_number(String father_contact_number) {
		this.father_contact_number = father_contact_number;
	}

	public String getFather_email() {
		return father_email;
	}

	public void setFather_email(String father_email) {
		this.father_email = father_email;
	}

	public String getFather_job() {
		return father_job;
	}

	public void setFather_job(String father_job) {
		this.father_job = father_job;
	}

	public String getFather_office_address() {
		return father_office_address;
	}

	public void setFather_office_address(String father_office_address) {
		this.father_office_address = father_office_address;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public String getMother_contact_number() {
		return mother_contact_number;
	}

	public void setMother_contact_number(String mother_contact_number) {
		this.mother_contact_number = mother_contact_number;
	}

	public String getMother_email() {
		return mother_email;
	}

	public void setMother_email(String mother_email) {
		this.mother_email = mother_email;
	}

	public String getMother_job() {
		return mother_job;
	}

	public void setMother_job(String mother_job) {
		this.mother_job = mother_job;
	}

	public String getMother_office_address() {
		return mother_office_address;
	}

	public void setMother_office_address(String mother_office_address) {
		this.mother_office_address = mother_office_address;
	}

	public String getGurdian_name() {
		return gurdian_name;
	}

	public void setGurdian_name(String gurdian_name) {
		this.gurdian_name = gurdian_name;
	}

	public String getGurdian_contact_number() {
		return gurdian_contact_number;
	}

	public void setGurdian_contact_number(String gurdian_contact_number) {
		this.gurdian_contact_number = gurdian_contact_number;
	}

	public String getGurdian_email() {
		return gurdian_email;
	}

	public void setGurdian_email(String gurdian_email) {
		this.gurdian_email = gurdian_email;
	}

	public String getGurdian_job() {
		return gurdian_job;
	}

	public void setGurdian_job(String gurdian_job) {
		this.gurdian_job = gurdian_job;
	}

	public String getGurdian_office_address() {
		return gurdian_office_address;
	}

	public void setGurdian_office_address(String gurdian_office_address) {
		this.gurdian_office_address = gurdian_office_address;
	}

	@Column(name = "gurdian_office_address")
	private String gurdian_office_address;
	


	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_of_admission() {
		return class_of_admission;
	}

	public void setClass_of_admission(String class_of_admission) {
		this.class_of_admission = class_of_admission;
	}

	public String getDate_of_admission() {
		return date_of_admission;
	}

	public void setDate_of_admission(String date_of_admission) {
		this.date_of_admission = date_of_admission;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContact_number() {
		return contact_number;
	}

	public void setContact_number(String contact_number) {
		this.contact_number = contact_number;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	

	


	
}
