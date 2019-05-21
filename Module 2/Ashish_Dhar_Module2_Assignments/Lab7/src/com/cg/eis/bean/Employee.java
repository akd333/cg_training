/************************************************************************************
 * File                 : Employee.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to show an employee insurance scheme
 * Version              : 1.0
 * Last Modified Date   : 22-Apr-2019
 ************************************************************************************/

package com.cg.eis.bean;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private String designation;
	private String insuranceScheme;
	static int generator = 0;
	
	//Blank constructor called
	public Employee() {
		id = ++generator;
	}
	
	//Parameterized constructor called 
	public Employee(String name, double salary, String designation,String insuranceScheme) {
		id = ++generator;
		this.name = name;
		this.salary = salary;
		this.designation = designation;
	}

	//Generating getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double isSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public void setInsuramceScheme(String insuranceScheme) {
		this.insuranceScheme = insuranceScheme;
	}
	
	public String getInsuranceScheme() {
		return insuranceScheme;
	}
	
	//Generating toString method
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary
				+ ", designation=" + designation + ", insuranceScheme="
				+ insuranceScheme + "]";
	}	
		
}
