package com.businessServices;


import java.util.ArrayList;
import java.util.Scanner;

import com.beans.CarInsuarance;
import com.beans.Person;
import com.beans.Policy;
import com.clientService.ClientInitialiseInputs;
import com.clientService.ClientServiceInputs;
import com.daoServices.CarInsuranceDaoService;
import com.daoServices.PolicyDaoService;
import com.interfaces.PolicyInterface;
import com.provider.ClientPolicyProvider;
import com.businessServices.CarInsuarancePolicy;


public class PersonService extends PersonAdminServiceSuperClass{
	
	Person thisPerson;

	
	public PersonService(Person p)
	{
		thisPerson = p;
	}
	
	public void joinPolicy()
	{
		int i = ClientServiceInputs.joinPolicy(); 
		PolicyInterface p1;
		switch(i)
		{
		case 1: p1 = (CarInsuarancePolicy)ClientPolicyProvider.policyObject("AutomobilePolicy");
				int policyId = ClientServiceInputs.choosePolicy();
				p1.setPolicyId(policyId);
				p1.initiatePolicy();
				break;
		case 2: return;
		}
		
	}
	
	
	public void payPremium()
	{
		CarInsuarance c1 = showAll();
		CarInsuarancePolicy cip = new CarInsuarancePolicy(c1);
		cip.drop();
	}
	
	
	public void renewPolicy()
	{
		ClientServiceInputs.renewOut();
		CarInsuarance c1 = showAll();
		CarInsuarancePolicy cip = new CarInsuarancePolicy(c1);
		cip.renewPolicy(thisPerson.getPersonId());
	}
	
	public void dropPolicy()
	{

		CarInsuarance c1 = showAll();
		CarInsuarancePolicy cip = new CarInsuarancePolicy(c1);
		cip.payPremium(thisPerson.getPersonId());
	}
	
	public void Rating()
	{
		PolicyDaoService pds = new PolicyDaoService();
		ArrayList<Policy> arr = pds.searchDataAll();
		int id = ClientServiceInputs.allPolicy(arr);
		float f = ClientInitialiseInputs.getRating();
		Policy P1 = pds.searchData(id);
		float res = P1.getCustomerRating();
		res = res+f;
		res /=2;
		P1.setCustomerRating(res);
	}
	
	public void claimPolicy()
	{
		ClientServiceInputs.claimOut();
		CarInsuarance c1 = showAll();
		CarInsuarancePolicy cip = new CarInsuarancePolicy(c1);
		cip.claim(thisPerson.getPersonId());
		
	}
	
	public CarInsuarance showAll()
	{
		CarInsuranceDaoService cids = new CarInsuranceDaoService();
		ArrayList<CarInsuarance> c1 = cids.searchDataByPerson(thisPerson.getPersonId());
		return ClientServiceInputs.showALlPolicy(c1);	 
	}

	@Override
	public void getServices() {
		
		
		int choice;
		
		do
		{
			
			choice=ClientServiceInputs.personService();
			switch (choice) 
			{
				case 1:
					joinPolicy();
					break;
				case 2:
					payPremium();
					break;
				case 3:
					renewPolicy();
					break;
				case 4:
					dropPolicy();
					break;
				case 5:
					claimPolicy();
					break;
				case 6:
					Rating();
					break;
				case 7:
					break;
				default:
					break;
			}
			
			
		}while(choice!=7);
		
		
	}
	
	
	
	
	
	
	
	

}