package com.collateral360.JPMC.RES.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;

/* 
 * 
 * Ajay
 * 
 * 
 */

public class C360Dashboard {
	
	public C360Dashboard(WebDriver driver) {
		this.driver=driver;
	}

	//Dashbaord
		By OpenTab=By.xpath("//*[@id='divDashBody']/div/ul/li[2]/a");
		//ul[@class='nav nav-tabs lp-tabs']/li[2]/a[@href='#openOrders']"
		By LoanLabel=By.xpath("//label[@class='inline']");
		By EnterProjectName=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[6]");
		By EnterBorrowerName=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[7]");
		By EnterAddress=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[8]");
		
		@FindBy(xpath="//div[@id='openOrders']//thead//tr[2]/th[8]")
		WebElement EnterAddress1;
		
	public WebDriver driver;
	public Excel e;
	//Wait w;
	 String projectname;
	 String address;
	 String Borrower;
	 
	public void VerifyCreatedLoan() throws Exception
	{
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		Wait w=new Wait(driver);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		//w.WaitForSomeTime();
		driver.findElement(OpenTab).click();
	    projectname=e.ReadExcel("JPMC", 5, 1);
		address=e.ReadExcel("JPMC", 9, 4);
		Borrower=e.ReadExcel("JPMC", 5, 4);
		
		
		Actions g=new Actions(driver);
		g.moveToElement(driver.findElement(EnterProjectName)).click().sendKeys(projectname).build().perform();//driver.findelement may not work , so use Actions() To focus the element on the dashboard. 
		g.moveToElement(driver.findElement(EnterBorrowerName)).click().sendKeys(Borrower).build().perform();
		g.moveToElement(driver.findElement(EnterAddress)).click().sendKeys(address).build().perform();
		
		/*By EnterProjectName=By.xpath("//div[@id='openOrders']//thead//tr[2]/th[6]");
		driver.findElement(EnterProjectName).click();
		driver.findElement(EnterProjectName).sendKeys(projectname);*/
		Thread.sleep(7000);
			try {	
			String p=driver.findElement(By.xpath("//tbody/tr/td/label")).getText();	
			if(p.contains(address))
			{
				System.out.println("Laon Created Successfully ");
			}
			}
			catch(Exception e)
			{
				System.out.println("Loan has not created so not found on dashboard ");
			}
		
	}
	
	
	public void OpenLoan()
	{
		Wait w=new Wait(driver);
		w.WaitForSomeTime();
		try
		{
			    Actions a=new Actions(driver);
				a.moveToElement(driver.findElement(By.xpath("//*[@id='openOrders-table']/tbody/tr[td[8 and text()='"+address+"'] and td[6 and text()='"+projectname+"']]"))).doubleClick().build().perform();
		}
		catch(Exception e)
		{
			System.out.println("Loan not created or not found on dashboard ");
			
		}
			
	}
	
	public void OpenExistingLoan()
	{
		
		
	}
	

}
