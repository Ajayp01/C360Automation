package com.collateral360.JPMC.RES.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.collateral360.qa.utilities.Excel;

public class ReportStatusPage {

	public WebDriver driver;
	public ReportStatusPage(WebDriver driver) {
		this.driver=driver;
	}
	By ReportStatusButton=By.xpath("//div[@id='siteMenu']/ul/li[4]/a[text()='Report Status']");
	public void CheckRFPStatus(int i) throws Exception
	{
		Excel e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		ArrayList VALService=e.ReadServices("SERVICES", 2, 0);
		Object s= VALService.get(0);
		String fee=e.ReadExcel("RFP", 5, 16);
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.findElement(ReportStatusButton).click();
		Thread.sleep(5000);
		String Status=driver.findElement(By.xpath("//*[@id='procuredServicesInner']/table[1]/tbody/tr[//td[contains(text(),'"+fee+"')] and //td[text()='"+s+"']]//td[8]")).getText();
		if(i==1)
		{
			Assert.assertEquals(Status, "Awarded");
			
		}	
		else if(i==2)
		{
			Assert.assertEquals(Status, "Accepted");
		}
		else
	    {
			Assert.assertEquals(Status, "Uploaded");
	    }
			
	}
	
	
}
