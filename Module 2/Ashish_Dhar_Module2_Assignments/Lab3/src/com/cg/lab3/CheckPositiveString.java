/************************************************************************************
 * File                 : CheckPositiveString.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to check a string is positive or not
 * Version              : 1.0
 * Last Modified Date   : 18-Apr-2019
 ************************************************************************************/
package com.cg.lab3;
import java.util.Arrays; 
import java.util.Scanner;

public class CheckPositiveString { 
 
	static boolean isPositive(String s) 
	{ 
		// length of the string 
		int n = s.length(); 
		
		// create a character array of the length of the string 
		char c[] = new char [n]; 
		
		// assign the string to character array 
		for (int i = 0; i < n; i++) { 
			c[i] = s.charAt(i); 
		} 
		
		// sort the character array 
		Arrays.sort(c); 
		
		// check if the character array is equal to the string or not 
		for (int i = 0; i < n; i++) 
			if (c[i] != s.charAt(i)) 
				return false; 
				
		return true;	 
	} 
	
	public static void main(String args[]) 
	{ 
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the string");
		String s = sc.nextLine(); 
		
		// check whether the string is positive or not
		if (isPositive(s)) 
			System.out.println("The string is a positive string"); 
		else
			System.out.println("The string is not a positive string"); 
			
	} 
} 
