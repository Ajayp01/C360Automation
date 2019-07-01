package com.collateral360.JPMC.RES.Pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.collateral360.qa.utilities.*;

public class LoginPage 
{

	public WebDriver driver;	
	Excel e;
	
	
public LoginPage(WebDriver driver) throws Exception {
	this.driver=driver;
	e=new Excel("src\\test\\resources\\CollateralData.xlsx");
}	
	

	By Username=By.xpath("//input[@name='username']");
	By Password=By.xpath("//input[@name='password']");
	By EnterButton=By.xpath("//div[@id='loginbtns']/button[@type='submit']");
	By SignInButton=By.xpath("//a[@ng-click='openSigninPopup()']");
	By errorMsg=By.xpath("//div[@class='alert alert-danger']/p");
	
	
	public void SignIn() throws Exception
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains("Collateral360"));
		driver.findElement(SignInButton).click();
		Thread.sleep(3000);
		driver.findElement(Username).sendKeys( e.ReadExcel("Sheet1", 3, 1));
		driver.findElement(Password).sendKeys(e.ReadExcel("Sheet1", 4, 1));
		
		driver.findElement(EnterButton).click();	
		Thread.sleep(4000);
	}

	public String validateLoginPageTitle()
	{		  
		return driver.getTitle();
	}
	
	
}
