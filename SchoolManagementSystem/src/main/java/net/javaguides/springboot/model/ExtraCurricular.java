package net.javaguides.springboot.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "extracurricular")
public class ExtraCurricular {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="extracurricular_id")
	private long extracurricular_id;
	
	@Column(name="activity_name")
	private String activity_name;
	
	@Column(name="student_id")
	private long student_id;
	
	@Column(name="student_role")
	private String student_role;

	@Column(name="points")
	private float points;

	
	public long getExtracurricular_id() {
		return extracurricular_id;
	}

	public void setExtracurricular_id(long extracurricular_id) {
		this.extracurricular_id = extracurricular_id;
	}

	public String getActivity_name() {
		return activity_name;
	}

	public void setActivity_name(String activity_name) {
		this.activity_name = activity_name;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_role() {
		return student_role;
	}

	public void setStudent_role(String student_role) {
		this.student_role = student_role;
	}

	public float getPoints() {
		return points;
	}

	public void setPoints(float points) {
		this.points = points;
	}

	
	
}
