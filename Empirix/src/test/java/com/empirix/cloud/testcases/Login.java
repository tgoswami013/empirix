package com.empirix.cloud.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.empirix.cloud.helper.TestBase;
import com.empirix.cloud.pagemodules.HeaderModule;
import com.empirix.cloud.pagemodules.LoginModule;

public class Login extends TestBase
{
	LoginModule logMod;
	HeaderModule heaMod;
	
	@BeforeMethod
	public void befMethod()
	{
		logMod = new LoginModule(driver);
		heaMod = new HeaderModule(driver);
	}
	
	@Test
	public void Login()
	{
		logMod.login();
		Assert.assertTrue(heaMod.myProfileCaret.isDisplayed());
	}
}
