package com.empirix.cloud.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.empirix.cloud.helper.TestBase;
import com.empirix.cloud.pagemodules.LoginModule;

public class Login extends TestBase
{
	LoginModule logMod;
	
	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
	}
	
	@Test
	public void Login()
	{
		logMod.login();
	}
}
