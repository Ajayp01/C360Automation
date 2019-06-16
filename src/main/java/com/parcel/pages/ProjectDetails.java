package com.parcel.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjectDetails {
	
	
	By AcceptButton=By.xpath("//button[@id='acceptRfp']");
	By ContinueButton=By.xpath("//*[text()='Continue Report']");
	By AppraisalDocuments=By.xpath("//*[text()='Appraisal Documents']");
	By dd=By.xpath("//select[@id='ddldocumentType']");
	By BrowseFileButton=By.xpath("//a[@id='userfile']");
	By UploadButton=By.xpath("//input[@value='Upload and deliver to client']");
	WebDriver driver;
	public ProjectDetails(WebDriver driver) {
		this.driver=driver;
	}

	
	public void AcceptAward() throws InterruptedException
	{
		driver.findElement(AcceptButton).click();
		Thread.sleep(8000);
	}
	
	public void SendReport() throws InterruptedException, IOException
	{
		driver.findElement(ContinueButton).click();
		driver.findElement(AppraisalDocuments).click();
		Select s=new Select(driver.findElement(dd));
		s.selectByVisibleText("Final Report");
		
	//Upload File On PARCEL
		
		driver.findElement(By.xpath("//input[@id='userfile']")).click();
		Thread.sleep(2000);
		Runtime.getRuntime().exec("src//test//resources//FileUploadScriptPARCELChrome.exe");
		Thread.sleep(3000);
		driver.findElement(UploadButton).click();
		try{
			driver.switchTo().alert().accept();
		}catch(Exception NoAlertPresentException)
		{
		
		}
	}
}
