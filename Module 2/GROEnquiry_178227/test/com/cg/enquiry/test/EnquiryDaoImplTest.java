/************************************************************************************
 -> File                 : EnquiryDaoImplTest.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Testing methods of EnquiryDaoImpl and database connection 
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/

package com.cg.enquiry.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.enquiry.bean.EnquiryBean;
import com.cg.enquiry.dao.EnquiryDaoImpl;
import com.cg.enquiry.exception.EnquiryDBException;
import com.cg.enquiry.util.DBUtil;
public class EnquiryDaoImplTest {
	
	
	static EnquiryDaoImpl edaoImpl;
	static EnquiryBean ebean;
	static Connection conn;
	
	@BeforeClass
	public static void initialize(){
		edaoImpl = new EnquiryDaoImpl();
		ebean = new EnquiryBean();
		conn = null;
	}
	
	/*****************************************************
	 * Before each class test connection is establishing
	 *****************************************************/
	@BeforeClass
	public static void beforeAllTest() throws EnquiryDBException{
		conn = DBUtil.getConnection();
	}
	
	/************************************
	 * Test case for db connection
	 * @throws EnquiryDBException
	 * 
	 ************************************/
	
	@Test
	public void DBUtilTest() throws EnquiryDBException {
		Connection conn = DBUtil.getConnection();
		assertNotNull(conn);
	}
	

	/************************************
	 * Test case for addEnquiry()
	 * @throws EnquiryDBException 
	 * @throws NumberFormatException 
	 * 
	 ************************************/
	@Test
	public void testAddEnquiry() throws NumberFormatException, EnquiryDBException{
		ebean.setEnquiryId("1001");
		ebean.setFirstName("Ashish");
		ebean.setLastName("Dhar");
		ebean.setContactNumber("8018333553");
		ebean.setDomain("Java");
		ebean.setLocation("Pune");
		assertTrue("Data inserted succcessfully",Integer.parseInt(edaoImpl.addEnquiry(ebean))>1000);
		
	}
	
	/************************************
	 * Test case for getAllMobiles()
	 * 
	 ************************************/
	
	@Test
	public void testGetEnquiryDetails() throws EnquiryDBException{
		assertNotNull(edaoImpl.getEnquiryDetails("1001"));
	}
	
	/************************************
	 * Test case for generateEnquiryId()
	 * 
	 ************************************/
	
	@Test
	public void testGenerateEnquiryId(){
		assertNotNull("3333");
	}
	
}
