package com.empirix.cloud.pagemodules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.empirix.cloud.helper.TestBase;

public class LoginModule extends TestBase
{
	@FindBy(name="callback_0")
	public  WebElement usernameTxt;
	
	@FindBy(name="callback_1")
	public  WebElement passwordTxt;
	
	@FindBy(css="input[type='submit'][value='Sign in']")
	public WebElement signInBtn;
	
	public LoginModule(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void login()
	{
		usernameTxt.sendKeys("QA_traininguser25");
		passwordTxt.sendKeys("Empirix!");
		signInBtn.click();
	}
}