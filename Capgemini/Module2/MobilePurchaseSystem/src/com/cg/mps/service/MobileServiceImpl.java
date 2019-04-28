package com.cg.mps.service;

import java.util.List;


import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.dao.MobileDao;
import com.cg.mps.dao.MobileDaoImpl;
import com.cg.mps.exception.InvalidMobileException;
import com.cg.mps.exception.InvalidPurchaseException;
import com.cg.mps.exception.MobileDBException;
public class MobileServiceImpl implements MobileService {
	
	MobileDao mdao = new MobileDaoImpl();
	@Override
	public long addMobile(Mobile mobile) throws MobileDBException {
		return mdao.addMobile(mobile);
	}

	@Override
	public List<Mobile> getAllMobiles() throws MobileDBException {
		return mdao.getAllMobiles();
	}

	@Override
	public long purchaseMobile(PurchaseMobile mobileId) throws MobileDBException {
		return mdao.purchaseMobile(mobileId);
	}

	@Override
	public long deleteMobile(long mobileId) throws MobileDBException {
		return mdao.deleteMobile(mobileId);
	}

	@Override
	public Mobile searchMobileInPriceRange(Mobile mobile) throws MobileDBException {
		return mdao.searchMobileInPriceRange(mobile);
	}

	@Override
	public Mobile searchMobile(long mobileId) throws MobileDBException {
		return mdao.searchMobile(mobileId);
	}

	
	public boolean validateMobile(Mobile mobile) throws InvalidMobileException {
		if(!mobile.getMobileName().matches("^[A-Z][a-z]{3,15}$")){
			throw new InvalidMobileException("Mobile name should start with capital letter and it should be minimum of 3 letters");
		}
		if(mobile.getMobilePrice().matches("^[1-9][0-9]+$")){
			throw new InvalidMobileException("Please enter a correct price");
		}
		return true;
	}

	
	public boolean validatePurchaseMobile(PurchaseMobile purchaseMobile) throws InvalidPurchaseException {
		if(!purchaseMobile.getCustomerName().matches("^[A-Z][a-z]{3,15}+$")){
			throw new InvalidPurchaseException("Invalid name");
		}
		if(!purchaseMobile.getCustomerNumber().matches("^[6-9][0-9]{9}+$")){
			throw new InvalidPurchaseException("Please enter a correct price");
		}
		return true;
	}

}
