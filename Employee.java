package com.example.samplePro2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="EmployeeDetails")
public class Employee {
	
	@Id
	//@GeneratedValue(strategy =GenerationType.IDENTITY)
	
	@Column(name="Id")
	private int Id;
	
	@Column(name="First_Name",nullable=false)
	private String firstname;
	
	@Column(name="Last_Name",nullable=false)
	private String lastname;
	
	@Column(name="Email",nullable=false)
	private String email;
	
	@Column(name="Age",nullable=false)
	private int age;
	
	@Column(name="Salary",nullable=false)
	private int salary;
	
	@Column(name="Mobile",nullable=false)
	private String mobile;
	
	@Column(name="Mobile2",nullable=true)
	private String mobile2;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", age=" + age + ", salary=" + salary + ", mobile=" + mobile + ", mobile2=" + mobile2 + "]";
	}

	public Employee(int id, String firstname, String lastname, String email, int age, int salary, String mobile,
			String mobile2) {
		super();
		Id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.age = age;
		this.salary = salary;
		this.mobile = mobile;
		this.mobile2 = mobile2;
	}

	public Employee() {
		super();
	}
	

}
