package com.smart.contact.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "mst_user")
public class MstUserBo {

	@Id
	@Column(name = "user_id")
	private int user_id;
	
	@Column(name = "email_id")
	private String email_id;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "mobile_number")
	private String mobile_number;
	
	@Column(name = "curent_date")
	private Date curent_date;
	
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

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public Date getCurent_date() {
		return curent_date;
	}

	public void setCurent_date(Date curent_date) {
		this.curent_date = curent_date;
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

	@Override
	public String toString() {
		return "MstUserBo{" +
				"user_id=" + user_id +
				", email_id='" + email_id + '\'' +
				", password='" + password + '\'' +
				", mobile_number='" + mobile_number + '\'' +
				", curent_date=" + curent_date +
				", status=" + status +
				", contact=" + contact +
				'}';
	}
}
