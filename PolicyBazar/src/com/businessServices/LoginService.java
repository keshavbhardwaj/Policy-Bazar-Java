package com.businessServices;

//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.util.Scanner;

import com.beans.LoginData;
import com.beans.Person;
import com.daoServices.LoginDaoService;
import com.daoServices.PersonDaoService;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;

public class LoginService 
{
    	public static PersonAdminServiceSuperClass login()
    	{
         
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter User Name");

    	String UserName = sc.nextLine();
    	System.out.println("Enter PassWord");
    	String PassWord = sc.nextLine();

    	String checkPass = getPass(UserName);
    	if(checkPass.equals(PassWord))
    	{
    		if(UserName.equals("root"))
    			return new PolicySoftwareAdminServices();
    		PersonDaoService p1 = new PersonDaoService();
    		Person p2 = p1.searchData(UserName);
    		return new PersonService(p2);
    	}
    	else
    	{
    		System.out.println("Invalid Username or Password. !");
    		return login();
    	}
   	
    	}
    	
	public static String getPass(String userName)
     {
		 String passWord = null;
		 
		 if(userName.equals("root"))
			 return "root";
		 
		 LoginDaoService l1 = new LoginDaoService();
		 LoginData l2 = l1.searchData(userName);
		 if(l2!=null)
		 passWord = l2.getPassWord(); //will be obtained by JDBC
    	 return passWord;    	 
    	 
     }
	  
	
}
