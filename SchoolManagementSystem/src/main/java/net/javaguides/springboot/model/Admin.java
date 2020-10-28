package net.javaguides.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {

	@Id
	@Column(name="admin_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int admin_id;
	
	@Column(name="admin_username")
	private String admin_username;
	
	@Column(name="admin_type")
	private String admin_type;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;

//	private String repassword;
	
	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_type() {
		return admin_type;
	}

	public void setAdmin_type(String admin_type) {
		this.admin_type = admin_type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public String getRepassword() {
//		return repassword;
//	}
//
//	public void setRepassword(String repassword) {
//		this.repassword = repassword;
//	}
	
	
}
