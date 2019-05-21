package com.cg.pms.bean;

public class Product {
	private int productId;
	private String productName;
	private int price;
	static int generator = 0;
	public Product() {
		productId = ++generator;
	}
	public Product(String productName, int price) {
		productId = ++generator;
		this.productName = productName;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public static int getGenerator() {
		return generator;
	}
	public static void setGenerator(int generator) {
		Product.generator = generator;
	}
	
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", price=" + price + "]";
	}
	
	
}
