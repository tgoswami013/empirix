package com.empirix.cloud.testcases;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.empirix.cloud.helper.TestBase;
import com.empirix.cloud.pagemodules.HeaderModule;
import com.empirix.cloud.pagemodules.LoginModule;

public class MyProfile extends TestBase
{
	MyProfile()
	{
		LOGGER = Logger.getLogger(this.getClass().getName());
	}
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
	
	@Test
	public void userTabs()
	{		
		heaMod.menuList();
		heaMod.switchLanguage("Japanese");
		heaMod.menuList();
	}
}
