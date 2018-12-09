package com.businessServices;

import com.beans.Damage;
import com.clientService.ClientInitialiseInputs;

public class DamageService {
	
	public static void getData(Damage D1)
	{
		ClientInitialiseInputs.initialiseDamage(D1);
	}

}
