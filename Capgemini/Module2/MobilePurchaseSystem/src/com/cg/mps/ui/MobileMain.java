package com.cg.mps.ui;

import java.util.Scanner;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.InvalidMobileException;
import com.cg.mps.exception.InvalidPurchaseException;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.service.MobileService;
import com.cg.mps.service.MobileServiceImpl;

public class MobileMain {

	public static void main(String[] args) throws MobileDBException{
		MobileService mosr = new MobileServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("_______________________________________");
			System.out.println("1. Add new mobile");
			System.out.println("2. Purchase mobile");
			System.out.println("3. Show all mobiles");
			System.out.println("4. Delete Mobile");
			System.out.println("5. Search mobile in price range");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter mobile name");
				String mname = sc.next();
				System.out.println("Enter mobile price");
				String price = sc.next();
				System.out.println("Enter quantity");
				String quantity = sc.next();
				Mobile m = new Mobile(0, mname, price,quantity);
				try {
					if (mosr.validateMobile(m)) {
					long mid = mosr.addMobile(m);
						System.out.println("Mobile inserted in table with id "+mid);
					}
				} catch (InvalidMobileException e) {
					System.out.println(e.getMessage());
				}catch(MobileDBException e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter mobile id to order");
				long pid = 0;
				long mid = sc.nextLong();
				System.out.println("Enter customer name");
				String cname = sc.next();
				System.out.println("Enter emailid");
				String email = sc.next();
				System.out.println("Enter phone number");
				String phone = sc.next();
				PurchaseMobile purchaseMobile = new PurchaseMobile(pid,mid,cname,email,phone);
				try{
					if(mosr.searchMobile(mid) == null){
						System.out.println("Product not avaelable with "+ mid);
					}else{
						if(mosr.validatePurchaseMobile(purchaseMobile)){
							mosr.purchaseMobile(purchaseMobile);
							System.out.println("Purchase done with id " + purchaseMobile.getPurchaseId());
						}
					}
				}catch(MobileDBException e){
					System.out.println(e.getMessage());
				} catch (InvalidPurchaseException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:

				break;
			case 6:

				break;

			default:
				break;
			}
		} while (true);


	}

}
