package com.empirix.cloud.pagemodules;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.empirix.cloud.helper.TestBase;

public class HeaderModule extends TestBase
{
	@FindBy(css="span[class='caret']")
	public  WebElement myProfileCaret;

	@FindBy(css="div[class='ng-scope'] a")
	public  WebElement activeLanguageLnk;
	
	@FindBy(css="ul[class='nav navbar-nav'] li a[class='']")
	public List<WebElement> menuList;
	
	public HeaderModule(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void switchLanguage(String language)
	{
		myProfileCaret.click();		
		if(activeLanguageLnk.getText().equals(language))
		{
			activeLanguageLnk.click();
			driver.switchTo().alert().accept();
		}
	}
	
	public void menuList()
	{
		Assert.assertTrue(menuList.get(menuList.size() - 1).isDisplayed());
		for(WebElement element:menuList)
		{
			System.out.println(element.getText());
		}
	}
}
