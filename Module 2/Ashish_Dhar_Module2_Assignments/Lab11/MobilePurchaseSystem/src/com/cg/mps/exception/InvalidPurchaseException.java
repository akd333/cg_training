/************************************************************************************
 -> File                 : InvalidPurchaseException.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : User defined exception for invalid purchase
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.exception;

public class InvalidPurchaseException extends Exception {

	public InvalidPurchaseException() {
		// TODO Auto-generated constructor stub
	}

	public InvalidPurchaseException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InvalidPurchaseException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidPurchaseException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidPurchaseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
