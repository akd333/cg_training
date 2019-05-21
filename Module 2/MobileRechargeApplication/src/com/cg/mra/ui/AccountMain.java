package com.cg.mra.ui;

import java.util.Scanner;

import com.cg.mra.bean.AccountBean;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.service.AccountService;
import com.cg.mra.service.AccountServiceImpl;

public class AccountMain {

	public static void main(String[] args) throws MobileRechargeException{
		AccountService accService = new AccountServiceImpl();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("1. Account Balance Enquiry");
			System.out.println("2. Recharge account");
			System.out.println("3. Exit");
			System.out.println("Please select an option");
			
			String choice = scanner.next();
			switch (choice) {
			case "1":
				System.out.println("Enter account id");
				String accId = scanner.next();
				try{
					AccountBean accBean;
					accBean=accService.getAccountDetails(accId);
					if (accBean==null) {
						System.err.println("Incorrect account id "+accId);
					}else{
						System.out.println(accBean);
					}
				}catch(MobileRechargeException e){
					System.err.println(e.getMessage());
				}
				break;
			case "2":
				System.out.println("Please enter account id to recharge ");
				String accountid = scanner.next();
				System.out.println("Enter ammount");
				String amount = scanner.next();
				AccountBean accBean = new AccountBean(accountid, null, null,amount);
				try {
					if (accService.isValidRecharge()) {
						String aid = accService.rechargeAccount(accountid, amount);
						System.out.println("Account recharged with id "+accountid);
					}
				} catch(MobileRechargeException e){
					System.err.println(e.getMessage());
				}
				break;
			case "3":
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice ...Please Try again");
				break;
			}
		} while (true);

	}

}
