package com.beans;

public class Automobile 
{
	private int modelNo;
	private String modelName, plateNumber;
	private Date purchaseDate;
	private int personId;
	
	
	public Automobile() {
		
	}
	
	
	public Automobile(int modelNo, String modelName, String plateNumber, String purchaseDate, int personId) {
		super();
		this.modelNo = modelNo;
		this.modelName = modelName;
		this.plateNumber = plateNumber;
		this.purchaseDate = new Date(purchaseDate);
		this.personId = personId;
	}
	
	
	public int getModelNo() {
		return modelNo;
	}
	public void setModelNo(int modelNo) {
		this.modelNo = modelNo;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}	

}
