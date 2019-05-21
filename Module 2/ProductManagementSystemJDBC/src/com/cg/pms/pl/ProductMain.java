package com.cg.pms.pl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import com.cg.pms.beans.Order;
import com.cg.pms.beans.Product;
import com.cg.pms.exception.InvalidOrderException;
import com.cg.pms.exception.InvalidProductException;
import com.cg.pms.exception.ProductDBException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;

public class ProductMain {
	public static void main(String[] args) throws ProductDBException {
		ProductService pser = new ProductServiceImpl();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Menu");
			System.out.println("_______________________________________");
			System.out.println("1. Add product");
			System.out.println("2. Delete product");
			System.out.println("3. Show all product");
			System.out.println("4. place order");
			System.out.println("5. Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter product name");
				String pname = sc.next();
				System.out.println("Enter product price");
				double price = sc.nextDouble();
				Product p = new Product(0, pname, price);
				try {
					if (pser.validateProduct(p)) {
					long pid = pser.addProduct(p);
						System.out.println("Product inserted in table with id "+pid);
					}
				} catch (InvalidProductException e) {
					System.out.println(e.getMessage());
				}catch(ProductDBException e){
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter product id you want to delete");
				int prid = sc.nextInt();
				try {
					if(pser.searchProduct(prid) == null){
						System.out.println("Product doesn't exist");
					}else{
						pser.deleteProduct(prid);
						System.out.println("Product deleted with product id " + prid);
					}
				} catch (ProductDBException e) {
					System.out.println(e.getMessage());
				} 
				break;
			case 3:
				try {
					List<Product> plist = pser.getAllProduct();
					if (plist.size() == 0) {
						System.out.println("No product avaelable");
					} else {
						for (Product p2 : plist) {
							System.out.println(p2);
						}
					}
				} catch (ProductDBException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				System.out.println("Enter product id to order");
				int pid = sc.nextInt();
				System.out.println("Enter Quantity");
				int qty = sc.nextInt();
				System.out.println("Enter order date in DD/MM/YYYY format");
				String ordDateStr = sc.next();
				DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				LocalDate ordDate = LocalDate.parse(ordDateStr, format);
				Order order = new Order(0,pid,qty,0,ordDate);
				try{
					if(pser.searchProduct(pid) == null){
						System.out.println("Product not avaelable with "+ pid);
					}else{
						if(pser.validateOrder(order)){
							pser.addOrder(order);
							System.out.println("Order placed with id " + order.getOrderId());
							System.out.println("Total amount to pay "+ order.getTotalAmount());
						}
					}
				}catch (InvalidOrderException e) {
					System.out.println(e.getMessage());
				}catch(ProductDBException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice !!! Please try again");
			}
		} while (true);

	}

}
