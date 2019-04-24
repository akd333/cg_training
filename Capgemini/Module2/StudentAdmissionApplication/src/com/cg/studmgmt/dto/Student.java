package com.cg.studmgmt.dto;

import java.time.LocalDate;

public class Student {
	private String name;
	private int rollNo;
	private String address;
	private int deptNo;
	private LocalDate admissionDate;

	@Override
	public String toString() {
		return name+" "+ rollNo+" "+address+" "+deptNo+ " "+ admissionDate;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}
	public LocalDate getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}
}
