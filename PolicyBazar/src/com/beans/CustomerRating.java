package com.beans;

public class CustomerRating {
	
	private String comment;
	private float rating;  // out of five
	private int policyId;
	
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getPolicyId() {
		return policyId;
	}
	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}
	
	
	public CustomerRating(String comment, float rating, int policyId) {
		super();
		this.comment = comment;
		this.rating = rating;
		this.policyId = policyId;
	}
	
	
	
	
}
