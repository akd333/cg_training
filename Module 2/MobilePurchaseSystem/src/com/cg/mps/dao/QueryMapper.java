/************************************************************************************
 -> File                 : QueryMapper.java
 -> Author Name          : Ashish Dhar
 -> Desc                 : Interface for defining queries
 -> Version              : 1.0
 -> Last Modified Date   : 02-May-2019
 ************************************************************************************/
package com.cg.mps.dao;

public interface QueryMapper {
	public static final String RETRIVE_ALL_MOBILES_QUERY="SELECT mobileid,name,price,quantity FROM mobiles";
	public static final String VIEW_MOBILE_DETAILS_QUERY="SELECT mobileid,name,price,quantity FROM mobiles WHERE  mobileid=?";
	public static final String INSERT_MOBILE_QUERY="INSERT INTO mobiles VALUES(?,?,?,?)";
	public static final String INSERT_PURCHASE_QUERY = "INSERT INTO purchasedetails VALUES(?,?,?,?,SYSDATE,?)";
	public static final String MOBILEID_SEQUENCE_QUERY="SELECT mobileid_sequence.NEXTVAL FROM DUAL";
	public static final String PURCHASEID_SEQUENCE_QUERY="SELECT purchaseid_sequence.NEXTVAL FROM DUAL";
	public static final String MOBILE_UPDATE_QUERY="UPDATE mobiles SET quantity = quantity-1 WHERE mobileid=?";
	public static final String MOBILE_DELETE_QUERY="DELETE FROM mobiles WHERE mobileid=?";
	public static final String MOBILE_SEARCH_QUERY="SELECT mobileid,name,price,quantity FROM mobiles WHERE mobileid=?";
	public static final String MOBILE_SEARCH_IN_PRICE_RANGE_QUERY="SELECT mobileid,name,price,quantity FROM mobiles WHERE price BETWEEN ? AND ?";
	
}
