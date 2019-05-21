/************************************************************************************
 -> File                 : DBUtilTest.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Testing methods of MobileDao
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.dao;

import static org.junit.Assert.*;


import java.sql.Connection;

import junit.framework.Assert;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.util.DBUtil;

public class MobileDaoImplTest {

	static MobileDaoImpl mdaoImpl;
	static Mobile mobile;
	static PurchaseMobile purchase;
	static PurchaseMobile purchaseMobile;
	
	@BeforeClass
	public static void initialize(){
		//System.out.println("Before class");
		mdaoImpl = new MobileDaoImpl();
		mobile = new Mobile();
		purchase = new PurchaseMobile();
		purchaseMobile  = new PurchaseMobile(); 
	}
	
	

	
	/************************************
	 * Test case for addMobiles()
	 * @throws MobileDBException 
	 * @throws NumberFormatException 
	 * 
	 ************************************/
	@Test
	public void testAddMobile() throws NumberFormatException, MobileDBException{
		mobile.setMobileId("1044");
		mobile.setMobileName("Samsung");
		mobile.setMobilePrice("322323");
		mobile.setQuantity("22");
		assertTrue("Data inserted succcessfully",Integer.parseInt(mdaoImpl.addMobile(mobile))>1000);
		
	}
	
	/************************************
	 * Test case for getAllMobiles()
	 * 
	 ************************************/
	@Test
	public void testGetAllMobiles() throws MobileDBException{
		assertNotNull(mdaoImpl.getAllMobiles());
	}

	/************************************
	 * Test case for serchMobile()
	 * 
	 ************************************/
	@Test
	public void testSearchMobile() throws MobileDBException{
		assertNotNull(mdaoImpl.searchMobile("1088"));
	}
	
	/************************************
	 * Test case for generateMobileId()
	 * 
	 ************************************/
	@Test
	public void testGenerateMobileId(){
		assertNotNull("2000");
	}
	
	/************************************
	 * Test case for generatePurchaseId()
	 * 
	 ************************************/
	@Test
	public void testGeneratePurchaseId(){
		assertNotNull("2000");
	}
	
	/************************************
	 * Test case for DBUtilTest()
	 * 
	 ************************************/
	@Test
	public void DBUtilTest() throws MobileDBException {
		Connection conn = DBUtil.getConnection();
		Assert.assertNotNull(conn);
	}
	
}
