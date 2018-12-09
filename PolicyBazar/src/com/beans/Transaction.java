package com.beans;

import com.beans.Date;


public class Transaction 
{
	private float credit, debit;
	private Date payDate;
	private String type,personId;
	
	public String getPersonId() {
		return personId;
	}
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public float getDebit() {
		return debit;
	}
	public void setDebit(float debit) {
		this.debit = debit;
	}
	public Date getPayDate() {
		return payDate;
	}
	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public Transaction(float credit, float debit, Date payDate, String type, String personId) {
		super();
		this.credit = credit;
		this.debit = debit;
		this.payDate = payDate;
		this.type = type;
		this.personId = personId;
	}
	@Override
	public String toString() {
		return "Transaction [credit=" + credit + ", debit=" + debit + ", payDate=" + payDate + ", type=" + type + "]";
	}
	
	
	

}
