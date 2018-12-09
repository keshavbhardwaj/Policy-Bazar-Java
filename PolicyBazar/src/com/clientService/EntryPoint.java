package com.clientService;

import java.util.Scanner;

import com.businessServices.LoginService;
import com.businessServices.PersonAdminServiceSuperClass;
import com.businessServices.PersonService;

public class EntryPoint {
	
	
	public static PersonAdminServiceSuperClass firstScreen()
	{
		PersonAdminServiceSuperClass ps1 = null;
		int ch;
		//Link1:
		do {
		System.out.println("**** Menu ****");
		System.out.println("1.Create new account");
		System.out.println("2.Login");
		System.out.print("3.Exit\n\nEnter your choice number:");
		Scanner sc = new Scanner(System.in);
		ch = sc.nextInt();
		switch(ch)
		{
		case 1:
			break;
		case 2: ps1 = LoginService.login();
			break;
		case 3:
			break;
		default:System.out.println("Invalid Input");
				//goto Link1;
		
		}
		}while(ch!=1 && ch!=2);
		
		return ps1;
		
	}

	public static void main(String[] args) {
		
		
		PersonAdminServiceSuperClass ps1 = firstScreen();
		if(ps1!=null)
		{
			
		}
		ps1.getServices();
		

	}

}
