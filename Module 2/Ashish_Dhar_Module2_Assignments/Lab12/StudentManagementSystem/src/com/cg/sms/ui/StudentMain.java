package com.cg.sms.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.cg.sms.bean.Student;
import com.cg.sms.exception.StudentException;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class StudentMain {

	public static void main(String[] args) {
		StudentService ser = new StudentServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("=====================");
			System.out.println("1. Add new student");
			System.out.println("2. Display all students");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				
				System.out.println("Enter student roll number");
				int roll = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter student city(Pune,Mumbai,Hyderabad)");
				String city = sc.next();
				sc.nextLine();
				System.out.println("Enter student age");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter student name");
				String name = sc.next();
				sc.nextLine();
				
				
				
				
				StringBuffer state = new StringBuffer(""); 
				
				if(city.equals("Pune")){
					state=state.append("Maharastra");
				}else if(city.equals("Mumbai")){
					state = state.append("Maharastra");
				}else if(city.equals("Hyderabad")){
					state = state.append("Telengana");
				}
				LocalDate doj = LocalDate.now();
				
				Student s = new Student(roll,name,age,city,doj,state);
				try{
					if(ser.isStudentDataValid(s)){
						int rollno = ser.addNewStudent(s);
						System.out.println("Student record created with roll no :"+rollno);	
					}
				}catch(StudentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				try{
					List<Student> slist = ser.displayAllStudents();
					System.out.println("All student records");
					System.out.println("________________________________________________________________________________________________");
					for(Student s1:slist){
						System.out.println(s1);
					}
				}catch(StudentException e){
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.exit(0);
			default:
				System.out.println("Invalid chice...Please try again!!!");
			}
		} while (true);
	}

}
