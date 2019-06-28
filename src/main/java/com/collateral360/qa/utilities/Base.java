package com.collateral360.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	
	public WebDriver driver;
	
	public Excel e;
	public Base(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	
	 public WebDriver initialization(String Key) throws Exception
	{

		browser(Key);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get(e.ReadExcel("Sheet1", 2, 1));
		Thread.sleep(5000);
		return driver;
	}
	 
	 private void browser(String Key) throws Exception {
			e=new Excel("src\\test\\resources\\CollateralData.xlsx");
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
		 
	 }
	
}
