/************************************************************************************
 -> File                 : MobileServiceImpl.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : MobileServiceImpl implements mobile service
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.service;

import java.util.List;



import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.dao.MobileDao;
import com.cg.mps.dao.MobileDaoImpl;
import com.cg.mps.exception.InvalidMobileException;
import com.cg.mps.exception.InvalidPurchaseException;
import com.cg.mps.exception.MobileDBException;
public class MobileServiceImpl implements MobileService {
	
	//Initializing apache logger
	Logger logger = Logger.getRootLogger();
	
	
	public MobileServiceImpl() {
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	MobileDao mdao = new MobileDaoImpl();
	@Override
	public String addMobile(Mobile mobile) throws MobileDBException {
		return mdao.addMobile(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() throws MobileDBException {
		return mdao.getAllMobiles();
	}

	@Override
	public String purchaseMobile(PurchaseMobile mobileId) throws MobileDBException{
		return mdao.purchaseMobile(mobileId);
	}

	@Override
	public String deleteMobile(String mobileId) throws MobileDBException {
		return mdao.deleteMobile(mobileId);
	}

	@Override
	public List<Mobile> searchMobileInPriceRange(String startPrice, String endPrice) throws MobileDBException {
		return mdao.searchMobileInPriceRange(startPrice, endPrice);
	}

	@Override
	public Mobile searchMobile(String mobileId) throws MobileDBException {
		return mdao.searchMobile(mobileId);
	}

	@Override
	public boolean isValidMobile(Mobile mobile) throws InvalidMobileException {
		if(!mobile.getMobileName().matches("^[a-zA-Z0-9]{3,30}$")){
			logger.error("Mobile name is not correct");
			throw new InvalidMobileException("Mobile name should start with capital letter and it should be minimum of 3 letters");
		}
		if(!mobile.getMobilePrice().matches("^[1-9][0-9]+$")){
			logger.error("Price is not correct");
			throw new InvalidMobileException("Please enter a correct price...Price should minimum of 2 digit and not starts from 0");
		}if(!mobile.getQuantity().matches("^[1-9][0-9]{0,3}$")){
			logger.error("Quantity is not correct");
			throw new InvalidMobileException("Please enter a correct quantity...\n"
					+ "Quantity should minimum of 1 digit and not starts from 0 and maximum 1000 mobiles can be added");
		}if(Integer.parseInt(mobile.getQuantity())>1000){
			logger.equals("Invalid mobile quantity");
			throw new InvalidMobileException("Price should be maximum of 1000");
		}/*if(!mobile.getMobileId().matches("^[0-9]+$")){
			logger.equals("Invalid mobile id");
			throw new InvalidMobileException("Please enter a correct id");
		}*/
		
		return true;
	}

	@Override
	public boolean isValidPurchaseMobile(PurchaseMobile purchaseMobile) throws InvalidPurchaseException {
		if(!purchaseMobile.getCustomerName().matches("^[A-Z][a-z]{2,19}$")){
			logger.error("Invalid customer name");
			throw new InvalidPurchaseException("Please enter a correct name...Customer name should be os 3-20 characters");
		}if(!purchaseMobile.getCustomerEmail().matches("^[a-z0-9._%+-]+@[a-z0-9.-]+.[a-z]{2,4}$")){
			logger.error("invalid customer email id");
			throw new InvalidPurchaseException("Please enter a correct emailid");
		}
		if(!purchaseMobile.getCustomerNumber().matches("[6-9][0-9]{9}")){
			logger.error("Invalid customer mobile number");
			throw new InvalidPurchaseException("Please enter a correct phone number");
		}
		return true;
	}

}
