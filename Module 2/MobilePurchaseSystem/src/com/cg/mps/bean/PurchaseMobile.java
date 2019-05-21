/************************************************************************************
 -> File                 : PurchaseMobile.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Create the entities for PurchaseMobile class
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.bean;

public class PurchaseMobile {
	private String purchaseId;
	private String mobileId;
	private String customerName;
	private String customerNumber;
	private String customerEmail;
	
	/******************************************
	 -> Blank constructor initialized
	 ******************************************/
	public PurchaseMobile() {
		
	}
	
	/******************************************
	 -> Parameterized constructor initialized
	 ******************************************/
	public PurchaseMobile(String purchaseId, String mobileId, String customerName,
			String customerNumber, String customerEmail) {
		super();
		this.purchaseId = purchaseId;
		this.mobileId = mobileId;
		this.customerName = customerName;
		this.customerNumber = customerNumber;
		this.customerEmail = customerEmail;
	}

	/******************************************
	 -> Generating getters and setters
	 ******************************************/
	public String getPurchaseId() {
		return purchaseId;
	}

	public void setPurchaseId(String purchaseId) {
		this.purchaseId = purchaseId;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
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

	
	/******************************************
	 -> Generating toString method
	 ******************************************/
	@Override
	public String toString() {
		return "PurchaseMobile [purchaseId=" + purchaseId + ", mobileId="
				+ mobileId + ", customerName=" + customerName
				+ ", customerNumber=" + customerNumber + ", customerEmail="
				+ customerEmail + "]";
	}
	
		
}
