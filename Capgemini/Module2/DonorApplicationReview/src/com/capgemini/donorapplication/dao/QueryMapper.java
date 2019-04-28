package com.capgemini.donorapplication.dao;

public interface QueryMapper {
	
	public static final String RETRIVE_ALL_QUERY="SELECT donor_name,address,phone_number,donor_date,donor_amount FROM donor_details";
	public static final String VIEW_DONAR_DETAILS_QUERY="SELECT donor_name,address,phone_number,donor_date,donor_amount FROM donor_details WHERE  donor_id=?";
	public static final String INSERT_QUERY="INSERT INTO donor_details VALUES(donorId_sequence.NEXTVAL,?,?,?,SYSDATE,?)";
	public static final String DONARID_QUERY_SEQUENCE="SELECT donorId_sequence.CURRVAL FROM DUAL";
	
	
}
