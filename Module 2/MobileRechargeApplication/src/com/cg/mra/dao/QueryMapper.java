package com.cg.mra.dao;

public interface QueryMapper {
	public static final String GET_ACCOUNT_DETAILS="SELECT account_id,account_type,customer_name,account_balance FROM account where account_id =?";
	public static final String RECHARGE_ACCOUNT="UPDATE account SET account_balance =account_balance + ? WHERE account_id = ?";

}
