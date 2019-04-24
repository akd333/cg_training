package com.cg.pms.service;

import java.util.List;

import com.cg.pms.bean.Order;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductService {
	int addProduct(Product product);
	Product searchProduct(int productId) throws ProductException;
	int deleteProduct(int productId) throws ProductException;
	List<Product> showAllProducts() throws ProductException;
	int addOrder(Order order);
	boolean validateProduct(Product product) throws ProductException;
	boolean validateOrder(Order order) throws ProductException;
}
