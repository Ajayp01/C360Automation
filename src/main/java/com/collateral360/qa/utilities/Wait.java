package com.collateral360.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public WebDriver driver;
	public static long pageLoadTimeout=120;
	public Wait(WebDriver driver) {
		
		this.driver=driver;
	}

	public void WaitForSomeTime()
	{
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	}
	
	public static void SendKeys(WebDriver driver,WebElement element,int timeout,String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);		
	}
	
	public void ClickOn(WebDriver driver,WebElement element,int timeout)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();	
		//
	}
	
	public void WaitandClick(WebDriver driver,WebElement element,int timeout)
	{
		
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));
		
	}
}
