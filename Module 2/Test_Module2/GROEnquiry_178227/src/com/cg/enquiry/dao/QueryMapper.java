/************************************************************************************
 -> File                 : QueryMapper.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Interface for defining queries
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.enquiry.dao;

public interface QueryMapper {
	public static final String GET_ENQUIRY_QUERY="SELECT enqryid,firstname,lastname,contactno,domain,city FROM enquiry WHERE enqryid=?";
	public static final String ADD_ENQUERY_QUERY="INSERT INTO enquiry VALUES(?,?,?,?,?,?)";
	public static final String ENQUIRYID_SEQUENCE_QUERY="SELECT enquiries.NEXTVAL FROM DUAL";

}
