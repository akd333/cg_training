/************************************************************************************
 * File                 : InvalidEnquiryException.java
 * Author Name          : Ashish Dhar
 * Desc                 : User defined exception for invalid enquiry
 * Version              : 1.0
 * Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.exception;

public class InvalidEnquiryException extends Exception {

	public InvalidEnquiryException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidEnquiryException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidEnquiryException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidEnquiryException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidEnquiryException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
