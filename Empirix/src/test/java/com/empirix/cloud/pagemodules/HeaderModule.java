package com.empirix.cloud.pagemodules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.empirix.cloud.helper.TestBase;

public class HeaderModule extends TestBase
{
	@FindBy(css="span[class='caret']")
	public  WebElement myProfileCaret;

	@FindBy(css="div[class='ng-scope'] a")
	public  WebElement activeLanguageLnk;
	
	public HeaderModule(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void switchLanguage(String language) throws InterruptedException
	{
		myProfileCaret.click();		
		if(activeLanguageLnk.getText().equals(language))
		{
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated((By) activeLanguageLnk));
			element.click();
			driver.switchTo().alert().accept();
		}
	}
}
