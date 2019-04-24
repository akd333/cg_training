package com.cg.studmgmt.test;

import java.util.ArrayList;

import org.junit.Test;

import junit.framework.Assert;

import com.cg.studmgmt.dto.Department;
import com.cg.studmgmt.dto.Student;
import com.cg.studmgmt.exception.AdmissionException;
import com.cg.studmgmt.service.IStudentService;
import com.cg.studmgmt.service.StudentServiceImpl;

public class TestClass {
	
	@Test
	public void test_validateDeptOnfalse() throws AdmissionException{
		IStudentService service= new StudentServiceImpl();
			ArrayList<Department> list= service.getDepartments();
			Boolean res= service.validateDept(11033, list);
			Assert.assertFalse(res);
	}

	@Test(expected=NullPointerException.class)
	public void test_validateDept_on_null_list(){
		IStudentService service= new StudentServiceImpl();
		try {
			service.validateDept(102, null);
		} catch (AdmissionException e) {
		}
	}	
	@Test
	public void test_validateDept(){
		IStudentService service= new StudentServiceImpl();
		try {
			ArrayList<Department> list= service.getDepartments();
			Boolean res= service.validateDept(102, list);
			Assert.assertTrue(res);
			
		} catch (AdmissionException e) {
			
		}
		
	}
}
