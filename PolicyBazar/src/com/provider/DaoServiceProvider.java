package com.provider;

import java.io.FileInputStream;
import java.util.Properties;

import com.interfaces.DaoInterface;

public class DaoServiceProvider {
	
	public static DaoInterface getObject(String result)
	{
		FileInputStream fis;
		Properties p;
		DaoInterface d1 = null;
		
		try {
			fis=new FileInputStream("res//Database.properties");
			p=new Properties();
			p.load(fis);
			
			Class c = Class.forName(p.getProperty(result));
			
			d1 = (DaoInterface) c.newInstance();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return d1;
	}

}
