package com.cg.studmgmt.service;

import java.util.ArrayList;

import com.cg.studmgmt.dto.Department;
import com.cg.studmgmt.dto.Student;
import com.cg.studmgmt.exception.AdmissionException;

public interface IStudentService {

	public int addStudent(Student student) throws AdmissionException;
	public ArrayList<Department> getDepartments() throws AdmissionException;
	public int updateStudentAddress(String add,int rn) throws AdmissionException;
	public Student validateStudentDetails(Student student)throws AdmissionException;
	public boolean validateDept(int deptNo,ArrayList<Department> list) throws AdmissionException ;
	public ArrayList<Student> getStudentList(int deptno) throws AdmissionException;
		
}
