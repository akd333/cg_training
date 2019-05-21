/************************************************************************************
 * File                 : NumberCheck.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to accept a number from user as a command line 
 						  argument and check whether the given number is positive
 						  or negative number.
 * Version              : 1.0
 * Last Modified Date   : 16-Apr-2019
 ************************************************************************************/

package com.cg.lab2;

import java.util.Scanner;

public class NumberCheck {

	public static void main(String[] args) {
		System.out.println("Please enter the number");
		
		//accepting the number from command line
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.close();
		
		//checking whether the number is even or odd 
		if(num>0){
			System.out.println("The number is a positive number");
		}else{
			System.out.println("The number is a negative number");
		}

	}

}
