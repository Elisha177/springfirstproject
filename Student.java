package com.firstproject.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int studentID;
	
	@Column(name = "firstname")
	String firstname;
	
	@Column(name = "lastname")
	String lastname;
	
	@Column(name = "age")
	int age;
	
	@Column(name = "gender")
	char gender;
	
	@Column(name = "standard")
	int standard;
	
	@Column(name = "section")
	char section;
	
	@Column(name = "address")
	String address;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int studentID, String firstname, String lastname, int age, char gender, int standard, char section,
			String address) {
		super();
		this.studentID = studentID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.standard = standard;
		this.section = section;
		this.address = address;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getStandard() {
		return standard;
	}

	public void setStandard(int standard) {
		this.standard = standard;
	}

	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
