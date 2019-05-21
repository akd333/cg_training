/************************************************************************************
 -> File                 : DBUtilTest.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Testing methods of dbutil 
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/

package com.cg.mps.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;

import com.cg.mps.dao.MobileDaoImpl;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.util.DBUtil;

public class DBUtilTest {

	static MobileDaoImpl mdaoImpl;
	static Connection conn;
	@BeforeClass
	public static void initialise(){
		mdaoImpl = new MobileDaoImpl();
		conn = null;
	}
	
	
	@BeforeClass
	public static void beforeAllTest() throws MobileDBException{
		Connection conn = DBUtil.getConnection();
	}
	
	
	@AfterClass
	public static void afterAllTest() throws MobileDBException, SQLException{
		conn.close();
	}
	
	/************************************
	 * Test case for db connection
	 * @throws MobileDBException 
	 * 
	 ************************************/
	/*@Ignore
	@Test
	public DBUtilTest() throws MobileDBException {
		Connection conn = DBUtil.getConnection();
		Assert.assertNotNull(conn);
	}*/

}
