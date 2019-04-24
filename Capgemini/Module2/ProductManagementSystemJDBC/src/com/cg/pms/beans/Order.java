package com.cg.pms.beans;

import java.time.LocalDate;

public class Order {
	private long orderId;
	private long productId;
	private int quantity;
	private double totalAmount;
	private LocalDate orderDate;
	public Order() {
		
	}
	public Order(long orderId, long productId, int quantity,
			double totalAmount, LocalDate orderDate) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", totalAmount=" + totalAmount
				+ ", orderDate=" + orderDate + "]";
	}
	
}
