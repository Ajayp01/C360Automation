package com.collateral360.qa.utilities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Calendar {

	
	WebDriver driver;
	Wait w;
	public Calendar(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void SelectDates(String Date,String Month,String Year) throws InterruptedException
	{
		Wait w=new Wait(driver);	
		int result = Integer.parseInt(Year);
		String month=null;
		String a[]={"","January","February","March","April","May","June","July","August","September","October","November","December"};
		//Year
			
				if(result>2018)
				{
				
					while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']")).getText().contains(Year))
				    {
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//click on next arrow	
						
				    }
				
					//Month
					int i;
					
					String MonthInText=null;
					
					int MonthInt = Integer.parseInt(Month);	 
						for(i=0;i<a.length;i++)
						{
							if(MonthInt==i)
							{
								MonthInText=a[i];
								break;
							}
							
						}
					while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().contains(MonthInText))
			
					{	
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();//click on next arrow
					}
					
					 month=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
				}
				
				else
				{
					while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']//div[@class='ui-datepicker-title']")).getText().contains(Year))
					{
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//click on previous arrow	
					}
				
					int i;
					String MonthInText=null;
					
					int MonthInt = Integer.parseInt(Month);	 
						for(i=0;i<a.length;i++)
						{
							if(MonthInt==i)
							{
								MonthInText=a[i];
								break;
							}
							
						}
					while(!driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().contains(MonthInText))
			
					{	
						driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();//click on next arrow
					}
				
				}
				
				int d=0;
				int i;
				for(i=1;i<a.length;i++)
				{
					if(a[i].equals(month))
					{
						d=i-1;
						break;
					}
					
				}
				    int Date1 = Integer.parseInt(Date);
				    w.WaitForSomeTime();
					driver.findElement(By.xpath("//td[@data-month='"+d+"']//a[text()='"+Date1+"']")).click();
	}
	
}
