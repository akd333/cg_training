package com.capgemini.donorapplication.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.capgemini.donorapplication.bean.DonorBean;
import com.capgemini.donorapplication.exception.DonorException;
import com.capgemini.donorapplication.util.DBConnection;


public class DonorDaoImpl implements IDonorDAO 
{
	
	Logger logger=Logger.getRootLogger();
	public DonorDaoImpl()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	

	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	addDonorDetails(DonorBean donor)
	 - Input Parameters	:	DonorBean donor
	 - Return Type		:	String
	 - Throws			:  	DonorException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	Adding Donor
	 ********************************************************************************************************/

	public String addDonorDetails(DonorBean donor) throws DonorException 
	{
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		String donorId=null;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.INSERT_QUERY);

			preparedStatement.setString(1,donor.getDonorName());			
			preparedStatement.setString(2,donor.getAddress());
			preparedStatement.setString(3,donor.getPhoneNumber());
			preparedStatement.setDouble(4,donor.getDonationAmount());			
			
			queryResult=preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QueryMapper.DONARID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();

			if(resultSet.next())
			{
				donorId=resultSet.getString(1);
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new DonorException("Inserting donor details failed ");

			}
			else
			{
				logger.info("Donor details added successfully:");
				return donorId;
			}

		}
		catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			throw new DonorException("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				sqlException.printStackTrace();
				logger.error(sqlException.getMessage());
				throw new DonorException("Error in closing db connection");

			}
		}
		
		
	}

	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	viewDonorDetails(String donorId)
	 - Input Parameters	:	donorId
	 - Return Type		:	DonorBean
	 - Throws			:  	DonorException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	ViewDonorDetails
	 ********************************************************************************************************/
	public DonorBean viewDonorDetails(String donorId) throws DonorException {
		
		Connection connection=DBConnection.getInstance().getConnection();
		
		
		PreparedStatement preparedStatement=null;
		ResultSet resultset = null;
		DonorBean bean=null;
		
		try
		{
			preparedStatement=connection.prepareStatement(QueryMapper.VIEW_DONAR_DETAILS_QUERY);
			preparedStatement.setString(1,donorId);
			resultset=preparedStatement.executeQuery();
			
			if(resultset.next())
			{
				bean = new DonorBean();
				bean.setDonorName(resultset.getString(1));
				bean.setAddress(resultset.getString(2));
				bean.setPhoneNumber(resultset.getString(3));
				bean.setDonationDate(resultset.getDate(4));
				bean.setDonationAmount(resultset.getDouble(5));
				
			}
			
			if( bean != null)
			{
				logger.info("Record Found Successfully");
				return bean;
			}
			else
			{
				logger.info("Record Not Found Successfully");
				return null;
			}
			
		}
		catch(Exception e)
		{
			logger.error(e.getMessage());
			throw new DonorException(e.getMessage());
		}
		finally
		{
			try 
			{
				resultset.close();
				preparedStatement.close();
				connection.close();
			} 
			catch (SQLException e) 
			{
				logger.error(e.getMessage());
				throw new DonorException("Error in closing db connection");

			}
		}
		
	}

	//------------------------ 1. Donor Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	retriveAllDetails()
	 - Input Parameters	:	
	 - Return Type		:	List
	 - Throws		    :  	DonorException
	 - Author	     	:	CAPGEMINI
	 - Creation Date	:	18/11/2016
	 - Description		:	return list
	 ********************************************************************************************************/

	public List<DonorBean> retriveAllDetails() throws DonorException {
		
		Connection con=DBConnection.getInstance().getConnection();
		int donorCount = 0;
		
		PreparedStatement ps=null;
		ResultSet resultset = null;
		
		List<DonorBean> donorList=new ArrayList<DonorBean>();
		try
		{
			ps=con.prepareStatement(QueryMapper.RETRIVE_ALL_QUERY);
			resultset=ps.executeQuery();
			
			while(resultset.next())
			{	
				DonorBean bean=new DonorBean();
				bean.setDonorName(resultset.getString(1));
				bean.setAddress(resultset.getString(2));
				bean.setPhoneNumber(resultset.getString(3));
				bean.setDonationDate(resultset.getDate(4));
				bean.setDonationAmount(resultset.getDouble(5));
				donorList.add(bean);
				
				donorCount++;
			}			
			
		} catch (SQLException sqlException) {
			logger.error(sqlException.getMessage());
			throw new DonorException("Tehnical problem occured. Refer log");
		}
		
		finally
		{
			try 
			{
				resultset.close();
				ps.close();
				con.close();
			} 
			catch (SQLException e) 
			{
				logger.error(e.getMessage());
				throw new DonorException("Error in closing db connection");

			}
		}
		
		if( donorCount == 0)
			return null;
		else
			return donorList;
	}

}
