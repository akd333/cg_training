package com.cg.mra.bean;

public class AccountBean {
	private String accountId;
	private String accountType;
	private String customerName;
	private String accountBalance;

	public AccountBean() {
	
	}

	public AccountBean(String accountId, String accountType, String customerName, String accountBalance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "AccountBean [accountId=" + accountId + ", accountType=" + accountType + ", customerName=" + customerName
				+ ", accountBalance=" + accountBalance + "]";
	}
	

}
