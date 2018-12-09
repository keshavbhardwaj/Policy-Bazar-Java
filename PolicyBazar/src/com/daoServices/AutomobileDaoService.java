package com.daoServices;

import java.sql.*;

import com.beans.Automobile;
import com.interfaces.DaoInterface;
import com.provider.DaoProvider;



public class AutomobileDaoService implements DaoInterface<Automobile,String>
{
	Connection con;
	
	public AutomobileDaoService()
	{
		con=DaoProvider.connection();
	}
	public Automobile insertData(Automobile a)
	{
		Automobile tempResult=null;
		PreparedStatement pst;
		int result=0;
		
		try 
		{
			pst= con.prepareStatement("insert into Automobile values(?,?,?,?,?)");
			pst.setInt(1, a.getModelNo());
			pst.setString(2, a.getModelName());
			pst.setString(3, a.getPlateNumber());
			pst.setString(4,a.getPurchaseDate().toString());
			pst.setInt(5, a.getPersonId());
			
			result=pst.executeUpdate();			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in loading Automobile Data to data base");
		}
		else
		{
			tempResult = a;
		}
		
		return tempResult;
	}
	
	public Automobile updateData(Automobile a)
	{
		Automobile tempResult = null;
		
		tempResult = dropData(a);
		if(tempResult==null)
		{
			System.out.println("Failed in updating Automobile Data in data base");
		}
		else 
		{
			tempResult = insertData(a);
			if(tempResult==null)
			{
				System.out.println("Failed in updating Automobile Data in data base");
			}
			else
				tempResult = a;
		}
				
		return tempResult;
	}
	
	
	public Automobile searchData(String a)
	{
		Automobile tempResult = null;
		PreparedStatement pst;
		ResultSet result;
		
		try
		{
				pst= con.prepareStatement("select * from automobile where plateNumber=?");
			
				pst.setString(1,a);
				
				result = pst.executeQuery();
				
				if(result.next())
				{
					
					tempResult = new Automobile(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getInt(5));
				}
				else
				{
					System.out.println("Failed in deleting Persons Data from data base");
				}
				
				
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tempResult;
	}
	
	public Automobile dropData(Automobile a)
	{
		Automobile tempResult = null;
		PreparedStatement pst;
		int result=0;
		
		try 
		{
			pst= con.prepareStatement("delete from automobile where plateNumber=?");
		
			pst.setString(1,a.getPlateNumber());
			
			result = pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in deleting Persons Data from data base");
		}
		else
		{
			tempResult = a;
		}
		
		return tempResult;
	}
}