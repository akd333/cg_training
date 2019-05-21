package com.cg.mra.dao;

import com.cg.mra.bean.AccountBean;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountDao {
	public AccountBean getAccountDetails(String accountId) throws MobileRechargeException;
	public String rechargeAccount(String accountId,String rechargeAmount) throws MobileRechargeException;
}
