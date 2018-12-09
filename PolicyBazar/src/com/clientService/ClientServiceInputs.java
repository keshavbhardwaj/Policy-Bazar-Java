package com.clientService;

import java.util.ArrayList;
import java.util.Scanner;

import com.beans.CarInsuarance;
import com.beans.Date;
import com.beans.Policy;
import com.beans.Transaction;
import com.daoServices.CarInsuranceDaoService;
import com.daoServices.PolicyDaoService;

public class ClientServiceInputs {
	
	public static int joinPolicy()
	{
		System.out.println("Enter the respective policy number you wish join:");
		System.out.println("1. Automobile Insurance Policy");
		System.out.println("2. Exit");
		Scanner sc = new Scanner(System.in);
		int i =sc.nextInt();
		return i;
	}
	
	public static int choosePolicy()
	{
		int res=0;
		System.out.println("Enter the respective policy ID you wish join:");
		PolicyDaoService p1 = new PolicyDaoService();
		ArrayList<Policy> temp1 = p1.searchDataAll();
		for(Policy i:temp1)
		{
			System.out.println(i);
		}
		Scanner sc = new Scanner(System.in);
		res =sc.nextInt();
		return res;
	}
	
	
	public static CarInsuarance showALlPolicy(ArrayList<CarInsuarance> a)
	{
		System.out.println("\nYour current accuired policies are: \n");
		for(CarInsuarance  i: a)
		{
			System.out.println(i);
		}
		System.out.print("Enter the plate number: ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		CarInsuranceDaoService c1 = new CarInsuranceDaoService();
		return c1.searchData(id);
	}
	
	public static void claimOut()
	{
		System.out.println("\nChoose one of your policies to claim it: ");
	}
	
	public static void renewOut()
	{
		System.out.println("\nChoose one of your policies to renew it: ");
	}
	
	public static void showClaimMoney(float f)
	{
		System.out.println("\nCongatulations you will be getting "+f+" Rs with this claim\n");
	}
	
	public static void showClaimCompleted()
	{
		System.out.println("\nCongatulations Succesfully Claimed...\n and policy is dropped..\n Please join again if you wish to..");
	}
	
	public static Date getDate()
	{
		System.out.println("Enter todays Date as \"yyyy-mm-dd\"");
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		Date D1 = new Date(a);
		return D1;
	}
	
	public static void renewDone()
	{
		System.out.println("\nCongatulations you have Succesfully Renewed your policy\n");
	}
	
	public static void payPDone(float f)
	{
		System.out.println("\nYou have paid a premum of"+f+" Rs\n");
	}
	public static void doneDrop()
	{
		System.out.println("\nYou have Dropped the policy\n");
	}
	
	public static void printTransaction(Transaction T)
	{
		System.out.println(T);
	}
	
	public static int allPolicy(ArrayList<Policy> arr)
	{
		
		for(Policy i:arr)
		{
			System.out.println(i);
		}
		System.out.println("Enter the policy Id you wish to rate");
		Scanner sc = new Scanner(System.in);
		int id = sc.nextInt();
		return id;
	}
	
	public static int personService()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("1.Join new policy");
		System.out.println("2.Pay Policy Premium");
		System.out.println("3.Renew Existing policy");
		System.out.println("4.Drop a policy");
		System.out.println("5.Claim a policy");
		System.out.println("6.Rate a policy");
		System.out.println("7.Log out");
		int a = sc.nextInt();
		return a;
	}
	
	public static int adminService()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Policy Manager");
		System.out.println("1.Insert new policy");
		System.out.println("2.Update existing Policy Details");
		System.out.println("3.Delete Policy Details");
		System.out.println("4.Log out");
		int a = sc.nextInt();
		return a;
	}

}
