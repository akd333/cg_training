/************************************************************************************
 -> File                 : MobileMain.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Takes input from console and do appropriate operation
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.ui;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.InvalidMobileException;
import com.cg.mps.exception.InvalidPurchaseException;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.service.MobileService;
import com.cg.mps.service.MobileServiceImpl;


public class MobileMain {

	static Logger logger = Logger.getRootLogger();
	public static void main(String[] args) throws MobileDBException{

		PropertyConfigurator.configure("resources/log4j.properties");
		MobileService mosr = new MobileServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("============================================");
			System.out.println("||              SELECT MENU               ||");
			System.out.println("============================================");
			System.out.println("|       1. Add new mobille                 |");
			System.out.println("|       2. Purchase mobile                 |");
			System.out.println("|       3. Show all mobille                |");
			System.out.println("|       4. Delete Mobile                   |");
			System.out.println("|       5. Search mobile                   |");
			System.out.println("|       6. Search mobile in price range    |");
			System.out.println("|       7. Exit                            |");
			System.out.println("============================================");
			System.out.println("Please Enter your choice\n");
			String choice = sc.nextLine();

			switch (choice) {

			
			case "1":
				/*******************************************
				 -> Case for adding new mobile
				 *******************************************/
				System.out.println("Please enter mobile name you want to add");
				String mname = sc.nextLine();
				System.out.println("Enter mobile price");
				String price = sc.nextLine();
				System.out.println("Enter quantity");
				String quantity = sc.nextLine();
				Mobile mobile = new Mobile(null, mname, price,quantity);
				try {
					if (mosr.isValidMobile(mobile)) {
						String mid = mosr.addMobile(mobile);
						logger.info("Mobile details inserted in table with id "+mid);
						System.out.println("Mobile details inserted successfully in table with id "+mid);
					}
				} catch (InvalidMobileException e) {
					logger.error("Invalid data"+e.getMessage());
					System.err.println(e.getMessage());
				}catch(MobileDBException e){
					logger.error("Unable to insert mobile details\n "+e.getMessage());
					System.err.println(e.getMessage());
				}
				break;

				
			case "2":
				/*******************************************
				 -> Case for purchase mobile
				 *******************************************/
				System.out.println("Please enter mobile id to purchase");
				System.out.println("*Note : Mobile id is started from 1000");
				String mid = sc.nextLine();
				System.out.println("Enter customer name");
				String cname = sc.nextLine();
				System.out.println("Enter emailid");
				String email = sc.nextLine();
				System.out.println("Enter phone number");
				String phone = sc.nextLine();
				PurchaseMobile purchaseMobile = new PurchaseMobile(null,mid,cname,email,phone);
				try{
					if(mosr.searchMobile(mid) == null){
						logger.info("Mobile not avaelable with id "+mid);
						System.err.println("Mobile not avaelable with id"+ mid);
					}else{
						if(mosr.isValidPurchaseMobile(purchaseMobile)){
							mosr.purchaseMobile(purchaseMobile);
							logger.info("Purchase done with id "+purchaseMobile.getPurchaseId());
							System.out.println("Purchase done with id " + purchaseMobile.getPurchaseId());
						}
					}
				}catch (InvalidPurchaseException e) {
					logger.error("Invalid data\n"+ e.getMessage());
					System.err.println(e.getMessage());
				} catch(MobileDBException e){
					logger.error("Unable to make purchase\n"+e.getMessage());
					System.err.println("Unable to make purchase "+e.getMessage());
				}
				break;

				
			case "3":
				/*******************************************
				 -> Case for show all mobiles
				 *******************************************/
				try {
					List<Mobile> mlist = mosr.getAllMobiles() ;
					if (mlist.size() == 0) {
						logger.info("No mobiles avaelable to show");
						System.err.println("No mobile avaelable\n");
					} else {
						for (Mobile m : mlist) {
							System.out.println(m);
						}
					}
				} catch (MobileDBException e) {
					logger.error("Unable to show mobile list\n" +e.getMessage() );
					System.err.println("Unable to show list\n"+e.getMessage());
				}
				break;
			case "4":
				/*******************************************
				 -> Case for deleting a mobile
				 *******************************************/
				System.out.println("Pleasse enter mobile id you want to delete");
				System.out.println("*Note : Mobile id is started from 1000");
				String mobid = sc.nextLine();
				try {
					if(mosr.searchMobile(mobid) == null){
						logger.info("Mobile doesn't exist with product id " + mobid);
						System.err.println("Mobile doesn't exist with product id " + mobid);
					}else{
						mosr.deleteMobile(mobid);
						logger.info("");;
						System.out.println("Mobile deleted with mobile id " + mobid);
					}
				} catch (MobileDBException e) {
					System.err.println("Unable to delete mobile "+e.getMessage());
				} 
				break;
			case "5":
				/*******************************************
				 -> Case for searching a mobile
				 *******************************************/
				System.out.println("Please enter mobile id you want to search");
				System.out.println("*Note : Mobile id is started from 1000");
				String mobileid = sc.nextLine();
				try{
					System.out.println("Search result is:");
					Mobile mob;
					mob=mosr.searchMobile(mobileid);
					if (mob==null) {
						System.err.println("Incorrect id. No mobile avaelable with id "+mobileid);
					}else{
						System.out.println(mob);
					}
				}catch(MobileDBException e){
					logger.error("Problem in searching product" + e.getMessage());
					System.err.println(e.getMessage());
				}
				break;	
			case "6":
				/*************************************************
				 -> Case for searching mobiles in  price range
				 *************************************************/
				System.out.println("Please enter the price range to search mobiles");
				System.out.println("Enter lowest price");
				String startPrice  = sc.nextLine();
				System.out.println("Enter highest price");
				String endPrice = sc.nextLine();
				List<Mobile> mlist;
				try {
					mlist = mosr.searchMobileInPriceRange(startPrice, endPrice);
					if(mlist.size()==0){
						System.out.println("No mobiles available");
					}else{
						for(Mobile mob:mlist){
							System.out.println(mob);
						}
					}
				} catch (MobileDBException e) {
					System.err.println(e.getMessage());
				}
				
				break;
				
			case "7":
				/*******************************************
				 -> Case for existing from menu
				 *******************************************/
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
