/************************************************************************************
 * File                 : MobileDao.java
 * Author Name          : Ashish Dhar
 * Desc                 : DAO interface for defining methods
 * Version              : 1.0
 * Last Modified Date   : 26-Apr-2019
 ************************************************************************************/
package com.cg.mps.dao;

import java.util.List;


import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.MobileDBException;

public interface MobileDao {
	
	long addMobile(Mobile mobile) throws MobileDBException;
	List<Mobile> getAllMobiles() throws MobileDBException;
	long purchaseMobile(PurchaseMobile purchaseMobile) throws MobileDBException;
	long deleteMobile(long mobileId) throws MobileDBException;
	Mobile searchMobileInPriceRange(Mobile mobile) throws MobileDBException;
	Mobile searchMobile(long mobileId) throws MobileDBException;
	
}
