package com.daoServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.beans.CarInsuarance;
import com.interfaces.DaoInterface;
import com.provider.DaoProvider;

public class CarInsuranceDaoService implements DaoInterface<CarInsuarance, String>{
	
	Connection con;
	
	public CarInsuranceDaoService()
	{
		con=DaoProvider.connection();
	}

	@Override
	public CarInsuarance insertData(CarInsuarance a) {
		CarInsuarance tempResult=null;
		PreparedStatement pst;
		int result=0;
		
		try 
		{
			pst= con.prepareStatement("insert into carInsuarance values(?,?,?,?,?,?,?)");
			pst.setFloat(1, a.getInsuarancePremium());
			pst.setFloat(2, a.getPerClaim());
			pst.setString(3, a.getPlateNumber());
			pst.setInt(4, a.getPolicyId());
			pst.setString(5,a.getUpdatedDate().toString());
			pst.setString(6,a.getExpiryDate().toString());
			pst.setString(7,a.getStartDate().toString());
			
			result=pst.executeUpdate();			
		}
		
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in loading CarInsuarance Data to data base");
		}
		else
		{
			tempResult = a;
		}
		
		return tempResult;
	}

	@Override
	public CarInsuarance updateData(CarInsuarance a) {
		CarInsuarance tempResult = null;
		
		tempResult = dropData(a);
		if(tempResult==null)
		{
			System.out.println("Failed in updating CarInsuarance Data in data base");
		}
		else 
		{
			tempResult = insertData(a);
			if(tempResult==null)
			{
				System.out.println("Failed in updating CarInsuarance Data in data base");
			}
			else
				tempResult = a;
		}
				
		return tempResult;
	}

	
	
	public ArrayList<CarInsuarance> searchDataByPersonAndPolicy(Integer a, String b) {
		ArrayList<CarInsuarance> tempResult = new ArrayList<CarInsuarance>();
		PreparedStatement pst;
		ResultSet result;
		try 
		{
			pst= con.prepareStatement("select * from carInsuarance where policyId=? and personId=?");
			pst.setInt(1,a);
			pst.setString(2,b);
			result = pst.executeQuery();
		
		
			while(result.next())
			{
				
				tempResult.add(new CarInsuarance(result.getFloat(1),result.getFloat(2),result.getString(3),result.getInt(4),result.getString(5),result.getString(6),result.getString(7)));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tempResult;
	}
	
	
	
	
	public ArrayList<CarInsuarance> searchDataByPerson(String b) {
		ArrayList<CarInsuarance> tempResult = new ArrayList<CarInsuarance>();
		PreparedStatement pst;
		ResultSet result;
		try 
		{
			pst= con.prepareStatement("select * from carInsuarance where personId=?");
			pst.setString(1,b);
			result = pst.executeQuery();
		
		
			while(result.next())
			{
				
				tempResult.add(new CarInsuarance(result.getFloat(1),result.getFloat(2),result.getString(3),result.getInt(4),result.getString(5),result.getString(6),result.getString(7)));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tempResult;
	}
	
	
	
	
	@Override
	public CarInsuarance searchData(String a) {
		CarInsuarance tempResult = null;
		PreparedStatement pst;
		ResultSet result;
		try 
		{
			pst= con.prepareStatement("select * from carInsuarance where platenumber=?");
		
			pst.setString(1,a);
			
			result = pst.executeQuery();
		
		
		if(result.next())
		{
			
			tempResult = new CarInsuarance(result.getFloat(1),result.getFloat(2),result.getString(3),result.getInt(4),result.getString(5),result.getString(6),result.getString(7));
		}
		else
		{
			System.out.println("Failed in fetching carInsuarance Data from data base");
		}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return tempResult;
	}

	@Override
	public CarInsuarance dropData(CarInsuarance a) {
		CarInsuarance tempResult = null;
		PreparedStatement pst;
		int result=0;
		
		try 
		{
			pst= con.prepareStatement("delete from carInsuarance where plateNumber=?");
		
			pst.setString(1,a.getPlateNumber());
			
			result = pst.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		if(result<1)
		{
			System.out.println("Failed in deleting carInsuarance Data from data base");
		}
		else
		{
			tempResult = a;
		}
		
		return tempResult;
	}

}
