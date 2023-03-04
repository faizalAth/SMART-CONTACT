package com.smart.contact.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.AssertTrue;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;



@Entity
@Table(name = "mst_user")
public class MstUserBo {

	@Id
	@Column(name = "user_id")
	private int user_id;
	
	@NotBlank(message = "Please Enter Your Name.")
	@Column(name = "your_name")
	private String your_name;

	@NotBlank(message = "Please Enter Your Email.")
	@Column(name = "email_id",unique = true)
	private String email_id;
	
	@Column(name = "role")
	private String role;

	@AssertTrue(message = "Must Have to Accept Terms & Conditions !")
	@Column(name = "terms_conditions")
	private String terms_conditions;

	@NotBlank(message = "Please Enter Your Password.")
	@Column(name = "password")
	private String password;
	
	@Column(name = "crt_date")
	private Date crt_date;
	
	@Column(name = "status")
	private int status;

	@OneToMany(cascade = CascadeType.ALL,fetch =FetchType.LAZY,mappedBy ="user_id") 
	List<MstContactBo> contact=new ArrayList<>();

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public List<MstContactBo> getContact() {
		return contact;
	}

	public void setContact(List<MstContactBo> contact) {
		this.contact = contact;
	}

	public String getYour_name() {
		return your_name;
	}

	public void setYour_name(String your_name) {
		this.your_name = your_name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getTerms_conditions() {
		return terms_conditions;
	}

	public void setTerms_conditions(String terms_conditions) {
		this.terms_conditions = terms_conditions;
	}

	public Date getCrt_date() {
		return crt_date;
	}

	public void setCrt_date(Date crt_date) {
		this.crt_date = crt_date;
	}

	@Override
	public String toString() {
		return "MstUserBo [user_id=" + user_id + ", your_name=" + your_name + ", email_id=" + email_id + ", role="
				+ role + ", terms_conditions=" + terms_conditions + ", password=" + password + ", crt_date=" + crt_date
				+ ", status=" + status + ", contact=" + contact + "]";
	}

	

}
