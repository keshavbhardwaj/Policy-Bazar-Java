package com.provider;

import java.io.FileInputStream;
import java.util.Properties;

import com.interfaces.PolicyInterface;

public class ClientPolicyProvider {
	
	public static PolicyInterface policyObject(String request)
	{
		PolicyInterface p1 = null;
		try {
		
		FileInputStream fIO = new FileInputStream("src//resources//ClassNameValues.properties");
		Properties p = new Properties();
		p.load(fIO);
		
		String bank1 = p.getProperty(request);
		Class c = Class.forName(bank1);
			p1 = (PolicyInterface)c.newInstance();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return p1;
	}

}
