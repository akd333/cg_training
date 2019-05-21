package com.cg.mra.service;

import com.cg.mra.bean.AccountBean;
import com.cg.mra.exception.MobileRechargeException;

public interface AccountService {
	public AccountBean getAccountDetails(String accountId) throws MobileRechargeException;
	public String rechargeAccount(String accountId,String rechargeAmount) throws MobileRechargeException;
	public boolean isValidRecharge() throws MobileRechargeException;
}
