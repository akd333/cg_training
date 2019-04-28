package com.capgemini.donorapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.dao.DonorDaoImpl;
import com.capgemini.donorapplication.dao.IDonorDAO;
import com.capgemini.donorapplication.exception.DonorException;

public class DonorServiceImpl implements IDonorService {
	
	IDonorDAO donorDao;
	
	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addDonorDetails
	 - Input Parameters	:	donor object
	 - Return Type		:	String id
	 - Throws			:  	DonorException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	11/11/2016
	 - Description		:	adding donor to database calls dao method addDonorDetails(donor)
	 ********************************************************************************************************/
	public String addDonorDetails(DonorBean donor) throws DonorException {
		donorDao=new DonorDaoImpl();	
		String donorSeq;
		donorSeq= donorDao.addDonorDetails(donor);
		return donorSeq; 
	}

	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	viewDonorDetails
	 - Input Parameters	:	String donorId
	 - Return Type		:	donor object
	 - Throws		    :  	DonorException
	 - Author		    :	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	calls dao method viewDonorDetails(donorId)
	 ********************************************************************************************************/
	public DonorBean viewDonorDetails(String donorId) throws DonorException {
		donorDao=new DonorDaoImpl();
		DonorBean bean=null;
		bean=donorDao.viewDonorDetails(donorId);
		return bean;
	}

	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	: retriveAll()
	 - Input Parameters	:	
	 - Return Type		: list
	 - Throws		    : DonorException
	 - Author	      	: CAPGEMINI 
	 - Creation Date	: 18/11/2016
	 - Description		: calls dao method retriveAllDetails()
	 ********************************************************************************************************/
	public List<DonorBean> retriveAll() throws DonorException {
		donorDao=new DonorDaoImpl();
		List<DonorBean> donorList=null;
		donorList=donorDao.retriveAllDetails();
		return donorList;
	}
	
	
	/*******************************************************************************************************
	 - Function Name	: validateDonor(DonorBean bean)
	 - Input Parameters	: DonorBean bean
	 - Return Type		: void
	 - Throws		    : DonorException
	 - Author	      	: CAPGEMINI
	 - Creation Date	: 18/11/2016
	 - Description		: validates the DonorBean object
	 ********************************************************************************************************/
	public void validateDonor(DonorBean bean) throws DonorException
	{
		List<String> validationErrors = new ArrayList<String>();

		//Validating donor name
		if(!(isValidName(bean.getDonorName()))) {
			validationErrors.add("\n Donar Name Should Be In Alphabets and minimum 3 characters long ! \n");
		}
		//Validating address
		if(!(isValidAddress(bean.getAddress()))){
			validationErrors.add("\n Address Should Be Greater Than 5 Characters \n");
		}
		//Validating Phone Number
		if(!(isValidPhoneNumber(bean.getPhoneNumber()))){
			validationErrors.add("\n Phone Number Should be in 10 digit \n");
		}
		//Validating Donation Amount
		if(!(isValidAmount(bean.getDonationAmount()))){
			validationErrors.add("\n Amount Should be a positive Number \n" );
		}
		
		if(!validationErrors.isEmpty())
			throw new DonorException(validationErrors +"");
	}

	public boolean isValidName(String donorName){
		Pattern namePattern=Pattern.compile("^[A-Za-z]{3,}$");
		Matcher nameMatcher=namePattern.matcher(donorName);
		return nameMatcher.matches();
	}
	public boolean isValidAddress(String address){
		return (address.length() > 5);
			
	}
	
	public boolean isValidPhoneNumber(String phoneNumber){
		Pattern phonePattern=Pattern.compile("^[1-9]{1}[0-9]{9}$");
		Matcher phoneMatcher=phonePattern.matcher(phoneNumber);
		return phoneMatcher.matches();
		
	}
	public boolean isValidAmount(double amount){
		return (amount>0);
	}
	public boolean validateDonorId(String donorId) {
		
		Pattern idPattern = Pattern.compile("[0-9]{1,4}");
		Matcher idMatcher = idPattern.matcher(donorId);
		
		if(idMatcher.matches())
			return true;
		else
			return false;		
	}
}

	
	


