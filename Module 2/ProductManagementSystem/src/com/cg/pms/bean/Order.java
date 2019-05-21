package com.cg.pms.bean;

public class Order {
	private int orderId;
	private Product product;
	private int quantity;
	private int amount;
	static int generator = 0;
	
	public Order(){
		orderId = ++generator;
	}
	
	public Order(Product product, int quantity, int amount) {
		orderId = ++generator;
		this.product = product;
		this.quantity = quantity;
		this.amount = amount;
	}



	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public static int getGenerator() {
		return generator;
	}

	public static void setGenerator(int generator) {
		Order.generator = generator;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", product=" + product
				+ ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	
}
