package com.cg.studmgmt.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.studmgmt.dto.Department;
import com.cg.studmgmt.dto.Student;
import com.cg.studmgmt.exception.AdmissionException;
import com.cg.studmgmt.service.IStudentService;
import com.cg.studmgmt.service.StudentServiceImpl;

public class Main {

	static Logger lg= Logger.getLogger("LoggerForMain");
	public void acceptStudentDetails(Student student) throws AdmissionException{
		PropertyConfigurator.configure("./resources/log4j.properties");

		IStudentService service= new StudentServiceImpl();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter name : ");
		String name= sc.next();
		System.out.println("Enter Address : ");
		String address= sc.next();
		System.out.println("Select Department : ");
		ArrayList<Department> list=service.getDepartments();
		for(Department dept: list){
			System.out.println(dept.getDeptNo()+"."+dept.getDeptName());
		}
		int no= sc.nextInt();
		if(service.validateDept(no, list)==false)
			throw new AdmissionException("Dept No is invalid..");
		else{
		System.out.println("Enter Admission Date :(dd-MM-yyyy) ");
		String str= sc.next();
		DateTimeFormatter fmt= DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date= LocalDate.parse(str,fmt);
		
		student.setName(name);
		student.setAddress(address);
		student.setDeptNo(no);
		student.setAdmissionDate(date);
		}
	}
	public static void main(String[] args) {

			Main obj= new Main();
			IStudentService service= new StudentServiceImpl();
			Student student= new Student();
			Scanner sc= new Scanner(System.in);
			while(true){
			try {
				System.out.println("-------Menu----------");
				System.out.println("1. add student");
				System.out.println("2. update Student address");
				System.out.println("3. Delete student");
				System.out.println("4. Display Student List ");
				int ch= sc.nextInt();
				switch(ch){
				case 1 :
					obj.acceptStudentDetails(student);
					student= service.validateStudentDetails(student);
					int rollno= service.addStudent(student);
				System.out.println("Record inserted..."+ rollno );
					break;
				case 2 : 
					System.out.println("Enter Address ");
					String address = sc.next();
					System.out.println("Enter rollno ");
					int rn= sc.nextInt();
					int res= service.updateStudentAddress(address, rn);
						if(res==1){
						lg.info("address Updated for : "+ rn);
							System.out.println("address updated ");
						}
						else{
							lg.error("Rollno :"+ rn+" not found ");
							System.out.println("No record found for : "+ rn);
						}
						break;
				case 4: 
					System.out.println("Enter dept No ");
					int dno= sc.nextInt();
					ArrayList<Student> list= service.getStudentList(dno);
					if(list.size()==0){
						System.out.println("No record found");
						lg.error("List is empty");
					}
					else {
						for(Student s: list){
							System.out.println(s);
						}
					}
					break;
				}
			} catch (AdmissionException e) {
				lg.error(e.getMessage());
				System.out.println(e.getMessage());
			}
	}//end of while
	}//end of main 
}// end of class












