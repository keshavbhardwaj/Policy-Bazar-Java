package com.daoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.beans.Person;
import com.beans.Policy;
import com.interfaces.DaoInterface;
import com.provider.DaoProvider;

public class PersonDaoService implements DaoInterface<Person, String>{
	
	Connection con;
	
	public PersonDaoService()
	{
		con = DaoProvider.connection();
	}

	@Override
	public Person insertData(Person a) {
		
		Person tempResult = null;
		ArrayList<Policy> temp = a.getCurrentPolicies();
		StringBuffer s1 = new StringBuffer("");
		for(Policy i: temp)
		{
			s1.append(Integer.toString(i.getPolicyId()));
		}
		String policyList = s1.toString();
		PreparedStatement pst;
		int result=0;
		try 
		{
			pst= con.prepareStatement("insert into person values(?,?,?,?,?,?,?)");
		
			pst.setString(1,a.getPersonId());
			pst.setString(2, a.getPersonName());
			pst.setString(3, a.getDob().toString());
			pst.setString(4, a.getPhoneNo());
			pst.setFloat(5, a.getBankBalance());
			pst.setInt(6, a.getAge());
			pst.setString(7,policyList);
			

			result = pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in loading Persons Data to data base");
		}
		else
		{
			tempResult = a;
		}
		
		return tempResult;
	}

	@Override
	public Person updateData(Person a) {
		Person tempResult = null;
		tempResult = dropData(a);
		if(tempResult==null)
		{
			System.out.println("Failed in updating Persons Data in data base");
		}
		else 
		{
			tempResult = insertData(a);
			if(tempResult==null)
			{
				System.out.println("Failed in updating Persons Data in data base");
			}
			else
				tempResult = a;
		}
				
		return tempResult;
	}

	@Override
	public Person searchData(String a) {
		Person tempResult = null;
		PreparedStatement pst;
		ResultSet result;
		try 
		{
			pst= con.prepareStatement("select * from person where personId=?");
		
			pst.setString(1,a);
			
			result = pst.executeQuery();
		
		
		if(result.next())
		{
			
			ArrayList<Policy> tempPolicyList = new ArrayList<Policy>();
			StringTokenizer policyId = new StringTokenizer(result.getString(7),",",false);
			PolicyDaoService tempPolicy = new PolicyDaoService();
			for(int i=0;i<policyId.countTokens();i++)
			{
				tempPolicyList.add(tempPolicy.searchData(Integer.parseInt(policyId.nextToken())));
			}
			tempResult = new Person(result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getFloat(5),result.getInt(6),tempPolicyList);
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

	@Override
	public Person dropData(Person a) {
		
		Person tempResult = null;
		PreparedStatement pst;
		int result=0;
		try 
		{
			pst= con.prepareStatement("delete from person where personId=?");
		
			pst.setString(1,a.getPersonId());
			
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
