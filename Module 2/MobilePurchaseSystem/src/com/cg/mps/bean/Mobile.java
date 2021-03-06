/************************************************************************************
 -> File                 : Mobile.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Create the entities for Mobile class
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/

package com.cg.mps.bean;

public class Mobile {
	
	private String mobileId;
	private String mobileName;
	private String mobilePrice;
	private String quantity;
	
	/******************************************
	 -> Default constructor initialized
	 ******************************************/
	public Mobile() {
		
	}
	
	/******************************************
	 -> Parameterized constructor initialized
	 ******************************************/
	public Mobile(String mobileId, String mobileName, String mobilePrice, String quantity) {
		super();
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.mobilePrice = mobilePrice;
		this.quantity = quantity;
	}
	
	
	/******************************************
	 -> Generating getters and setters
	 ******************************************/
	
	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public String getMobilePrice() {
		return mobilePrice;
	}

	public void setMobilePrice(String mobilePrice) {
		this.mobilePrice = mobilePrice;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	/******************************************
	 -> Generating toString method
	 ******************************************/
	@Override
	public String toString() {
		return "Mobile [mobileId=" + mobileId + ", mobileName=" + mobileName
				+ ", mobilePrice=" + mobilePrice + ", quantity=" + quantity
				+ "]";
	}
	
	
}
