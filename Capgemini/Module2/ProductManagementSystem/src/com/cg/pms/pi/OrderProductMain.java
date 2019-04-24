package com.cg.pms.pi;

//import java.util.List;
import java.util.List;
import java.util.Scanner;

import com.cg.pms.bean.Order;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;
import com.cg.pms.service.ProductService;
import com.cg.pms.service.ProductServiceImpl;


public class OrderProductMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductService pser = new ProductServiceImpl();
		do{
			System.out.println("Menu");
			System.out.println("==================================");
			System.out.println("1. Add Product");
			System.out.println("2. Search Product");
			System.out.println("3. Delete Product");
			System.out.println("4. Show Product List");
			System.out.println("5. Place Order");
			System.out.println("6. Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Product name");
				String pname = sc.next();
				System.out.println("Enter product price");
				int pprice = sc.nextInt();
				Product p = new Product(pname,pprice);
				try{
					if(pser.validateProduct(p)){
						int pid = pser.addProduct(p);
						System.out.println("Product added with product ID :"+pid);	
					}
				}catch(ProductException e2){
					System.out.println(e2.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter Product ID");
				int pid3 = sc.nextInt();
				try{
					System.out.println("Search result is:");
					pser.searchProduct(pid3);
					System.out.println(pid3);
				}catch(ProductException e4){
					System.out.println(e4.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter product ID to delete");
				int pid1 = sc.nextInt();
				try{
					pser.deleteProduct(pid1);
					System.out.println("Product deleted with id :"+pid1);
				}catch(ProductException e1){
					System.out.println(e1.getMessage());
				}
				break;
			case 4:
				try{
					List<Product> plist = pser.showAllProducts();
					for(Product p1:plist){
						System.out.println("Product List");
						System.out.println("_________________");
						System.out.println(p1);
					}
				}catch(ProductException e){
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println("Enter product ID to order product");
				int pid2 = sc.nextInt();
				System.out.println("Enter Quantity");
				int qty = sc.nextInt();
				Product p1;
				try{
					p1 = pser.searchProduct(pid2);
					Order o = new Order(p1,qty,0);
					int oid = pser.addOrder(o);
					System.out.println("Order Placed with id :" +oid);
					System.out.println("You need to pay amount :"+o.getAmount());
				}catch(ProductException e3){
					System.out.println(e3.getMessage());
				}
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid chice...Please try again!!!");
			}
		}while(true);

	}

}
