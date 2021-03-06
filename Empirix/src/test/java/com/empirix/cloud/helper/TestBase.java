package com.empirix.cloud.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.empirix.cloud.util.ConfigUtil;

public class TestBase 
{
	public static Properties conf = null;
	public static FileInputStream input = null;
	public static boolean isInitialized = false;
	public static boolean isBrowserOpened = false;
	String server;
	public static String platform;
	public String browser;
	public static String environment;
	public static String url;
	public static WebDriver driver;
    public static Logger LOGGER;
    
    public TestBase()
    {
    	LOGGER = Logger.getLogger(this.getClass().getName());
    	Handler consoleHandler = null;
	     Handler fileHandler  = null;
	    try
	    {
	    	consoleHandler = new ConsoleHandler();
	        fileHandler  = new FileHandler("./empirix.log");
	             
	        LOGGER.addHandler(consoleHandler);
	        LOGGER.addHandler(fileHandler);
	             
	        consoleHandler.setLevel(Level.ALL);
	        fileHandler.setLevel(Level.ALL);
	        LOGGER.setLevel(Level.ALL);
	             
	        LOGGER.config("Configuration done.");
	             
	        LOGGER.removeHandler(consoleHandler);
	             
	        LOGGER.log(Level.FINE, "Logger Started");
	    } 
	    catch(IOException exception)
	    {
	            LOGGER.log(Level.SEVERE, "Error occur in FileHandler.", exception);
	    }
    }
	
	/**
	 * This will set Driver based on capabilities and configuration
	 * @author Tarun Goswami
	 * @since 2020-01-21
	 * @version 1.1
	 */
	public void setDriver(String browser) throws MalformedURLException
	{
		server = conf.getProperty("Server");
		environment = conf.getProperty("Environment");		
		url = conf.getProperty(environment+"_URL");
		
		System.out.println(server+browser+environment+url);
	        
		if(browser.equals("Firefox")) 
		{
			if(server.equals("Windows"))
				System.setProperty("webdriver.gecko.driver", Constants.WINDOWS_FIREFOX_DRIVER);
			else if(server.equals("Linux"))
				System.setProperty("webdriver.gecko.driver", Constants.LINUX_FIREFOX_DRIVER);
			else if(server.equals("Mac"))
				System.setProperty("webdriver.gecko.driver", Constants.MAC_FIREFOX_DRIVER);
			
			FirefoxOptions options = new FirefoxOptions();
			driver = new FirefoxDriver();
		}
		
		if(browser.equals("Chrome"))
		{
			if(server.equals("Windows"))
				System.setProperty("webdriver.chrome.driver", Constants.WINDOWS_CHROME_DRIVER);
			else if(server.equals("Linux"))
				System.setProperty("webdriver.chrome.driver", Constants.LINUX_CHROME_DRIVER);
			else if(server.equals("Mac"))
				System.setProperty("webdriver.chrome.driver", Constants.MAC_CHROME_DRIVER);
          
	        ChromeOptions options = new ChromeOptions(); 
	        driver = new ChromeDriver(options);
	        LOGGER.log(Level.FINE, "Browser Open");
		}
		
		if(browser.equals("Edge")) 
		{
			if(server.equals("Windows"))
				System.setProperty("webdriver.edge.driver", Constants.WINDOWS_EDGE_DRIVER);
			else if(server.equals("Mac"))
				System.setProperty("webdriver.edge.driver", Constants.MAC_EDGE_DRIVER);
			
			driver = new EdgeDriver();
			
		}
		
		driver.get(url);
		LOGGER.info("Logger Name: "+LOGGER.getName());
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
	}
	
	/**
	 * This will intialize config file
	 * @author Tarun Goswami
	 * @since 2020-01-21
	 * @version 1.0
	 */
	public static void Initialize() 
	{
		if (!isInitialized) 
		{
			try 
			{					
				ConfigUtil.loadProperty(); 		
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}	
	}
	
	/**
	 * Execute before any test method
	 * @author Tarun Goswami
	 * @since 2020-01-21
	 * @version 1.0
	 */
	@BeforeTest
	@Parameters("browser")
	public void befo(String browser) throws MalformedURLException 
	{
		TestBase base = new TestBase();
		base.Initialize();
		LOGGER.log(Level.FINE, "File Intialized");
		base.setDriver(browser);
		LOGGER.log(Level.FINE, "Driver Set");
	}
}
