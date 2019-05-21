package com.cg.mra.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.mra.bean.AccountBean;
import com.cg.mra.exception.MobileRechargeException;
import com.cg.mra.util.DBUtil;

public class AccountDaoImpl implements AccountDao {

	Connection conn = null;
	@Override
	public AccountBean getAccountDetails(String accountId) throws MobileRechargeException {
		AccountBean accountBean = null;
		try {
			
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.GET_ACCOUNT_DETAILS);
			pst.setString(1, accountId);
			ResultSet rst = pst.executeQuery();
			if(rst.next()){
				accountBean = new AccountBean();
				accountBean.setAccountId(rst.getString("account_id"));
				accountBean.setAccountType(rst.getString("account_type"));
				accountBean.setCustomerName(rst.getString("customer_name"));
				accountBean.setAccountBalance(rst.getString("account_balance"));
			}
		} catch (SQLException e) {
			throw new MobileRechargeException("Problem in searching details\n"+e.getMessage());
		}
		return accountBean;
	}

	@Override
	public String rechargeAccount(String accountId, String rechargeAmount) throws MobileRechargeException {
		try {
			conn = DBUtil.getConnection();
			PreparedStatement pst = conn.prepareStatement(QueryMapper.RECHARGE_ACCOUNT);
			pst.setString(1, rechargeAmount);
			pst.setString(2, accountId);
			pst.executeUpdate();
		} catch (SQLException e) {
			throw new MobileRechargeException("Problem in inserting account details\n");
		}
		return rechargeAmount;
	}

}
