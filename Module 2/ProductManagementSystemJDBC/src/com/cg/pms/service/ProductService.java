package com.cg.pms.service;

import java.util.List;
import com.cg.pms.beans.Order;
import com.cg.pms.beans.Product;
import com.cg.pms.exception.InvalidOrderException;
import com.cg.pms.exception.InvalidProductException;
import com.cg.pms.exception.ProductDBException;

public interface ProductService {
	List<Product> getAllProduct() throws ProductDBException;
	Product searchProduct(long productId) throws ProductDBException;
	long addProduct(Product product) throws ProductDBException;
	long addOrder(Order order) throws ProductDBException;
	long deleteProduct(long productId) throws ProductDBException;
	boolean validateProduct(Product product) throws InvalidProductException;
	boolean validateOrder(Order order) throws InvalidOrderException;
}
