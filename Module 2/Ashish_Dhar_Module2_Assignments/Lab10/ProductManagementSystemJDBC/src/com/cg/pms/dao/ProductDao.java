package com.cg.pms.dao;

import java.util.List;

import com.cg.pms.beans.Order;
import com.cg.pms.beans.Product;
import com.cg.pms.exception.ProductDBException;

public interface ProductDao {
	List<Product> getAllProduct() throws ProductDBException;
	Product searchProduct(long productId) throws ProductDBException;
	long addProduct(Product product) throws ProductDBException;
	long addOrder(Order order) throws ProductDBException;
	long deleteProduct(long productId) throws ProductDBException;
}
