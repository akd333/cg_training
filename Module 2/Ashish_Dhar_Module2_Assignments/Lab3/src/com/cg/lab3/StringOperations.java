/************************************************************************************
 * File                 : StringOperations.java
 * Author Name          : Ashish Dhar
 * Desc                 : Program to perform a particular String operation based on
  						  the user’s choice
 * Version              : 1.0
 * Last Modified Date   : 17-Apr-2019
 ************************************************************************************/
package com.cg.lab3;

import java.util.Scanner;
public class StringOperations{
	public static void main(String[] args) {
		String str,strOut="";

		do{
			System.out.println("Please enter the string");
			Scanner sc = new Scanner(System.in);
			str = sc.nextLine();
			System.out.println("Please select the operation you want to perform");
			System.out.println("_________________________________________________");
			System.out.println("1.Add the String to itself");
			System.out.println("2.Replace odd positions with #");
			System.out.println("3.Remove duplicate characters in the String");
			System.out.println("4.Change odd characters to upper case");
			System.out.println("5.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			//logic for adding the string to itself
			case 1:
				strOut = str+str;
				System.out.println("The new string after addition is :");
				System.out.println(strOut);
				break;
				//logic for replace odd positions with #
			case 2:
				for (int i=0; i < str.length(); i++){
					if (i % 2 != 0){
						str = str.substring(0,i-1) + "#" + str.substring(i, str.length());
					}
				}
				System.out.println(str);
				break;
				//logic for removing duplicate characters in a string
			case 3:
				for (int i = 0; i < str.length(); i++) {
					if(!strOut.contains(String.valueOf(str.charAt(i)))) {
						strOut += String.valueOf(str.charAt(i));
					}
				}
				System.out.println(strOut);
				break;
				//logic for change odd characters to upper case
			case 4:
				for (int i = 0; i < str.length();i++) {
					char ch = str.charAt(i);
					if (i % 2 == 0) {
						System.out.print(Character.toLowerCase(ch));
					} else {
						System.out.print(Character.toUpperCase(ch));
					}
				}
				System.out.println();
				break;
				//exit
			case 5:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid chice...try again!!!");
			}
		}while(true);
	}

}
