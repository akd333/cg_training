package com.cg.mps.dao;

public class QueryMapper {
	public static final String RETRIVE_ALL_MOBILES_QUERY="SELECT mobileid,name,price,quantity FROM mobiles";
	public static final String VIEW_MOBILE_DETAILS_QUERY="SELECT mobileid,name,price,quantity FROM mobiles WHERE  mobileid=?";
	public static final String INSERT_MOBILE_QUERY="INSERT INTO mobiles VALUES(?,?,?,?)";
	public static final String INSERT_PURCHASE_QUERY = "INSERT INTO purchasedetails VALUES(?,?,?,?,SYSDATE,?)";
	public static final String MOBILEID_SEQUENCE_QUERY="SELECT mobileid_sequence.CURRVAL FROM DUAL";
	public static final String PURCHASEID_SEQUENCE_QUERY="SELECT purchaseid_sequence.CURRVAL FROM DUAL";
	public static final String MOBILE_UPDATE_QUERY="UPDATE mobiles SET quantity = quantity-1 WHERE mobileid=?";
	public static final String MOBILE_DELETE_QUERY="DELETE FROM mobiles WHERE mobileid=?";


}
