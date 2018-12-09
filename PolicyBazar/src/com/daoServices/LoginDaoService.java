package com.daoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.provider.DaoProvider;
import com.beans.LoginData;
import com.interfaces.DaoInterface;

public class LoginDaoService implements DaoInterface<LoginData ,String>
{

		Connection con;
		public LoginDaoService()
		{
			con=DaoProvider.connection();
			
			
		}
		public LoginData insertData(LoginData a)
		{
			LoginData tempResult=null;
			PreparedStatement pst;
			int result=0;
			
			try {

			pst = con.prepareStatement("insert into login values(?,?)");
			pst.setString(1, a.getUserName());
			pst.setString(2, a.getPassWord());
	
			result=pst.executeUpdate();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			if(result<1)
			{
				System.out.println("Failed in loading Login Data to data base");
			}
			else
			{
				tempResult = a;
			}
			
			return tempResult;
		}

		public LoginData updateData(LoginData a) {
			LoginData tempResult = null;
			tempResult = dropData(a);
			if(tempResult==null)
			{
				System.out.println("Failed in updating Login Data in data base");
			}
			else 
			{
				tempResult = insertData(a);
				if(tempResult==null)
				{
					System.out.println("Failed in updating Login Data in data base");
				}
				else
					tempResult = a;
			}
					
			return tempResult;
		}
		
		public LoginData searchData(String a) {
			LoginData tempResult = null;
			PreparedStatement pst;
			ResultSet result;
			try 
			{
				pst= con.prepareStatement("select * from login where userName=?");
			
				pst.setNString(1,(java.lang.String) a);
				
				result = pst.executeQuery();
			
				
				if(result.next())
				{
					
					tempResult = new LoginData(result.getString(1),result.getString(2));
				}
				else
				{
					System.out.println("Failed in deleting Login Data from data base");
				}
			
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			return tempResult;
		}

		public LoginData dropData(LoginData a)
		{
			
			LoginData tempResult = null;
			PreparedStatement pst;
			int result=0; 
			try 
			{
				pst=con.prepareStatement("delete from login where userName=?");
				pst.setString(1, a.getUserName());
				result = pst.executeUpdate();
			}
			catch(SQLException e) 
			{
				e.printStackTrace();
			}
			
	
			if(result<1)
			{
				System.out.println("Failed in deleting Login Data from data base");
			}
			else
			{
				tempResult = a;
			}
			
			return tempResult;
		}
	


}
