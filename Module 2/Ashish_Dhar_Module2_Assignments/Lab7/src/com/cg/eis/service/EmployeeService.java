package com.cg.eis.service;

import java.util.List;
import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;

public interface EmployeeService {
	int addEmployee(Employee employee);
	String findInsuranceScheme(double salary) throws EmployeeException;
	List<Employee> showAllEmployee() throws EmployeeException;
	int deleteEmployee(int id) throws EmployeeException;
	int sortEmployee(double salary) throws EmployeeException;
	int searchEmployee(String insuranceScheme) throws EmployeeException;
}
