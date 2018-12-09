package com.beans;



public class CarInsuarance {
	
	private float insuarancePremium,perClaim;
	private String plateNumber;
	private int policyId;
	protected String updatedDate,expiryDate,startDate;
	
	public CarInsuarance() {
		super();
	}
	
	

	public CarInsuarance(float insuarancePremium, float perClaim, String plateNumber, int policyId, String updatedDate,
			String expiryDate, String startDate) {
		super();
		this.insuarancePremium = insuarancePremium;
		this.perClaim = perClaim;
		this.plateNumber = plateNumber;
		this.policyId = policyId;
		this.updatedDate = updatedDate;
		this.expiryDate = expiryDate;
		this.startDate = startDate;
	}



	public float getInsuarancePremium() {
		return insuarancePremium;
	}

	public void setInsuarancePremium(float insuarancePremium) {
		this.insuarancePremium = insuarancePremium;
	}

	public float getPerClaim() {
		return perClaim;
	}

	public void setPerClaim(float perClaim) {
		this.perClaim = perClaim;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}



	@Override
	public String toString() {
		return "CarInsuarance [plateNumber=" + plateNumber + ", policyId=" + policyId + ", updatedDate=" + updatedDate
				+ ", expiryDate=" + expiryDate + "]";
	}
	
	
	

}
