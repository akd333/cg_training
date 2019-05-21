/************************************************************************************
 -> File                 : EnquiryDaoImpl.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : DAO implementation implements EnquiryDao
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/

package com.cg.enquiry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;


import org.apache.log4j.PropertyConfigurator;

import com.cg.enquiry.bean.EnquiryBean;
import com.cg.enquiry.exception.EnquiryDBException;
import com.cg.enquiry.util.DBUtil;

public class EnquiryDaoImpl implements EnquiryDao {
	
	//Initializing apache logger
	Logger logger = Logger.getRootLogger();
	Connection conn = null;
	public EnquiryDaoImpl() {
		PropertyConfigurator.configure("resources/log4j.properties");
	}
	
	/***************************************************************************
	 -> Function Name	    :	generateEnquiryId()
	 -> Return Type		    :	String
	 -> Throws			    :  	EnquiryDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Generate enquiry id with sequence
	 ***************************************************************************/
	private String generateEnquiryId() throws EnquiryDBException{
		String eid = null;
		try {
			conn = DBUtil.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rst  = stmt.executeQuery(QueryMapper.ENQUIRYID_SEQUENCE_QUERY);
			while(rst.next()){
				eid = rst.getString(1);
			}

		} catch (SQLException e) {
			logger.error("Problem in generating enquiry id\n"+e.getMessage());
			throw new EnquiryDBException("Problem in generating enquiry id");
		}
		return eid;
		
	}

	/***************************************************************************
	 -> Function Name	    :	addEnquiry(EnquiryBean enquiry)
	 -> Return Type		    :	String
	 -> Throws			    :  	EnquiryDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Adds enquiry details
	 ***************************************************************************/
	@Override
	public String addEnquiry(EnquiryBean enquiry) throws EnquiryDBException {
		enquiry.setEnquiryId(generateEnquiryId());
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.ADD_ENQUERY_QUERY);
			pst.setString(1, enquiry.getEnquiryId());
			pst.setString(2, enquiry.getFirstName());
			pst.setString(3, enquiry.getLastName());
			pst.setString(4, enquiry.getContactNumber());
			pst.setString(5, enquiry.getDomain());
			pst.setString(6, enquiry.getLocation());
			pst.executeUpdate();
		} catch (SQLException e) {
			logger.error("Enquiry details insertion failed"+e.getMessage());
			throw new EnquiryDBException("Problem in adding enquiry details\n");
		}
		return enquiry.getEnquiryId();
	}
	
	/***************************************************************************
	 -> Function Name	    :	getEnquiryDetails(String enquiryId)
	 -> Return Type		    :	String
	 -> Throws			    :  	EnquiryDBException
	 -> Author			    :	Ashish Dhar
	 -> Creation Date	    :	02-May-2019
	 -> Description		    :	Gets enquiry details with by id
	 ***************************************************************************/
	@Override
	public EnquiryBean getEnquiryDetails(String enquiryId) throws EnquiryDBException {
		EnquiryBean enq = null;
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.GET_ENQUIRY_QUERY);
			pst.setString(1, enquiryId);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				enq = new EnquiryBean();
				enq.setEnquiryId(rst.getString("enqryid"));
				enq.setFirstName(rst.getString("firstname"));
				enq.setLastName(rst.getString("lastname"));
				enq.setContactNumber(rst.getString("contactno"));
				enq.setDomain(rst.getString("domain"));
				enq.setLocation(rst.getString("city"));
			}
		} catch (SQLException e) {
			logger.error("Problem in serching enquiry details\n"+ e.getMessage());
			throw new EnquiryDBException("Problem in searching enquiry details\n");
		}
		return enq;
	}

}
