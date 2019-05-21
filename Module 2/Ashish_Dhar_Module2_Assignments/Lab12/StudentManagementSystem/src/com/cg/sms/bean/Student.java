package com.cg.sms.bean;

import java.time.LocalDate;

public class Student {
	//student class entities
	private int studentRollNo;
	private String studentName;
	private int StudentAge;
	private String studentCity;
	private LocalDate joinDate;
	private StringBuffer studentState;
	
	//generating blank constructor
	public Student() {
	
	}
	
	//generating parameterized constructor
	public Student(int studentRollNo, String studentName, int studentAge,
			String studentCity, LocalDate joinDate, StringBuffer studentState) {
		super();
		this.studentRollNo = studentRollNo;
		this.studentName = studentName;
		StudentAge = studentAge;
		this.studentCity = studentCity;
		this.joinDate = joinDate;
		this.studentState = studentState;
	}
	
	//generating getters and setters
	public int getStudentRollNo() {
		return studentRollNo;
	}


	public void setStudentRollNo(int studentRollNo) {
		this.studentRollNo = studentRollNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return StudentAge;
	}

	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public StringBuffer getStudentState() {
		return studentState;
	}

	public void setStudentState(StringBuffer studentState) {
		this.studentState = studentState;
	}
	
	
	
	//generating tostring method
	@Override
	public String toString() {
		return "Student [studentRollNo=" + studentRollNo + ", studentName="
				+ studentName + ", StudentAge=" + StudentAge + ", studentCity="
				+ studentCity + ", joinDate=" + joinDate + ", studentState="
				+ studentState + "]";
	}

}
