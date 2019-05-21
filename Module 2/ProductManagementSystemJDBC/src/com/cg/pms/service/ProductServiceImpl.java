package com.cg.pms.service;

import java.util.List;

import com.cg.pms.beans.Order;
import com.cg.pms.beans.Product;
import com.cg.pms.dao.ProductDao;
import com.cg.pms.dao.ProductDaoImpl;
import com.cg.pms.exception.InvalidOrderException;
import com.cg.pms.exception.InvalidProductException;
import com.cg.pms.exception.ProductDBException;

public class ProductServiceImpl implements ProductService {
	
	ProductDao pdao = new ProductDaoImpl();
	@Override
	public List<Product> getAllProduct() throws ProductDBException {
		return pdao.getAllProduct();
	}

	@Override
	public Product searchProduct(long productId) throws ProductDBException {
		return pdao.searchProduct(productId);
	}

	@Override
	public long addProduct(Product product) throws ProductDBException {
		return pdao.addProduct(product);
	}

	@Override
	public long addOrder(Order order) throws ProductDBException {
		Product p = pdao.searchProduct(order.getProductId());
		order.setTotalAmount(order.getQuantity()*p.getProductPrice());
		return pdao.addOrder(order);
	}

	@Override
	public long deleteProduct(long productId) throws ProductDBException {
		return pdao.deleteProduct(productId);
	}

	@Override
	public boolean validateProduct(Product product) throws InvalidProductException {
		if(!product.getProductName().matches("[A-Z][a-z]{3,}")){
			throw new InvalidProductException("Product name should start with capital letter and it should be minimum of 3 letters");
		}
		if(product.getProductPrice()<=0){
			throw new InvalidProductException("Price should not be less than 1");
		}
		return true;
	}

	@Override
	public boolean validateOrder(Order order) throws InvalidOrderException {
		if(order.getQuantity()<=0){
			throw new InvalidOrderException("Quantity should not be negative or 0");
		}
		return true;
	}

}
