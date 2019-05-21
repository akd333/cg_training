package com.cg.sms.service;

import java.util.List;

import com.cg.sms.bean.Student;
import com.cg.sms.exception.StudentException;

public interface StudentService {
	int addNewStudent(Student student) throws StudentException;
	List<Student> displayAllStudents() throws StudentException;
	boolean isStudentDataValid(Student student) throws StudentException;

}
