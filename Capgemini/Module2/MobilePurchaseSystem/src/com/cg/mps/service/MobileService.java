package com.cg.mps.service;

import java.util.List;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.MobileDBException;

public interface MobileService {
	
	long addMobile(Mobile mobile) throws MobileDBException;
	List<Mobile> getAllMobiles() throws MobileDBException;
	long purchaseMobile(PurchaseMobile purchaseMobile) throws MobileDBException;
	long deleteMobile(long mobileId) throws MobileDBException;
	Mobile searchMobileInPriceRange(Mobile mobile) throws MobileDBException;
	Mobile searchMobile(long mobileId) throws MobileDBException;

}
