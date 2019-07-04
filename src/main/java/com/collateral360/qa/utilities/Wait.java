package com.collateral360.qa.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public WebDriver driver;
	public static long PAGE_LOAD_TIME_OUT=120;
	public static long IMPLICIT_WAIT=40;
	public Wait(WebDriver driver) {
		
		this.driver=driver;
	}

	public void WaitForSomeTime()
	{
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	
	public static void SendKeys(WebDriver driver,WebElement element,int timeout,String value)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
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
