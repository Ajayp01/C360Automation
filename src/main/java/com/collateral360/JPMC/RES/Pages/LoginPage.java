package com.collateral360.JPMC.RES.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.collateral360.qa.utilities.*;

public class LoginPage 
{

	public WebDriver driver;	
	Excel e;
	
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
}	
	

	By Username=By.xpath("//input[@name='username']");
	By Password=By.xpath("//input[@name='password']");
	By EnterButton=By.xpath("//div[@id='loginbtns']/button[@type='submit']");
	By SignInButton=By.xpath("//a[@ng-click='openSigninPopup()']");
	By errorMsg=By.xpath("//div[@class='alert alert-danger']/p");
	
	
	public void SignIn() throws Exception
	{
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains("Collateral360"));
		driver.findElement(SignInButton).click();
		driver.findElement(Username).sendKeys( e.ReadExcel("Sheet1", 3, 1));
		driver.findElement(Password).sendKeys(e.ReadExcel("Sheet1", 4, 1));
		driver.findElement(EnterButton).click();		
	}

	public String validateLoginPageTitle()
	{		  
		return driver.getTitle();
	}
	
	
}
