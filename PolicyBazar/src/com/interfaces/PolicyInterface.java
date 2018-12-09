package com.interfaces;

public interface PolicyInterface {
	
	public void renewPolicy(String personId);
	public void payPremium(String personId);
	public void getTransactionHistory(String personId);
	public void initiatePolicy();
	public void setPolicyId(int id);

}
