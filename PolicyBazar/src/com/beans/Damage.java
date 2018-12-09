package com.beans;

public class Damage
{
	private String dmgType;			//natural or by human
	private Date dmgDate;
	private int perDamage;			//% damage
	private float dmgCost;			//damage amount
	@Override
	public String toString() {
		return "Damage [dmgType=" + dmgType + ", dmgDate=" + dmgDate + ", perDamage=" + perDamage + ", dmgcost="
				+ dmgCost + "]";
	}
	
	
	public Damage(String dmgType, Date dmgDate, int perDamage, float dmgCost) {
		super();
		this.dmgType = dmgType;
		this.dmgDate = dmgDate;
		this.perDamage = perDamage;
		this.dmgCost = dmgCost;
	}
	
	public Damage()
	{
		
	}
	
	public String getDmgType() {
		return dmgType;
	}
	public void setDmgType(String dmgType) {
		this.dmgType = dmgType;
	}
	public Date getDmgDate() {
		return dmgDate;
	}
	public void setDmgDate(Date dmgDate) {
		this.dmgDate = dmgDate;
	}
	public int getPerDamage() {
		return perDamage;
	}
	public void setPerDamage(int perDamage) {
		this.perDamage = perDamage;
	}
	public float getDmgCost() {
		return dmgCost;
	}
	public void setDmgCost(float dmgCost) {
		this.dmgCost = dmgCost;
	}
	
	
	
	

}
