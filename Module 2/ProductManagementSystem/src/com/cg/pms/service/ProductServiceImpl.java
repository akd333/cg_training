package com.cg.pms.service;

import java.util.List;

import java.util.regex.Pattern;
import com.cg.pms.bean.Order;
import com.cg.pms.bean.Product;
import com.cg.pms.dao.ProductDao;
import com.cg.pms.dao.ProductDaoImpl;
import com.cg.pms.exception.ProductException;

public class ProductServiceImpl implements ProductService {
	
	ProductDao pdao = new ProductDaoImpl();
	
	@Override
	public int addProduct(Product product) {
		return pdao.addProduct(product);
	}

	@Override
	public Product searchProduct(int productId) throws ProductException {
		return pdao.searchProduct(productId);
	}

	@Override
	public int deleteProduct(int productId) throws ProductException {
		return pdao.deleteProduct(productId);
	}

	@Override
	public List<Product> showAllProducts() throws ProductException {
		return pdao.showAllProduct();
	}

	@Override
	public int addOrder(Order order) {
		order.setAmount(order.getQuantity()*order.getProduct().getPrice());
		return pdao.addOrder(order);
	}

	@Override
	public boolean validateProduct(Product product) throws ProductException {
		if(product.getPrice()<=0){
			throw new ProductException("Product price should not be 0");
		}
		if(!Pattern.matches("[A-Z][a-z0-9]{3,15}",product.getProductName()))
			throw new ProductException("Product name should start with capital letter and name should be of minimum 4 characters");
		return true;
	}

	@Override
	public boolean validateOrder(Order order) throws ProductException {
		if(order.getQuantity()<=0){
			throw new ProductException("Order quantity should not be 0");
		}
		return false;
	}
	
}
