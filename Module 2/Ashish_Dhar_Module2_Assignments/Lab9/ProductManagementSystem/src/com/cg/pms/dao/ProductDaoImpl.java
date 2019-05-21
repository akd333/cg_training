package com.cg.pms.dao;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import com.cg.pms.bean.Order;
import com.cg.pms.bean.Product;
import com.cg.pms.exception.ProductException;

public class ProductDaoImpl implements ProductDao {
	HashMap<Integer, Product> productMap =new HashMap<>();
	HashMap<Integer, Order> orderMap =new HashMap<>();
	
	@Override
	public int addProduct(Product product) {
		productMap.put(product.getProductId(), product);
		return product.getProductId();
	}			

	@Override
	public int deleteProduct(int productId) throws ProductException {
		searchProduct(productId);
		productMap.remove(productId);
		return productId;
	}

	@Override
	public Product searchProduct(int productId) throws ProductException {
		Product product = null;
		if(productMap.containsKey(productId)){
			product = productMap.get(productId);
		}else{
			throw new ProductException("No product found with this product id");
		}
		return product;
	}

	@Override
	public List<Product> showAllProduct() throws ProductException {
		List<Product> plist = new ArrayList<>();
		Set<Integer> keys = productMap.keySet();
		if(keys.size()==0){
			throw new ProductException("No product avaelable");
		}
		for(Integer k:keys)
			plist.add(productMap.get(k));
		return plist;
	}

	@Override
	public int addOrder(Order order) {
		orderMap.put(order.getOrderId(),order);
		return order.getOrderId();
	}

}
