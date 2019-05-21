package com.cg.sms.service;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import com.cg.sms.bean.Student;
import com.cg.sms.exception.StudentException;

public class StudentServiceImpl implements StudentService {
	HashMap<Integer, Student> studentMap = new HashMap<>(); 
	
	@Override
	public int addNewStudent(Student student) throws StudentException {
		
		studentMap.put(student.getStudentRollNo(), student);
		return student.getStudentRollNo();
	}

	@Override
	public List<Student> displayAllStudents() throws StudentException {
		List<Student> slist = new ArrayList<>();
		Set<Integer> keys = studentMap.keySet();
		if(keys.size()==0){
			throw new StudentException("No student record avaelable!!!");
		}
		for(Integer k:keys)
			slist.add(studentMap.get(k));
		return slist;
		
	}

	@Override
	public boolean isStudentDataValid(Student student) throws StudentException {
		String age = Integer.toString(student.getStudentAge());
		String roll = Integer.toString(student.getStudentRollNo());
		
		if(!Pattern.matches("^[A-Z][a-z]{4,19}$",student.getStudentName())){
			throw new StudentException("Student name should start with capital letter and name should be of  4-20 characters");
		}if(!((student.getStudentCity().equals("Pune"))||(student.getStudentCity().equals("Mumbai"))||(student.getStudentCity().equals("Hyderabad")))){
			throw new StudentException("This city is not avaelable");
		}if(student.getStudentAge()>99 || student.getStudentAge()<=0){
			throw new StudentException("Please enter a valid age");
		}if(age == null){
			throw new StudentException("Please enter age!!!!");
		}if(student.getStudentRollNo() <=0){
			throw new StudentException("Student roll number can not be zero or negative");
		}if(roll == null){
			throw new StudentException("Please enter roll number!!!");
		}if(!Pattern.matches("^[0-9]{1,2}$",age)){
			throw new StudentException("Please enter a valid age between 1-99 (Maximum 2 digit)");
		}if(!Pattern.matches("^[0-9]{1,3}$",roll)){
			throw new StudentException("Please enter a valid age between 1-99(Maximum 3 digit)");
		}
	return true;
}
	
}
