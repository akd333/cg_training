package com.cg.pms.dao;

import java.util.List;

import com.cg.pms.bean.Order;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public interface ProductDao {
	int addProduct(Product product);
	int deleteProduct(int productId) throws ProductException;
	Product searchProduct(int productId) throws ProductException;
	List<Product> showAllProduct() throws ProductException;
	int addOrder(Order order);
}
