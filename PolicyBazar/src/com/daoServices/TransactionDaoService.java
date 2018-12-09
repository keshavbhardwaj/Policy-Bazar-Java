package com.daoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.Date;
import com.beans.Transaction;
import com.interfaces.DaoInterface;
import com.provider.DaoProvider;

public class TransactionDaoService implements DaoInterface<Transaction, String>{
	
	
	Connection con;
	public TransactionDaoService()
	{
		con=DaoProvider.connection();
		
		
	}

	@Override
	public Transaction insertData(Transaction a) {
		Transaction tempResult=null;
		PreparedStatement pst;
		int result=0;
		
		try {

		pst = con.prepareStatement("insert into transaction values(?,?,?,?,?)");
		pst.setFloat(1, a.getCredit());
		pst.setFloat(2, a.getDebit());
		pst.setString(3, a.getPayDate().toString());
		pst.setString(4, a.getType());
		pst.setString(5, a.getPersonId());
		

		result=pst.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in loading transaction Data to data base");
		}
		else
		{
			tempResult = a;
		}
		
		return tempResult;
	}

	@Override
	public Transaction updateData(Transaction a) {
		Transaction tempResult = null;
		tempResult = dropData(a);
		if(tempResult==null)
		{
			System.out.println("Failed in updating transaction Data in data base");
		}
		else 
		{
			tempResult = insertData(a);
			if(tempResult==null)
			{
				System.out.println("Failed in updating transaction Data in data base");
			}
			else
				tempResult = a;
		}
				
		return tempResult;
	}

	@Override
	public Transaction searchData(String a) 
	{
		return null;
	}
	
	public ArrayList<Transaction> searchDataAll(String a) {
		ArrayList<Transaction> tempResult = new ArrayList<Transaction>();
		PreparedStatement pst;
		ResultSet result;
		try 
		{
			pst= con.prepareStatement("select * from transaction where personId=?");
		
			pst.setNString(1,a);
			
			result = pst.executeQuery();
		
			
			while(result.next())
			{
				
				tempResult.add(new Transaction(result.getFloat(1),result.getFloat(2),new Date(result.getString(3)),result.getString(4),result.getString(5)));
			}
			
		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tempResult;
	}

	@Override
	public Transaction dropData(Transaction a) {
		return null;
	}
	
	

}
