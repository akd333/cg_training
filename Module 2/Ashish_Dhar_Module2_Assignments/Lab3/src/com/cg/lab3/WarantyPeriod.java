/************************************************************************************
 * File                 : WarantyPeriod.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to calculate waranty period
 * Version              : 1.0
 * Last Modified Date   : 18-Apr-2019
 ************************************************************************************/

package com.cg.lab3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class WarantyPeriod {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter the purchase date ");  
		String pdate = sc.next();     
		LocalDate pd= LocalDate.parse(pdate, format);

		System.out.print("Enter the waranty period in years"); 
		int wyears = sc.nextInt();
		System.out.print("Enter the waranty period in months"); 
		int wmonths = sc.nextInt();

		LocalDate expyr = pd.plusYears(wyears);
		LocalDate expmonth = expyr.plusMonths(wmonths);
		System.out.println("The date of expiry of waranty is :"+expmonth);
	}

}