package com.daoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Policy;
import com.interfaces.DaoInterface;
import com.provider.DaoProvider;

public class PolicyDaoService implements DaoInterface<Policy, Integer>{

Connection con;
	
	public PolicyDaoService()
	{
		con = DaoProvider.connection();
	}
	
	@Override
	public Policy insertData(Policy a) 
	{
		Policy tempResult = null;
		PreparedStatement pst;
		int result=0;
		try 
		{
			pst= con.prepareStatement("insert into Policy values(?,?,?,?,?,?,?)");
		
			pst.setInt(1,a.getPolicyId());
			pst.setString(2,a.getPolicyDesc());
			pst.setString(3,a.getProvidingCompany());
			pst.setInt(4,a.getPolicyPeriod());
			pst.setFloat(5,a.getInstallments());
			pst.setFloat(6,a.getPerIntrest());
			pst.setFloat(7,a.getMaxAmount());
			pst.setFloat(8,a.getCustomerRating());


			result = pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in loading Policy Data to data base");
		}
		else
		{
			tempResult = a;
		}
			
		
	
	return tempResult;
}

	@Override
	public Policy updateData(Policy a) 
	{
		
		
			Policy tempResult = null;
			tempResult = dropData(a);
			
			if(tempResult==null)
			{
				System.out.println("Failed in updating Policy Data in data base");
			}
			else 
			{
				tempResult = insertData(a);
				if(tempResult==null)
				{
					System.out.println("Failed in updating Policy Data in data base");
				}
				else
					tempResult = a;
			}
					
			return tempResult;
	}
	
		
		
	public ArrayList<Policy> searchDataAll() {
		ArrayList<Policy> tempResult = new ArrayList<Policy>();
		PreparedStatement pst;
		ResultSet result;
		try 
		{
			pst= con.prepareStatement("select * from policy ");
				
			result = pst.executeQuery();
		
		
		if(result.next())
		{
	
			tempResult.add(new Policy(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getFloat(5),result.getFloat(6),result.getFloat(7),result.getFloat(8)));

	
		}
		else
		{
			System.out.println("Failed in fetching Policy Data from data base");
		}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	
	return tempResult;
}	
		
	
	

	@Override
	public Policy searchData(Integer a) {
			Policy tempResult = null;
			PreparedStatement pst;
			ResultSet result;
			try 
			{
				pst= con.prepareStatement("select * from policy where policyId=?");
			
				pst.setInt(1,a);
				
				result = pst.executeQuery();
			
			
			if(result.next())
			{
		
				tempResult = new Policy(result.getInt(1),result.getString(2),result.getString(3),result.getInt(4),result.getFloat(5),result.getFloat(6),result.getFloat(7),result.getFloat(8));

		
			}
			else
			{
				System.out.println("Failed in fetching Policy Data from data base");
			}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		
		return tempResult;
	}

	@Override
	
		public Policy dropData(Policy a) {
			
		Policy tempResult = null;
			PreparedStatement pst;
			int result=0;
			try 
			{
				pst= con.prepareStatement("delete from policy where policyId=?");
			
				pst.setInt(1,a.getPolicyId());
				
				result = pst.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			if(result<1)
			{
				System.out.println("Failed in deleting policy Data from data base");
			}
			else
			{
				tempResult = a;
			}
			
			return tempResult;
		}

	}

	


