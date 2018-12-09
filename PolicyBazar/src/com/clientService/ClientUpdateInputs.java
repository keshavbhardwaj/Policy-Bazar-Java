package com.clientService;

import java.util.Scanner;

import com.beans.Policy;

public class ClientUpdateInputs {
	
	public static void updatePolicyData(Policy p)
	{
		int choice;
		Scanner sc=new Scanner(System.in);
		do 
		{
			System.out.println("Enter details to be updated");
			System.out.println("1.Policy installments");
			System.out.println("2.Policy Interest Rate");
			System.out.println("3.Done Updating!!");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Previous installments:"+p.getInstallments());
				System.out.println("Enter new installments");
				float installments=sc.nextFloat();
				p.setInstallments(installments);
				break;
			
			case 2:
				System.out.println("Previous Interest Rate:"+p.getPerIntrest());
				System.out.println("Enter new Interest Rate");
				float interestRate=sc.nextFloat();
				p.setPerIntrest(interestRate);
				break;
			case 3:
				return ;
			default:
				break;
			}
			
		}while(choice!=3);
		
		
	}

}
