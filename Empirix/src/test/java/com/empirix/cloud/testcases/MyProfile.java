package com.empirix.cloud.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.empirix.cloud.helper.TestBase;
import com.empirix.cloud.pagemodules.HeaderModule;
import com.empirix.cloud.pagemodules.LoginModule;

public class MyProfile extends TestBase
{
	HeaderModule heaMod;
	LoginModule logMod;
	
	@BeforeMethod
	public void befMethod()
	{
		heaMod = new HeaderModule(driver);
		logMod = new LoginModule(driver);
		logMod.login();
	}
	
	@Test
	public void switchLanguage()
	{
		heaMod.switchLanguage("Japanese");
		heaMod.switchLanguage("English");
	}

}
