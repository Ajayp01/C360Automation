package com.collateral360.JPMC.RES.Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateSRFINT {

	
	public WebDriver driver;
public CreateSRFINT(WebDriver driver) {
		
		this.driver=driver;
	}


By CreateLoanButton=By.xpath("//a[@data-title='Create New Request']");

By SRFpage=By.xpath("//iframe[@name='sb-player']");
By ExistingCabinet=By.xpath("//div[@id='addLoanSelector']/p/a[@href='#']");
By ExistingCabinet1=By.xpath("//a[text()='Add a new Request to an Existing Cabinet']");
public void INTCreateLoan() throws Exception
{
	driver.findElement(By.xpath("//a[@data-title='Create New Request']")).click();
	driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='sb-player']")));
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//a[text()='Add a new Request to an Existing Cabinet']")).click();
}
}
