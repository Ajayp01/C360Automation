package com.collateral360.JPMC.RES.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.collateral360.qa.utilities.*;

public class LoginPage 
{

	WebDriver driver;	
	Excel e;
	
	
public LoginPage(WebDriver driver) {
	
	this.driver=driver;
}	
	

	By username=By.xpath("//input[@name='username']");
	By pwd=By.xpath("//input[@name='password']");
	By enter=By.xpath("//button[@type='submit']");
	By signIn=By.xpath("//a[@ng-click='openSigninPopup()']");
	By errorMsg=By.xpath("//div[@class='alert alert-danger']/p");
	
	public WebDriver SignIn() throws Exception
	{
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		Wait w=new Wait(driver);
		String url = null;
		String uname = null;
		String password = null;
		
	    url=e.ReadExcel("Sheet1", 2, 1);
		uname=e.ReadExcel("Sheet1", 3, 1);
		password=e.ReadExcel("Sheet1", 4, 1);	
				
		    driver.get(url);	
			WebElement SigninButton=driver.findElement(signIn);
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", SigninButton);
		    //driver.findElement(signIn).click();
			w.WaitForSomeTime();
			driver.findElement(username).clear();
			driver.findElement(username).sendKeys(uname);
			driver.findElement(pwd).clear();
			driver.findElement(pwd).sendKeys(password);

			driver.findElement(enter).click();
			Thread.sleep(10000);
		/*Thread.sleep(3000);
		WebElement e= driver.findElement(errorMsg);
		String errorMessage=e.getText();
		Assert.assertEquals(errorMessage,"You haveentered an incorrect Username and/or Password. Try again.","wrong credentials");
		*/
		return driver;
		
	}

	
	public void Impersonate(String Key,String aid) throws Exception
	{
		
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		String id = null;
		if(Key.equalsIgnoreCase("collateral"))
		{
			 id=e.ReadExcel("JPMC", 0, 1);//we get impersonate aid
		}
		
		else if(Key.equalsIgnoreCase("PARCEL"))
		{
			 id=aid;
		}
	
		String link="https://preuat.collateral360.com/impersonate.php?aid=";
		link+=id;
		driver.get(link);
		Thread.sleep(15000);
	}



	
}
