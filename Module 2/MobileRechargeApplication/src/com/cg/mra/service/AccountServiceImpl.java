package com.cg.mra.service;

import com.cg.mra.bean.AccountBean;
import com.cg.mra.dao.AccountDao;
import com.cg.mra.dao.AccountDaoImpl;
import com.cg.mra.exception.MobileRechargeException;

public class AccountServiceImpl implements AccountService {
	
	AccountDao accDao = new AccountDaoImpl();
	@Override
	public AccountBean getAccountDetails(String accountId) throws MobileRechargeException {
		return accDao.getAccountDetails(accountId);
	}

	@Override
	public String rechargeAccount(String accountId, String rechargeAmount) throws MobileRechargeException {
		return accDao.rechargeAccount(accountId, rechargeAmount);
	}

	@Override
	public boolean isValidRecharge() throws MobileRechargeException {
		return true;
	}

}
