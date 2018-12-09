package com.businessServices;

import java.util.ArrayList;

import com.beans.Automobile;
import com.beans.CarInsuarance;
import com.beans.Damage;
import com.beans.Date;
import com.beans.Policy;
import com.beans.Transaction;
import com.interfaces.PolicyInterface;
import com.clientService.ClientInitialiseInputs;
import com.clientService.ClientServiceInputs;
import com.daoServices.CarInsuranceDaoService;
import com.daoServices.PolicyDaoService;
import com.daoServices.TransactionDaoService;

public class CarInsuarancePolicy implements PolicyInterface{
	
	Automobile car;
	CarInsuarance cins;
	int policyId;
	
	
	
	public CarInsuarancePolicy() {
		super();
		car = new Automobile();
		cins = new CarInsuarance();
	}
	
	public CarInsuarancePolicy(CarInsuarance cins) {
		super();
		car = new Automobile();
		this.cins = cins;
	}

	public void getPolicyDetails()
	{
		PolicyDaoService p1 = new PolicyDaoService();
		float insuarancePremium=p1.searchData(policyId).getInstallments();
		cins.setInsuarancePremium(insuarancePremium);
		
		
		float perClaim=p1.searchData(policyId).getPerIntrest();
		cins.setPerClaim(perClaim);
		ClientInitialiseInputs.initialiseCarInsuarance(cins);
	}
	
	public void getCarDetails()
	{
		ClientInitialiseInputs.initialiseAutomobile(car);
	}
	
	public void initiatePolicy()
	{
		this.getCarDetails();
		this.getPolicyDetails();
	}

	@Override
	public void renewPolicy(String personId) {
		
		CarInsuranceDaoService cids = new CarInsuranceDaoService();
		Date d = ClientServiceInputs.getDate();
		cins.setUpdatedDate(d.toString());
		
		Transaction T1 = new Transaction(0.0f,0.0f,d,"Renewing policy",personId);
		TransactionDaoService tds = new TransactionDaoService();
		tds.insertData(T1);
		
		PolicyDaoService p1 = new PolicyDaoService();
		Policy pol1 = p1.searchData(cins.getPolicyId());
		int months = pol1.getPolicyPeriod();
		if(months<=12)
		{
			months=d.getMm()+months;
			d.setMm(months);			
		}
		else
		{
			int year=months/12;
			int month =months%12;
			d.setMm(month);
			d.setYy(year);
		}
		cins.setExpiryDate(d.toString());
		cids.updateData(cins);
		ClientServiceInputs.renewDone();
		
	}

	@Override
	public void payPremium(String personId) {
		
		Date d = ClientServiceInputs.getDate();
		
		float f = cins.getInsuarancePremium();
		
		Transaction T1 = new Transaction(0.0f,f,d,"Paid Premium",personId);
		TransactionDaoService tds = new TransactionDaoService();
		tds.insertData(T1);
		ClientServiceInputs.payPDone(f);
		
	}

	@Override
	public void getTransactionHistory(String personId) {
		
		TransactionDaoService tds = new TransactionDaoService();
		ArrayList<Transaction> ar1 = tds.searchDataAll(personId);
		for(Transaction i:ar1)
		{
			ClientServiceInputs.printTransaction(i);
		}
		
	}
	
	public void drop()
	{
		CarInsuranceDaoService cids = new CarInsuranceDaoService();
		cids.dropData(cins);
		ClientServiceInputs.doneDrop();
	}

	public void claim(String personId)
	{
		Damage D1 = new Damage();
		DamageService.getData(D1);
		float f = D1.getDmgCost()*cins.getPerClaim();
		Date DateT = ClientServiceInputs.getDate();
		
		Transaction T1 = new Transaction(f,0.0f,DateT,"Claimed of Car Damage",personId);
		TransactionDaoService tds = new TransactionDaoService();
		tds.insertData(T1);
		
		ClientServiceInputs.showClaimMoney(f);
		CarInsuranceDaoService cids = new CarInsuranceDaoService();
		cids.dropData(cins);
		ClientServiceInputs.showClaimCompleted();
	}
	
	@Override
	public void setPolicyId(int id) {
		this.policyId = id;
		
	}

}
