/************************************************************************************
 * File                 : Person.java
 * Author Name          : Ashish Dhar
 * Desc                 : Creating person class and its objects
 * Version              : 1.0
 * Last Modified Date   : 16-Apr-2019
 ************************************************************************************/

package com.cg.lab3;


public class Person {
	String firstName;
	String lastName;
	enum gender{M,F};
	long phone;
	
	//Default constructor called
	Person(){
		
	}
	
	//Parameterized constructor
	Person(String firstName,String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	//constructor foe phone object
	public Person(long phone) {
		this.phone=phone;
	}
	
	//method to display phone number
	public long displyPhoneNumber(){
		return phone;
	}
	
	//generating getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	
	
}
