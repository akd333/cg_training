package com.capgemini.donorapplication.bean;

import java.util.Date;


public class DonorBean 
{
	private String donorId;
	private String donorName;
	private String phoneNumber;
	private String address;
	private double donationAmount;
	private Date donationDate;
	
	public String getDonorId() {
		return donorId;
	}
	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}
	public String getDonorName() {
		return donorName;
	}
	public void setDonorName(String donorName) {
		this.donorName = donorName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(double donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Date getDonationDate() {
		return donationDate;
	}
	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append("Printing Donor Details \n");
		sb.append("Donor Name: " +donorName +"\n");
		sb.append("Donor Address: "+ address +"\n");
		sb.append("Phone Number: "+ phoneNumber +"\n");
		sb.append("Donation Amount: "+ donationAmount +"\n");
		sb.append("Donation Date: "+ donationDate);
		return sb.toString();
	}
	

	
}
