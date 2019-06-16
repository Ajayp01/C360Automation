package com.parcel.pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;

public class AllProjects {

	public WebDriver driver;
	public AllProjects(WebDriver driver) {
		this.driver=driver;
	}
	By bid=By.cssSelector("#BidsNav");
	By AllProjects=By.cssSelector("#all-projects"); 
	
	public void ViewDetails() throws Exception
	{
		Wait w =new Wait(driver);
		Thread.sleep(7000);
		driver.findElement(bid).click();
		w.WaitForSomeTime();
		driver.findElement(AllProjects).click();
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
						driver.findElement(By.xpath("//table[@id='gridfindreports']/tbody/tr[td[text()='"+pname+"'] and td[text()='"+paddr+"'] and td[text()='"+VALService.get(k)+"'] and td[29 and contains(text(),'"+f+"')]]//td[1]/div/a[text()='VIEW DETAILS']")).click();
						break;
					}
			   	}catch(NoSuchElementException e1)
				{
				}			
		}
	}
}
