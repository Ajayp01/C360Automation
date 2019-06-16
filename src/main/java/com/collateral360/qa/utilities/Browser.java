package com.collateral360.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browser {

	
	public WebDriver driver;
	
	
	public Browser(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	public WebDriver OpenBrowser(String Key) throws Exception
	{
		
		Excel e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		String name = null;
		if(Key.equalsIgnoreCase("collateral"))
		{	
			 name=e.ReadExcel("sheet1", 1, 1);
		}
		else if(Key.equalsIgnoreCase("PARCEL"))
		{
			
			 name=e.ReadExcel("sheet1", 8, 1);
		}
		
		
		if(name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		
		if(name.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
	    }
	
		if(name.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", "src\\test\\resources\\Drivers\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}	
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
}
