package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="alumno")
public class Alumno {
	
	@Id
	
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;
	private String phone;
	private int age;
	private String email;
	
	
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date datetime;
	
	
	@PrePersist
	public void prePersist() {
		this.datetime=new Date();
	}

	public Alumno() {
		
	}

	public Alumno(Long id, String name, String lastname, String phone, int age, String email) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.phone = phone;
		this.age = age;
		this.email = email;
	}
	
	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
