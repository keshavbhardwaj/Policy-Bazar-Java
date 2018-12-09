package com.beans;


public class Policy
{
	@Override
	public String toString() {
		return "Policy [policyId=" + policyId + ", policyDesc=" + policyDesc + ", providingCompany=" + providingCompany
				+ ", policyPeriod=" + policyPeriod + ", perIntrest=" + perIntrest + ", customerRating=" + customerRating
				+ "]";
	}

	protected int policyId;
	protected String policyDesc;
	protected String providingCompany;
	protected int policyPeriod;

	protected float installments, perIntrest, maxAmount,customerRating;
	
	public Policy()
	{
		
	}
	
	public int getPolicyPeriod() {
		return policyPeriod;
	}

	public void setPolicyPeriod(int policyPeriod) {
		this.policyPeriod = policyPeriod;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyDesc() {
		return policyDesc;
	}

	public void setPolicyDesc(String policyDesc) {
		this.policyDesc = policyDesc;
	}

	public String getProvidingCompany() {
		return providingCompany;
	}

	public void setProvidingCompany(String providingCompany) {
		this.providingCompany = providingCompany;
	}

	public float getInstallments() {
		return installments;
	}

	public void setInstallments(float installments) {
		this.installments = installments;
	}

	public float getPerIntrest() {
		return perIntrest;
	}

	public void setPerIntrest(float perIntrest) {
		this.perIntrest = perIntrest;
	}

	public float getMaxAmount() {
		return maxAmount;
	}

	public void setMaxAmount(float maxAmount) {
		this.maxAmount = maxAmount;
	}

	public float getCustomerRating() {
		return customerRating;
	}

	public void setCustomerRating(float customerRating) {
		this.customerRating = customerRating;
	}

	public Policy(int policyId, String policyDesc, String providingCompany, int policyPeriod, float installments,
			float perIntrest, float maxAmount, float customerRating) {
		super();
		this.policyId = policyId;
		this.policyDesc = policyDesc;
		this.providingCompany = providingCompany;
		this.policyPeriod = policyPeriod;
		this.installments = installments;
		this.perIntrest = perIntrest;
		this.maxAmount = maxAmount;
		this.customerRating = customerRating;
	}

	
		
	
}
