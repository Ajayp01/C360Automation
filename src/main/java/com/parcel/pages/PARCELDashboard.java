package com.parcel.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;

public class PARCELDashboard {
	
	public WebDriver driver;
	
	public PARCELDashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	By bid=By.cssSelector("#BidsNav");
	By AwaitingBidButton=By.cssSelector("#wait-accpt-bid");
	By EntTourButton=By.xpath("//button[text()='End tour']");
	
	public void OpenBid() throws Exception
	{
		Wait w =new Wait(driver);
		try
		{
			WebElement element=driver.findElement(EntTourButton);
			w.ClickOn(driver, element, 5);
		
		}catch(Exception e)
		{
		}
	
		driver.findElement(bid).click();
		w.WaitForSomeTime();
		driver.findElement(AwaitingBidButton).click();
		Excel e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		String pname=e.ReadExcel("jpmc", 5, 1);
		String paddr=e.ReadExcel("jpmc", 9, 4);
		String f=e.ReadExcel("RFP", 5, 16);
		ArrayList VALService=e.ReadServices("SERVICES", 2, 0);
		
		for(int k=0;k<VALService.size();k++)
		{
			
			
			Object temp=VALService.get(k);
			try {
					if(driver.findElement(By.xpath("//table[@id='gridfindreports']/tbody/tr[td[text()='"+pname+"'] and td[text()='"+paddr+"'] and td[text()='"+temp+"'] and td[29 and contains(text(),'"+f+"')]]")).isDisplayed())
					{
				
					driver.findElement(By.xpath("//table[@id='gridfindreports']/tbody/tr[td[text()='"+pname+"'] and td[text()='"+paddr+"'] and td[text()='"+VALService.get(k)+"'] and td[29 and contains(text(),'"+f+"')]]//td[1]/div/a[text()='ACCEPT']")).click();
				
					break;
					
					}
			   	}catch(NoSuchElementException e1)
				{
				}
					
			
		}
		
	}
}
