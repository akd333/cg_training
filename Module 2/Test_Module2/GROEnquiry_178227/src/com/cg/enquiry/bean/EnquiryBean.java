/************************************************************************************
 -> File                 : EnquiryBean.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Create the entities for EnquiryBean class
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.bean;

public class EnquiryBean {

	private String enquiryId;
	private String firstName;
	private String lastName;
	private String contactNumber;
	private String domain;
	private String location;

	/******************************************
	 -> Default constructor initialized
	 ******************************************/
	public EnquiryBean() {

	}

	/******************************************
	 -> Parameterized constructor initialized
	 ******************************************/
	public EnquiryBean(String enquiryId, String firstName, String lastName,
			String contactNumber, String domain, String location) {
		super();
		this.enquiryId = enquiryId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNumber = contactNumber;
		this.domain = domain;
		this.location = location;
	}

	/******************************************
	 -> Generating getters and setters
	 ******************************************/
	public String getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(String enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}




	/******************************************
	 -> Generating toString method
	 ******************************************/
	@Override
	public String toString() {
		return "EnquiryBean [enquiryId=" + enquiryId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", contactNumber="
				+ contactNumber + ", domain=" + domain + ", location="
				+ location + "]";
	}

}
