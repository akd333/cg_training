/************************************************************************************
 * File                 : PurchaseMobile.java
 * Author Name          : Ashish Dhar
 * Desc                 : Create the entities for PurchaseMobile class
 * Version              : 1.0
 * Last Modified Date   : 26-Apr-2019
 ************************************************************************************/

package com.cg.mps.bean;

public class PurchaseMobile {
	private long purchaseId;
	private long mobileId;
	private String customerName;
	private String customerNumber;
	private String customerEmail;
	static long generator = 0;
	
	// Blank constructor initialized
	public PurchaseMobile() {
		purchaseId = ++generator;
	}
	
	// Parameterized constructor initialized
	public PurchaseMobile(long purchaseId, long mobileId, String customerName,
			String customerNumber, String customerEmail) {
		super();
		purchaseId = ++generator;
		this.purchaseId = purchaseId;
		this.mobileId = mobileId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerEmail = customerEmail;
	}

	//Generating getters and setters

	public long getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(long purchaseId) {
		this.purchaseId = purchaseId;
	}

	public long getMobileId() {
		return mobileId;
	}

	public void setMobileId(long mobileId) {
		this.mobileId = mobileId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	

	public static long getGenerator() {
		return generator;
	}

	public static void setGenerator(int generator) {
		PurchaseMobile.generator = generator;
	}
	
	//Generating toString method
	@Override
	public String toString() {
		return "PurchaseMobile [purchaseId=" + purchaseId + ", mobileId="
				+ mobileId + ", customerName=" + customerName
				+ ", customerNumber=" + customerNumber + ", customerEmail="
				+ customerEmail + "]";
	}
	
		
}
