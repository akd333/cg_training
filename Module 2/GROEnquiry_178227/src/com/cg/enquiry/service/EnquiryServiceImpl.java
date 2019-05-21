/************************************************************************************
 -> File                 : EnquiryServiceImpl.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : EnquiryServiceImpl implements enquiry service
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.service;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.enquiry.bean.EnquiryBean;
import com.cg.enquiry.dao.EnquiryDao;
import com.cg.enquiry.dao.EnquiryDaoImpl;
import com.cg.enquiry.exception.EnquiryDBException;
import com.cg.enquiry.exception.InvalidEnquiryException;

public class EnquiryServiceImpl implements EnquiryService {
	
	//Initializing apache logger
	Logger logger = Logger.getRootLogger();
	EnquiryDao edao = new EnquiryDaoImpl();
	
	public EnquiryServiceImpl() {
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	@Override
	public String addEnquiry(EnquiryBean enquiry) throws EnquiryDBException {
		return edao.addEnquiry(enquiry);
	}

	@Override
	public EnquiryBean getEnquiryDetails(String enquiryId) throws EnquiryDBException {
		return edao.getEnquiryDetails(enquiryId);
	}
	
	/* Validating all user data */
	@Override
	public boolean isValidEnquiry(EnquiryBean enquiry) throws InvalidEnquiryException {
		if(!enquiry.getFirstName().matches("^[A-Z][a-z]{2,14}$")){
			logger.error("First name is not correct");
			throw new InvalidEnquiryException("Please enter a correct first name\n"
					+ "First name should start with capital letter and it should be of 3-15 letters");
		}if(!enquiry.getLastName().matches("^[A-Z][a-z]{2,14}$")){
			logger.error("Last name is not correct");
			throw new InvalidEnquiryException("Please enter a correct last name\n"
					+ "Last name should start with capital letter and it should be of 3-15 letters");
		}if(!enquiry.getContactNumber().matches("^[6-9][0-9]{9}$")){
			logger.error("Contact number is not correct");
			throw new InvalidEnquiryException("Please enter a correct contact number!!!\n "
					+ "Contact number should be of 10 digits and it should start from 6 onwards");
		}if(!enquiry.getDomain().matches("^[A-Z][a-z]{1,14}$")){
			logger.error("Domain is not correct");
			throw new InvalidEnquiryException("Please enter a correct domain name\n"
					+ "Domain name should start with capital letter and it should be of 2-15 letters");
		}if(!enquiry.getLocation().matches("^[A-Z][a-z]{2,14}$")){
			logger.error("Location is not correct");
			throw new InvalidEnquiryException("Please enter a correct location name\n"
					+ "Location name should start with capital letter and it should be minimum of 2-15 letters");
		}
		return true;
	}

}
