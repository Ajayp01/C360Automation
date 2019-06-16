package com.collateral360.JPMC.RES.Pages;

/* 
 * 
 * AJ
 * 
 * 
 */
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;;
public class CollateralOverview {

	
	public WebDriver driver;
	protected ArrayList VALService;
	
	public CollateralOverview(WebDriver driver) {
		
		this.driver=driver;
		
		
	}
	Excel e;
	Wait w;
	By AddNewServiceButton=By.xpath("//div[@id='taskPipelineInner']/div/div[2]/button");
	By Checkbox=By.xpath("//table[@class='innerTable']/tbody/tr[2]/td/table/tbody//tr//td//input[@id='availableReports1']");
	By AddButton=By.xpath("//button[@id='addNewServiceBtn']");
	By TaskPipeline=By.xpath("//h4[@class='smallrounded open']");
	By CancelButton=By.xpath("//div[@id='addNewServiceModal']/div/div/div[3]//button[text()='Cancel']");
	
	public void AddNewServices() throws Exception
	{
		
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		Wait w=new Wait(driver);
		//Scroll down page upto Task pipeline
		
		WebElement tp=driver.findElement(TaskPipeline);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",tp );
		
		driver.findElement(AddNewServiceButton).click();
		
		Thread.sleep(4000);
		
		//Method 2 to select services 
		
			
			VALService=e.ReadServices("SERVICES", 2, 0);
			int k=1;
			int Added=1;
				for(Object a :VALService)
			
				{	
					if(a=="")
					{
						continue;
					}
					
					String abc=null;
			
					try 
			
					{
				
						abc=driver.findElement(By.xpath("//table[@class='innerTable']/tbody/tr[2]/td/table/tbody//tr//td//span[text()='"+a+"']")).getAttribute("id");;
				
						String substring1=abc.substring(abc.lastIndexOf("_") + 1); 
				
						if(driver.findElement(By.xpath("//input[@value='"+substring1+"']")).isSelected())
				
						{
							System.out.println(""+a+" is already selected");
						}
				
						else
				
						{	
							driver.findElement(By.xpath("//input[@value='"+substring1+"']")).click();
							Added++;
						}
			
					}
			
					catch(Exception e)
			 
					{
						System.out.println("No services with "+a+" name is found");
					}
			
					
				}
				
				if(Added!=1)
				{
					driver.findElement(AddButton).click();
				}
				else
				{
					driver.findElement(CancelButton).click();
				}
		
				set(VALService);	
				
}
	public ArrayList get()
	{
		return VALService;
		
	}
	
	public void set(ArrayList l)
	{
		this.VALService=l;
		
	}
	
	public void CheckServicesAddedOrNOT()
	{
		for(Object a :VALService)
		{	
			//To skip execution of code after if block==use continue
			if(a=="")
			{
				continue;
			}
			
			driver.findElement(By.xpath("//div[@class='pageItemContent']//tbody/tr//td//a[contains(text(),'"+a+"')]")).isDisplayed();
			if(driver.findElement(By.xpath("//div[@class='pageItemContent']//tbody/tr//td//a[contains(text(),'"+a+"')]")).isDisplayed())
			{
				System.out.println(a+" is avaialble on task pipeline so that its RFP can be procured");	
			}
		}
		
	}
	
}
