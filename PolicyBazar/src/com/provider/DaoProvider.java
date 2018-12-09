package com.provider;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

//import com.mysql.jdbc.Connection;

public class DaoProvider {
	
	public static Connection con;
	
	
	public static Connection  connection()
	{
		
		FileInputStream fis;
		Properties p;
		try {
		fis=new FileInputStream("res//Database.properties");
		p=new Properties();
		p.load(fis);
		
		String driver=p.getProperty("driver");
		String url=p.getProperty("url");
		String username=p.getProperty("username");
		String password=p.getProperty("password");
		
		Class.forName(driver);
		con=(Connection) DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
		
	}

}
