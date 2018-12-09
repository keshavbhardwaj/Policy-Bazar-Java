package com.beans;


import java.util.ArrayList;

public class Person 
{
	private String personId;
	private String personName;
	private Date dob;
	private String phoneNo;
	private float bankBalance;
	private int age;
	
	private ArrayList<Policy> currentPolicies;
	
	
	public Person() {
	
	}
	
	public Person(String personId, String personName, String dob, String phoneNo, float bankBalance, int age,
			ArrayList<Policy> currentPolicies) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.dob = new Date(dob);
		this.phoneNo = phoneNo;
		this.bankBalance = bankBalance;
		this.age = age;
		this.currentPolicies = currentPolicies;
	}
	
	

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public float getBankBalance() {
		return bankBalance;
	}

	public void setBankBalance(float bankBalance) {
		this.bankBalance = bankBalance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public ArrayList<Policy> getCurrentPolicies() {
		return currentPolicies;
	}

	public void setCurrentPolicies(ArrayList<Policy> currentPolicies) {
		this.currentPolicies = currentPolicies;
	}
	

	
	
	
}
