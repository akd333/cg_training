package com.cg.studmgmt.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.studmgmt.dao.IStudentDao;
import com.cg.studmgmt.dao.StudentDaoImpl;
import com.cg.studmgmt.dto.Department;
import com.cg.studmgmt.dto.Student;
import com.cg.studmgmt.exception.AdmissionException;

public class StudentServiceImpl implements IStudentService {

	IStudentDao dao;
	public StudentServiceImpl() {
		dao= new StudentDaoImpl();
	}
	@Override
	public int addStudent(Student student) throws AdmissionException{
		return dao.addStudent(student);
	}
	@Override
	public ArrayList<Department> getDepartments() throws AdmissionException{
		// TODO Auto-generated method stub
		return dao.getDepartments();
	}
	@Override
	public int updateStudentAddress(String add, int rn) throws AdmissionException {
		// TODO Auto-generated method stub
		return dao.updateAddress(add, rn);
	}
	@Override
	public Student validateStudentDetails(Student student)
			throws AdmissionException {
		
		Pattern pattern= Pattern.compile("^[A-Z][a-z]{4,}$");
		Matcher matcher= pattern.matcher(student.getName());
		if(matcher.matches()==false) 
			throw new AdmissionException("Name is not valid ");
		return student;
	}
	public boolean validateDept(int deptNo,ArrayList<Department> list) throws AdmissionException {
		boolean flag=false;
			for(Department dept :list){
				if(dept.getDeptNo()==deptNo){
					flag=true;
					break;
				}
			}		
		return flag;
	}
	@Override
	public ArrayList<Student> getStudentList(int deptno) throws AdmissionException {
		return dao.getStudentList(deptno);
	}

}
