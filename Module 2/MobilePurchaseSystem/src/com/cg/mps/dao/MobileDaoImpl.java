/************************************************************************************
 -> File                 : MobileDaoImpl.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : DAO implementation implements MobileDao
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/

package com.cg.mps.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.mps.bean.Mobile;
import com.cg.mps.bean.PurchaseMobile;
import com.cg.mps.exception.MobileDBException;
import com.cg.mps.util.DBUtil;

public class MobileDaoImpl implements MobileDao {

	Connection conn = null;

	//Initializing apache logger
	Logger logger = Logger.getRootLogger();

	/************************************
	 -> Calling MobileDaoImpl constructor
	 ************************************/
	public MobileDaoImpl() {
		PropertyConfigurator.configure("resources/log4j.properties");
	}

	/***************************************************************************
	 -> Function Name	    :	generateMobileId()
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Generate mobile id with sequence
	 ***************************************************************************/
	private String generateMobileId() throws MobileDBException{
		String mid = null;
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(QueryMapper.MOBILEID_SEQUENCE_QUERY);
			while(rst.next()){
				mid = rst.getString(1);
			}

		} catch (SQLException e) {
			logger.error("Problem in generating mobile id\n"+e.getMessage());
			throw new MobileDBException("Problem in generating mobile id");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				logger.error("Problem in closing db connection after generating mobile id\n"+e.getMessage());
				throw new MobileDBException("Error in closing db connection\n"+e.getMessage());

			}
		}*/
		return mid;
	}

	/***************************************************************************
	 -> Function Name	    :	addMobile(Mobile mobile)
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Adds new mobile details
	 ***************************************************************************/
	@Override
	public String addMobile(Mobile mobile) throws MobileDBException {
		mobile.setMobileId(generateMobileId());
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.INSERT_MOBILE_QUERY);
			pst.setString(1, mobile.getMobileId());
			pst.setString(2, mobile.getMobileName());
			pst.setString(3, mobile.getMobilePrice());
			pst.setString(4, mobile.getQuantity());
			pst.executeUpdate();
		} catch (SQLException e) {
			logger.error("Mobile details insertion failed"+e.getMessage());
			throw new MobileDBException("Problem in inserting product details\n");
		}/*finally{
			try{

				conn.close();
			}
			catch (SQLException e) {
				logger.error("Error in closing database connection after inserting mobile details\n"+e.getMessage());
				throw new MobileDBException("Error in closing db connection");

			}
		}*/
		return mobile.getMobileId();
	}


	/***************************************************************************
	 -> Function Name	    :	getAllMobiles()
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Fetch all mobiles
	 ***************************************************************************/
	@Override
	public List<Mobile> getAllMobiles() throws MobileDBException {
		List<Mobile> mobileList = new ArrayList<Mobile>();
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rst = stmt.executeQuery(QueryMapper.RETRIVE_ALL_MOBILES_QUERY);
			while (rst.next()) {
				Mobile mob = new Mobile();
				mob.setMobileId(rst.getString("mobileid"));
				mob.setMobileName(rst.getString("name"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity(rst.getString("quantity"));
				mobileList.add(mob);
			}
		} catch (SQLException e) {
			logger.error("Problem in getting mobile list\n"+e.getMessage());
			throw new MobileDBException("Problem in fetching mobile list");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				logger.error("Problem in closing db connection after fetching mobile list\n"+e.getMessage());
				throw new MobileDBException("Error in closing db connection"+e.getMessage());

			}
		}*/
		return mobileList;
	}

	/***************************************************************************
	 -> Function Name	    :	purchaseMobile(PurchaseMobile purchaseMobile)
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Purchase mobile
	 ***************************************************************************/
	@Override
	public String purchaseMobile(PurchaseMobile purchaseMobile) throws MobileDBException {
		purchaseMobile.setPurchaseId(generatePurchaseId());
		try {
			conn = DBUtil.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement purchasePst = conn.prepareStatement(QueryMapper.INSERT_PURCHASE_QUERY);
			purchasePst.setString(1, purchaseMobile.getPurchaseId());
			purchasePst.setString(2, purchaseMobile.getCustomerName());
			purchasePst.setString(3, purchaseMobile.getCustomerEmail());
			purchasePst.setString(4, purchaseMobile.getCustomerNumber());
			purchasePst.setString(5, purchaseMobile.getMobileId());
			purchasePst.executeQuery();
			
			PreparedStatement mobilePst = conn.prepareStatement(QueryMapper.MOBILE_UPDATE_QUERY);
			mobilePst.setString(1, purchaseMobile.getMobileId());
			mobilePst.executeQuery();
			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				logger.error("Problem in rolling back purchase details\n"+e1.getMessage());
				System.err.println("Problem in roleback");
			}
			logger.error("problem in placing order");
			throw new MobileDBException("Problem in placing order\n");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				logger.error("Problem in closing db connection\n"+e.getMessage());
				throw new MobileDBException("Error in closing db connection");

			}
		}*/
		return purchaseMobile.getPurchaseId();
	}

	/***************************************************************************
	 -> Function Name	    :	generatePurchaseId()
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Generate purchase id
	 ***************************************************************************/
	private String generatePurchaseId() throws MobileDBException{
		String pid = null;
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(QueryMapper.PURCHASEID_SEQUENCE_QUERY);
			while (rst.next()) {
				pid = rst.getString(1);
			}

		} catch (SQLException e) {
			logger.error("Problem in generating purchase id\n"+e.getMessage());
			throw new MobileDBException("Problem in generating purchase id\n");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				throw new MobileDBException("Error in closing db connection"+e.getMessage());

			}
		}*/
		return pid;
	}

	
	/***************************************************************************
	 -> Function Name	    :	deleteMobile(String mobileId)
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Delete a mobile
	 ***************************************************************************/
	@Override
	public String deleteMobile(String mobileId) throws MobileDBException {
		try{
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.MOBILE_DELETE_QUERY);
			pst.setString(1,mobileId);
			pst.executeUpdate();
		}catch(InputMismatchException e){
			logger.error("Problem deleting mobile"+ e.getMessage());
			System.out.println("Please enter a correct mobile id\n");
		}catch(SQLException e){
			logger.error("Problem deleting mobile"+ e.getMessage());
			System.out.println("Problem in deleting mobile\n");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				logger.error("Error in closing db connection "+e.getMessage());
				throw new MobileDBException("Error in closing db connection"+e.getMessage());

			}
		}*/
		return mobileId;
	}

	/***************************************************************************
	 -> Function Name	    :	searchMobileInPriceRange(Mobile mobile)
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Search mobile in price range
	 ***************************************************************************/
	@Override
	public List<Mobile> searchMobileInPriceRange(String startPrice, String endPrice) throws MobileDBException {
		List<Mobile> mlist = new ArrayList<Mobile>();
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.MOBILE_SEARCH_IN_PRICE_RANGE_QUERY);
			pst.setString(1, startPrice);
			pst.setString(2, endPrice);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Mobile mob =new Mobile();
				mob.setMobileId(rs.getString("mobileid"));
				mob.setMobileName(rs.getString("name"));
				mob.setMobilePrice(rs.getString("price"));
				mob.setQuantity(rs.getString("quantity"));
				mlist.add(mob);
			}
		} catch (SQLException e) {
			throw new MobileDBException("Error in geting mobile details in the given range\n");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				logger.error("Error in closing db connection "+e.getMessage());
				throw new MobileDBException("Error in closing db connection"+e.getMessage());

			}
		}*/
		return mlist;
	}

	/***************************************************************************
	 -> Function Name	    :	searchMobile(String mobileId)
	 -> Return Type		    :	String
	 -> Throws			    :  	MobileDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Search mobile with id
	 ***************************************************************************/
	@Override
	public Mobile searchMobile(String mobileId) throws MobileDBException {
		Mobile mob = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.MOBILE_SEARCH_QUERY);
			pst.setString(1, mobileId);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				mob = new Mobile();
				mob.setMobileId(rst.getString("mobileid"));
				mob.setMobileName(rst.getString("name"));
				mob.setMobilePrice(rst.getString("price"));
				mob.setQuantity(rst.getString("quantity"));
			}
		} catch (SQLException e) {
			logger.error("Problem in serching mobile\n"+ e.getMessage());
			throw new MobileDBException("Problem in searching mobile\n");
		}/*finally{
			try{
				conn.close();
			}
			catch (SQLException e) {
				logger.error("Error in closing db connection after searching mobile with id\n"+e.getMessage());
				throw new MobileDBException("Error in closing db connection"+e.getMessage());
			}
		}*/
		return mob;

	}

}
