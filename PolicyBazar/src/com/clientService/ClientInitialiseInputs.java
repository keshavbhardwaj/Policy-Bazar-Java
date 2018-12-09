package com.clientService;

import java.util.Scanner;

import com.daoServices.PolicyDaoService;

import com.beans.Automobile;
import com.beans.CarInsuarance;
import com.beans.Damage;
import com.beans.Date;
import com.beans.Person;
import com.beans.Policy;

public class ClientInitialiseInputs {
	
	
	public static void initialisePerson(Person tempObj)
	{
	Scanner sc=new Scanner(System.in);
	System.out.println("Enter the username");
	String personId=sc.next();
	tempObj.setPersonId(personId);
	
	System.out.println("Enter your name");
	String personName=sc.next();
	tempObj.setPersonName(personName);
	
		
	
	System.out.println("Enter your contact number");
	String phoneNo=sc.next();
	tempObj.setPhoneNo(phoneNo);
	
	
	System.out.println("Before providing any policy we need to know your bank balance..please enter your bank balance");
	float bankBalance=sc.nextFloat();
	tempObj.setBankBalance(bankBalance);
	
	System.out.println("Enter your current age");
	int age=sc.nextInt();
	tempObj.setAge(age);
	
	}
	
	
	
	public static void initialisePolicy(Policy tempObj)
	{
		Scanner sc=new Scanner(System.in);

		System.out.println("Enter policy Id");
		int policyId=sc.nextInt();
		tempObj.setPolicyId(policyId);
		
		System.out.println("Enter the type of policy");
		String policyDesc=sc.next();
		tempObj.setPolicyDesc(policyDesc);
		
		System.out.println("Enter the maturity period of policy");
		int P=sc.nextInt();
		tempObj.setPolicyPeriod(P);
		
		System.out.println("Enter the policy provider company");
		String providingCompany=sc.next();
		tempObj.setProvidingCompany(providingCompany);
		
		System.out.println("Enter the installments amount");
		float installments=sc.nextFloat();
		tempObj.setInstallments(installments);
		
		System.out.println("Enter the percentage of interest to be paid");
		float perInterest=sc.nextFloat();
		tempObj.setPerIntrest(perInterest);

		tempObj.setCustomerRating(0.0f);	
	}
	
	
	
	public static void initialiseAutomobile(Automobile tempObj)
	{
	
	}
	
	
	public static void initialiseCarInsuarance(CarInsuarance tempobj)
	{
		Scanner sc=new Scanner(System.in);
		String plate;
		String updatedDate,expiryDate,startDate;
		
		System.out.println("Enter plate number : ");
		plate=sc.next();
 		tempobj.setPlateNumber(plate);
 		
 		System.out.println("Enter Start Date : ");
 		startDate=sc.next();
 		tempobj.setStartDate(startDate);
 		
 		System.out.println("Enter Expiry Date : ");
 		expiryDate=sc.next();
 		tempobj.setExpiryDate(startDate);
 		
 		System.out.println("Enter updated Date : ");
 		updatedDate=sc.next();
 		tempobj.setUpdatedDate(updatedDate);
	}
	
	
	public static Policy findPolicy(PolicyDaoService pds)
	{
		
		Scanner sc=new Scanner(System.in);
		boolean check=true;
		Policy p=null;
		do 
		{
			System.out.println("Enter Policy id");
			int id=sc.nextInt();
			p=pds.searchData(id);
			if(p==null)
			{
				System.out.println("Policy not found please try again!");
				System.out.println("Do you want to search again?(y/n)");
				String s=sc.next();
				if(s!="y" || s!="Y" )
				{
					check=false;
				}
				
			}
			else
			{
				check=false;
			}
			
			
		}while(check);
		return p;
	}
	
	
	public static void initialiseDamage(Damage tempobj)
	{
		
		String dmgType;			//natural or by human
		 Date dmgDate;
		 int perDamage;			//% damage
		 float dmgCost;
		 
		Scanner sc = new Scanner(System.in); 
		 
		System.out.println("Enter Damage type : ");
 		dmgDate=new Date(sc.next());
 		tempobj.setDmgDate(dmgDate);
 		
 		System.out.println("Enter Damage Date : ");
 		dmgType=sc.next();
 		tempobj.setDmgType(dmgType);
 		
 		System.out.println("Enter percentage Damage : ");
 		perDamage=(int)sc.nextFloat();
 		tempobj.setPerDamage(perDamage);
 		
 		System.out.println("Enter Damage cost : ");
 		dmgCost=sc.nextFloat();
 		tempobj.setDmgCost(dmgCost);
	}
	
	public static float getRating()
	{
		float f = 0.0f;
		System.out.println("Enter your rating out of five");
		Scanner sc = new Scanner(System.in);
		int r = (int)sc.nextFloat();
		return (float)r;
	}

}
