/************************************************************************************
 -> File                 : MobileService.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Mobile service defines service methods
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.service;

import java.util.List;
import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.InvalidMobileException;
import com.cg.mps.exception.InvalidPurchaseException;
import com.cg.mps.exception.MobileDBException;

public interface MobileService {
	
	String addMobile(Mobile mobile) throws MobileDBException;
	List<Mobile> getAllMobiles() throws MobileDBException;
	String purchaseMobile(PurchaseMobile purchaseMobile) throws MobileDBException;
	String deleteMobile(String mobileId) throws MobileDBException;
	List<Mobile> searchMobileInPriceRange(String startPrice, String endPrice) throws MobileDBException;
	Mobile searchMobile(String mobileId) throws MobileDBException;
	boolean isValidPurchaseMobile(PurchaseMobile purchaseMobile) throws InvalidPurchaseException;
	boolean isValidMobile(Mobile mobile) throws InvalidMobileException;
	
}
