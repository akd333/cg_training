/************************************************************************************
 -> File                 : EnquiryMain.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Takes input from console and do appropriate operation
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.pl;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.enquiry.bean.EnquiryBean;
import com.cg.enquiry.exception.EnquiryDBException;
import com.cg.enquiry.exception.InvalidEnquiryException;
import com.cg.enquiry.service.EnquiryService;
import com.cg.enquiry.service.EnquiryServiceImpl;


public class EnquiryMain {

	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources/log4j.properties");
		EnquiryService eser = new EnquiryServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("============================================");
			System.out.println("||              SELECT MENU               ||");
			System.out.println("============================================");
			System.out.println("|       1. Enter Enquiry Details           |");
			System.out.println("|       2. View Enquiry Details On ID      |");
			System.out.println("|       3. Exit                            |");
			System.out.println("============================================");
			System.out.println("Please Enter your choice\n");
			String choice = sc.nextLine();

			switch (choice) {
			case "1":
				/*******************************************
				 -> Case for adding enquiry
				 *******************************************/
				System.out.println("Please enter first name : ");
				String fname = sc.nextLine();
				System.out.println("Please enter last name : ");
				String lname = sc.nextLine();
				System.out.println("Please enter contact number : ");
				String contact = sc.nextLine();
				System.out.println("Please enter your prefered domain : ");
				String domain = sc.nextLine();
				System.out.println("Please enter your prefered location : ");
				String location = sc.nextLine();
				EnquiryBean enquiry = new EnquiryBean(null, fname,lname, contact, domain, location);
				try {
					if (eser.isValidEnquiry(enquiry)) {
						String eid = eser.addEnquiry(enquiry);
						logger.info("Enquiry details inserted in table with id "+eid);
						System.out.println("Thank yor "+enquiry.getFirstName()+" "+enquiry.getLastName()+" \n"+
						"Your unique id is "+enquiry.getEnquiryId()+ " "+"We will contact you soon");
					}
				} catch (InvalidEnquiryException e) {
					logger.error("Invalid data"+e.getMessage());
					System.err.println(e.getMessage());
				}catch(EnquiryDBException e){
					logger.error("Unable to insert mobile details\n "+e.getMessage());
					System.err.println(e.getMessage());
				}
				break;
			case "2":
				/*******************************************
				 -> Case for searching enquiry with id
				 *******************************************/
				System.out.println("Please enter the enquiry id you want to serch");
				System.out.println("*Note : Mobile id is started from 1001");
				String enquiryId = sc.nextLine();
				try{
					System.out.println("Search result is :\n");
					EnquiryBean enquBean;
					enquBean = eser.getEnquiryDetails(enquiryId);
					if (enquBean==null) {
						System.err.println("Sorry no details found with id "+enquiryId+" !!!");
					}else{
						System.out.println("Enquiry ID  : "+enquBean.getEnquiryId());
						System.out.println("First Name  : "+enquBean.getFirstName());
						System.out.println("Last Name   : "+enquBean.getLastName());
						System.out.println("Contact No  : "+enquBean.getContactNumber());
						System.out.println("Domain      : "+enquBean.getDomain());
						System.out.println("Location    : "+enquBean.getLocation());
					}
				}catch(EnquiryDBException e){
					logger.error("Problem in searching enquiry details /n" + e.getMessage());
					System.err.println(e.getMessage());
				}
				break;
			case "3":
				/*******************************************
				 -> Case for existing from menu
				 *******************************************/
				System.out.println("Thank you for selecting us !!!");
				System.exit(0);
				break;
			default:
				/*******************************************
				 -> Default case for invalid choice 
				 *******************************************/
				logger.info("Invalid choice");
				System.err.println("You have entered an invalid choice ... Please try again!");
				break;
			}

		} while (true);

	}

}
