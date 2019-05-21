/************************************************************************************
 * File                 : PersonMain.java
 * Author Name          : Ashish Dhar
 * Desc                 : Display person details 
 * Version              : 1.0
 * Last Modified Date   : 16-Apr-2019
 ************************************************************************************/

package com.cg.lab2;

import com.cg.lab2.Person.gender;

public class PersonMain {
	
	
	public static void main(String[] args) {
		Person p = new Person("Ashish","Dhar");
		gender p1 = Person.gender.F;
		Person p2 = new Person(223557);
		System.out.println("Person Details");
		System.out.println("______________");
		System.out.println("");
		System.out.println("First Name : "+p.getFirstName());
		System.out.println("Last Name : "+p.getLastName());
		System.out.println("Gender : "+p1);
		System.out.println("Phone Number : "+p2.displyPhoneNumber());
	}

}
