package com.capgemini.donorapplication.pi;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.donorapplication.service.DonorServiceImpl;
import com.capgemini.donorapplication.service.IDonorService;

public class DonorMain {

	static Scanner sc = new Scanner(System.in);
	static IDonorService donorService = null;
	static DonorServiceImpl donorServiceImpl = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) {
		PropertyConfigurator.configure("resources//log4j.properties");
		DonorBean donorBean = null;

		String donorId = null;
		int option = 0;

		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("   ICARE CAPGEMINI TRUST ");
			System.out.println("_______________________________\n");

			System.out.println("1.Add Donator ");
			System.out.println("2.View Donator");
			System.out.println("3.Retrive All");
			System.out.println("4.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option

			try {
				option = sc.nextInt();

				switch (option) {

				case 1:

					while (donorBean == null) {
						donorBean = populateDonorBean();
						// System.out.println(donorBean);
					}

					try {
						donorService = new DonorServiceImpl();
						donorId = donorService.addDonorDetails(donorBean);

						System.out
								.println("Donator details  has been successfully registered ");
						System.out.println("Donator  ID Is: " + donorId);

					} catch (DonorException donorException) {
						logger.error("exception occured", donorException);
						System.out.println("ERROR : "
								+ donorException.getMessage());
					} finally {
						donorId = null;
						donorService = null;
						donorBean = null;
					}

					break;

				case 2:

					donorServiceImpl = new DonorServiceImpl();

					System.out.println("Enter numeric donor id:");
					donorId = sc.next();

					while (true) {
						if (donorServiceImpl.validateDonorId(donorId)) {
							break;
						} else {
							System.err
									.println("Please enter numeric donor id only, try again");
							donorId = sc.next();
						}
					}

					donorBean = getDonorDetails(donorId);

					if (donorBean != null) {
						System.out.println("Name             :"
								+ donorBean.getDonorName());
						System.out.println("Address          :"
								+ donorBean.getAddress());
						System.out.println("Phone Number     :"
								+ donorBean.getPhoneNumber());
						System.out.println("Donor Date       :"
								+ donorBean.getDonationDate());
						System.out.println("Donation Amount  :"
								+ donorBean.getDonationAmount());
					} else {
						System.err
								.println("There are no donation details associated with donor id "
										+ donorId);
					}

					break;

				case 3:

					donorService = new DonorServiceImpl();
					try {
						List<DonorBean> donorList = new ArrayList<DonorBean>();
						donorList = donorService.retriveAll();

						if (donorList != null) {
							Iterator<DonorBean> i = donorList.iterator();
							while (i.hasNext()) {
								System.out.println(i.next());
							}
						} else {
							System.out
									.println("Nobody has made a donation, yet.");
						}

					}

					catch (DonorException e) {

						System.out.println("Error  :" + e.getMessage());
					}

					break;

				case 4:

					System.out.print("Exit Trust Application");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-4]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

		}// end of while
	}// end of try

	/*
	 * This function will call the service layer method and return the bean
	 * object which is populated by the information of the given donorId in
	 * parameter
	 */
	private static DonorBean getDonorDetails(String donorId) {
		DonorBean donorBean = null;
		donorService = new DonorServiceImpl();

		try {
			donorBean = donorService.viewDonorDetails(donorId);
		} catch (DonorException donarException) {
			logger.error("exception occured ", donarException);
			System.out.println("ERROR : " + donarException.getMessage());
		}

		donorService = null;
		return donorBean;
	}

	/*
	 * This function will be called by main and will return a validated bean
	 * object OR null if details are invalid
	 */
	private static DonorBean populateDonorBean() {

		// Reading and setting the values for the donorBean
		
		DonorBean donorBean = new DonorBean();;

		System.out.println("\n Enter Details");

		System.out.println("Enter donor name: ");
		donorBean.setDonorName(sc.next());

		System.out.println("Enter donor contact: ");
		donorBean.setPhoneNumber(sc.next());

		System.out.println("Enter donor address: ");
		donorBean.setAddress(sc.next());

		System.out.println("Enter donation amount: ");

		try {
			donorBean.setDonationAmount(sc.nextFloat());
		} catch (InputMismatchException inputMismatchException) {
			sc.nextLine();
			System.err
					.println("Please enter a numeric value for donation amount, try again");
			}

		donorServiceImpl = new DonorServiceImpl();

		try {
			donorServiceImpl.validateDonor(donorBean);
			return donorBean;
		} catch (DonorException donorException) {
			logger.error("exception occured", donorException);
			System.err.println("Invalid data:");
			System.err.println(donorException.getMessage() + " \n Try again..");
			System.exit(0);

		}
		return null;

	}
}
