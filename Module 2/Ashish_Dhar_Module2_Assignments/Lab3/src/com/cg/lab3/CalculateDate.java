/************************************************************************************
 * File                 : CalculateDate.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to accept a date and print duration in days,months and year
 * Version              : 1.0
 * Last Modified Date   : 18-Apr-2019
 ************************************************************************************/
package com.cg.lab3;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CalculateDate {

	public static void main(String[] args) {
		
        Scanner sc = new Scanner(System.in);  
        System.out.print("Enter Date in dd/MM/yy format: ");  
        String date = sc.next();     
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dt = LocalDate.parse(date, format);
        LocalDate now = LocalDate.now();
        System.out.println("Date is: "+date);
        System.out.println("Today's date is: "+now);
        
        Period diff = Period.between(dt, now);
        System.out.printf("\nDifference is %d years, %d months and %d days \n\n",diff.getYears(), diff.getMonths(), diff.getDays());
	}

}
