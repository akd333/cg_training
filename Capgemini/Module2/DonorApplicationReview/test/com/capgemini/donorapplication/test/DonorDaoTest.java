package com.capgemini.donorapplication.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.dao.DonorDaoImpl;
import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.donorapplication.service.DonorServiceImpl;
import com.capgemini.donorapplication.service.IDonorService;

public class DonorDaoTest {

	static DonorDaoImpl dao;
	static DonorBean donor;

	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new DonorDaoImpl();
		donor = new DonorBean();
	}

	@Test
	public void testAddDonarDetails() throws DonorException {

		assertNotNull(dao.addDonorDetails(donor));

	}

	/************************************
	 * Test case for addDonarDetails()
	 * 
	 ************************************/

	@Ignore
	@Test
	public void testAddDonarDetails1() throws DonorException {
		// increment the number next time you test for positive test case
		assertEquals(1001, dao.addDonorDetails(donor));
	}

	/************************************
	 * Test case for addDonarDetails()
	 * 
	 ************************************/

	@Test
	public void testAddDonarDetails2() throws DonorException {

		donor.setDonorName("Shashwathi");
		donor.setPhoneNumber("9876543210");
		donor.setAddress("whitefield");
		donor.setDonationAmount(5000);
		assertTrue("Data Inserted successfully",
				Integer.parseInt(dao.addDonorDetails(donor)) > 1000);

	}

	/********************************************
	 * Test case for retriveAllDetails()
	 ************************************************/
	@Test
	public void testViewAll() throws DonorException {
		assertNotNull(dao.retriveAllDetails());
	}

	/****************************************************
	 * Test case for viewById()
	 ******************************************************/

	@Test
	public void testById() throws DonorException {
		assertNotNull(dao.viewDonorDetails("1010"));
	}

	@Ignore
	@Test
	public void testById1() throws DonorException {
		assertEquals("TestName", dao.viewDonorDetails("1010").getDonorName());
	}

}
