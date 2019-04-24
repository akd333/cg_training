package com.cg.studmgmt.dao;

import java.util.ArrayList;

import com.cg.studmgmt.dto.Department;
import com.cg.studmgmt.dto.Student;
import com.cg.studmgmt.exception.AdmissionException;

public interface IStudentDao {

	public int addStudent(Student student) throws AdmissionException;
	public ArrayList<Department> getDepartments() throws AdmissionException ;
	public int updateAddress(String address, int rollno) throws AdmissionException;
	public ArrayList<Student> getStudentList(int deptno) throws AdmissionException;
}
