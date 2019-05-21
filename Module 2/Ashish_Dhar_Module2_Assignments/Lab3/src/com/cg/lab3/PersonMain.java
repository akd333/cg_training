/************************************************************************************
 * File                 : PersonMain.java
 * Author Name          : Ashish Dhar
 * Desc                 : Display person details 
 * Version              : 1.0
 * Last Modified Date   : 16-Apr-2019
 ************************************************************************************/

package com.cg.lab3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.cg.lab3.Person.gender;

public class PersonMain {
	static Person p = new Person("Ashish","Dhar");
	static int calculateAge(){
		String dobStr = "28/05/1996";
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dob= LocalDate.parse(dobStr, format);
		Period diff = Period.between(dob,LocalDate.now());
		int age = diff.getYears();
		return age;
	}
	static String getFullName(){
		String fname = p.getFirstName();
		String lname = p.getLastName();
		return fname+" "+lname;
	}
	public static void main(String[] args) {
		
		gender p1 = Person.gender.F;
		Person p2 = new Person(223557);
		System.out.println("Person Details");
		System.out.println("______________");
		System.out.println("");
		System.out.println("First Name : "+p.getFirstName());
		System.out.println("Last Name : "+p.getLastName());
		System.out.println("Gender : "+p1);
		System.out.println("Phone Number : "+p2.displyPhoneNumber());
		System.err.println("Fullname is "+getFullName());
		System.out.println("Age is "+calculateAge());
	}

}
