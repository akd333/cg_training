/************************************************************************************
 * File                 : CalculateDate.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to accept two dates and print duration in days,months and year
 * Version              : 1.0
 * Last Modified Date   : 18-Apr-2019
 ************************************************************************************/
package com.cg.lab3;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculateDay {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		System.out.print("Enter First Date in dd/mm/yy format: ");  
		String fdate = sc.next();     
		LocalDate d1= LocalDate.parse(fdate, format);
		
		System.out.print("Enter Last Date in dd/mm/yy format:: "); 
		String ldate = sc.next();
		LocalDate d2 = LocalDate.parse(ldate, format);
		
		Period diff = Period.between(d1, d2);
		System.out.printf("\nDifference is %d years, %d months and %d days \n\n",diff.getYears(), diff.getMonths(), diff.getDays());
		
	}

}
