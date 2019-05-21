package com.cg.eis.service;

import java.util.HashMap;
import java.util.List;

import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {
	
	//HashMap<Integer, Employee> = new Hash 
	
	@Override
	public int addEmployee(Employee employee) {

		return 0;
	}

	@Override
	public String findInsuranceScheme(double salary) throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> showAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteEmployee(int id) throws EmployeeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int sortEmployee(double salary) throws EmployeeException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int searchEmployee(String insuranceScheme) throws EmployeeException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
