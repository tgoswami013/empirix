package com.empirix.cloud.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderModule 
{
	@FindBy(css="span[class='caret']")
	public  WebElement myProfileCaret;

	@FindBy(css="div[class='ng-scope'] a")
	public  WebElement activeLanguageLnk;
	
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
		}
	}
}
