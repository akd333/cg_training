package com.capgemini.donorapplication.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.donorapplication.dao.DonorDaoImpl;
import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.donorapplication.util.DBConnection;

public class DBConnectionTest {
	static DonorDaoImpl daotest;
	static Connection dbCon;

	@BeforeClass
	public static void initialise() {
		daotest = new DonorDaoImpl();
		dbCon = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * 
	 * @throws DonorException
	 **/
	@Test
	public void test() throws DonorException {
		Connection dbCon = DBConnection.getInstance().getConnection();
		Assert.assertNotNull(dbCon);
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}
