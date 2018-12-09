package com.businessServices;


import com.beans.Policy;
import com.clientService.ClientInitialiseInputs;
import com.clientService.ClientServiceInputs;
import com.clientService.ClientUpdateInputs;
import com.daoServices.PolicyDaoService;

public class PolicySoftwareAdminServices extends PersonAdminServiceSuperClass{
	
	
	PolicyDaoService pds;
	public PolicySoftwareAdminServices()
	{
		pds=new PolicyDaoService();
	}
	public Policy updatePolicy()
	{
		Policy pNew=ClientInitialiseInputs.findPolicy(pds);
		ClientUpdateInputs.updatePolicyData(pNew);
		return pds.updateData(pNew);
	}
	public Policy createPolicy()
	{
		Policy pNew=new Policy();
		ClientInitialiseInputs.initialisePolicy(pNew);
		pds.insertData(pNew);
		return pNew;
	}
	public void deletePolicy()
	{
		
		Policy pNew=ClientInitialiseInputs.findPolicy(pds);
		if(pNew!=null)
		{
			pds.dropData(pNew);
		}
	}

	@Override
	public void getServices() {
		
		int choice;
		//case 1:
				do
				{
					choice=ClientServiceInputs.adminService();
					PolicySoftwareAdminServices pas=new PolicySoftwareAdminServices();
					switch (choice) 
					{
						case 1:
							createPolicy();
							break;
						case 2:
							updatePolicy();
							break;
						case 3:
							deletePolicy();
							break;
						case 4:
							pas=null;
							break;
						default:
							break;
					}
					
					
				}while(choice!=4);
		
	}

}
