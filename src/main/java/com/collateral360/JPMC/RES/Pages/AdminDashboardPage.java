package com.collateral360.JPMC.RES.Pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.collateral360.qa.utilities.Excel;


public class AdminDashboardPage {

	//OR
	
	By LoggedUser=By.xpath("//div[@id='userInfo']/button/span");
	
	
	public WebDriver driver;
	Excel e;
	
	public AdminDashboardPage(WebDriver driver) throws Exception{
		this.driver=driver;
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
	}
	
	public void Impersonate(String Key,String aid) throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains("Collateral360"));
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

	}
	
	public String validateLoggedUserName()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.titleContains("Collateral360"));
		return driver.findElement(LoggedUser).getText();
	}
	
	
	
	
}
