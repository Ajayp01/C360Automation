package com.collateral360.JPMC.RES.Pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.collateral360.qa.utilities.Calendar;
import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;

public class RFP {
	WebDriver driver;
	Excel e;
	Object s;
	WebElement tp;
	JavascriptExecutor js;
	Wait w;
	public String aid;
	
	
	public RFP(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	By RFPpage=By.xpath("//iframe[@name='sb-player']");
	By ValuationLink=By.xpath("//div[@id='siteMenu']/ul/li[2]/a[text()='Valuation']");	
	By BidResponseDue=By.id("VendorResponseDateDt");
	By DesiredReportDeliveryDate=By.id("ReportDeliveryDateDt");
	By ReviewerName=By.id("ReviewerName");
	By ReviewerEmail=By.id("ReviewerEmail");
	By ReviewerPhone=By.id("ReviewerPhone");
	By scopeOfService=By.xpath("//span[text()='Scope of Services']");
	By vendorarea=By.xpath("//div[id='vendorSelectionArea']");
	By IntendedUse=By.xpath("//select[@id='IntendedUse']");
	By IntendedUsers=By.xpath("//select[@id='IntendedUsers']");
	By InspectionRequirements=By.xpath("//select[@id='InspectionRequirements']");
	By ReportType=By.xpath("//select[@id='ReportType']");
	By ReportFormat=By.xpath("//select[@id='ReportFormat']");
	By ReportFormatOther=By.id("ReportFormatOther");
	
	By LandValuation=By.xpath("//select[@id='LandValuation']");
	By MarketAnalysis=By.xpath("//select[@id='MarketAnalysis']");
	By SwotAnalysis=By.xpath("//select[@id='SwotAnalysis']");
	By SwotAnalysisOther=By.id("SwotAnalysisOther");
	
	By InsurableValue=By.xpath("//select[@id='InsurableValue']");
	By InsurableValueOther=By.id("InsurableValueOther");
	
	By VALScenarioButton=By.xpath("//input[@value='Add valuation scenario']");
	By Valuationpremise=By.xpath("//select[@name='Valuation premise']");
	By Valuationtype=By.xpath("//select[@name='Valuation type']");
	By Valuationinterest=By.xpath("//select[@name='Valuation interest']");
	By comment=By.xpath("//textarea[@name='comment']");
	
	By BrowseFileButton=By.xpath("//a[@id='-select-file']");
	
	By DirectAwardButton=By.xpath("//span[@class='vendor-assignment-input-container']//input[contains(@value,'DIRECT')]");
	By SelectVendor=By.xpath("");
	By VendorPanal=By.xpath("//select[@name='vendorPanelFilter']");
	By FirstVendor=By.xpath("//table[@id='vendorSelectTable']//tbody[@role='alert']/tr[1]/td[1]/input");
	By Fee=By.cssSelector("#VendorFee");
	By submitRFPPButton=By.cssSelector("#submitRFPProcurementButton");
	By VendorSelection=By.xpath("//span[text()='Vendor Selection']");
	By firstVendorName=By.xpath("//table[@id='vendorSelectTable']//tbody[@role='alert']/tr[1]/td[4]/a");
	By firstVendorAid=By.xpath("//a[contains(@href,'https://preuat.collateral360.com/lenderPortal/vendorManagement/editVendorProfile')]");
	
	public void CheckService() throws Exception
	{
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		Wait w=new Wait(driver);
		Thread.sleep(10000);
		driver.findElement(ValuationLink).click();
		w.WaitForSomeTime();
		ArrayList VALService=e.ReadServices("SERVICES", 2, 0);
		s= VALService.get(0);
		
		if(driver.findElement(By.xpath("//div[@id='rfpNewServicesInner']//tbody//tr//td[label[text()='"+s+"']]")).isDisplayed())
		{	
			System.out.println(s +""+"Service is avaialble");
		}
		else
		{
			System.out.println( s +""+"Service not avaialble");	
		}		
		
	}
	
	public void OpenRFPPage()
	{
		String abc=driver.findElement(By.xpath("//div[@id='rfpNewServicesInner']//tbody//tr//td//label[text()='"+s+"']")).getAttribute("for");
		String numberOnly= abc.replaceAll("[^0-9]", "");
		driver.findElement(By.xpath("//div[@id='rfpNewServicesInner']//tbody//tr//td//input[contains(@onclick,'"+numberOnly+"')]")).click();
	}
	
	public String EnterDataOnRfpForm() throws InterruptedException, IOException
	{
	    Thread.sleep(6000);
		driver.switchTo().frame(driver.findElement(RFPpage));
		Thread.sleep(10000);
		driver.findElement(BidResponseDue).click();
		Calendar o=new Calendar(driver);
		String BidResponseDue=e.ReadExcel("RFP", 5, 1);

		String[] t;
		String dd;
		String mm;
		String yy;
		t=BidResponseDue.split("-");
		 
		dd=t[2];
		mm=t[1];
		yy=t[0];
		
		o=new Calendar(driver);
		o.SelectDates(dd,mm,yy);
		Thread.sleep(3000);
		driver.findElement(DesiredReportDeliveryDate).click();
		String DesiredReportDeliveryDate=e.ReadExcel("RFP", 5, 2);
		t=DesiredReportDeliveryDate.split("-");
		 
		dd=t[2];
		mm=t[1];
		yy=t[0];
		
		o=new Calendar(driver);
		o.SelectDates(dd,mm,yy);
		Thread.sleep(3000);
		
		driver.findElement(ReviewerName).sendKeys(e.ReadExcel("RFP", 5, 3));
		driver.findElement(ReviewerEmail).sendKeys(e.ReadExcel("RFP", 5, 4));
		driver.findElement(ReviewerPhone).sendKeys(e.ReadExcel("RFP", 5, 5));
		
		WebElement tp=driver.findElement(scopeOfService);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",tp );
		
		Select s;
		s=new Select(driver.findElement(IntendedUse));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 6));
		
		s=new Select(driver.findElement(IntendedUsers));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 7));
		
		s=new Select(driver.findElement(InspectionRequirements));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 8));
		
		s=new Select(driver.findElement(ReportType));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 10));
		
		s=new Select(driver.findElement(ReportFormat));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 11));
		driver.findElement(ReportFormatOther).sendKeys("There are many variations of passages of Lorem Ipsum available.");
		
		s=new Select(driver.findElement(LandValuation));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 12));
		
		s=new Select(driver.findElement(MarketAnalysis));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 13));
		
		s=new Select(driver.findElement(SwotAnalysis));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 14));
		driver.findElement(SwotAnalysisOther).sendKeys("The majority have suffered alteration in some form, by injected humour.");
		
		s=new Select(driver.findElement(InsurableValue));
		s.selectByVisibleText(e.ReadExcel("RFP", 5, 15));
		driver.findElement(InsurableValueOther).sendKeys("Randomised words which don't look even slightly believable"); 
		
		//ApproachesToValue
		for(int l=1;l<=6;l++)
		{
			driver.findElement(By.xpath("//div[@id='ApproachesToValue']//tbody//td//input["+l+"]")).click();
		}
		 
		//Valuation Scenarios
		
		driver.findElement(VALScenarioButton).click();
		s=new Select(driver.findElement(Valuationpremise));
		s.selectByVisibleText("Upon Stabilization");
		
		s=new Select(driver.findElement(Valuationtype));
		s.selectByVisibleText("Prospective Market Value");
		
		s=new Select(driver.findElement(Valuationinterest));
		s.selectByVisibleText("Fee simple");
		driver.findElement(comment).sendKeys("Test12");
		
		//Upload File On RFP
		
		driver.findElement(BrowseFileButton).click();
		Thread.sleep(1500);
		//if(e.ReadExcel("Sheet1", 5, 11))
		Runtime.getRuntime().exec("src//test//resources//FileUploadScriptRFPFirefox.exe");
		Thread.sleep(10000);
		
		tp=driver.findElement(VendorSelection);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",tp );
		
		driver.findElement(DirectAwardButton).click();
		
		Select p=new Select(driver.findElement(VendorPanal));
		p.selectByVisibleText("All Vendors");
		
		//Thread.sleep(5000);
		driver.findElement(FirstVendor).click();
		
		driver.findElement(firstVendorName).click();
		Thread.sleep(3000);
		aid=driver.findElement(firstVendorAid).getAttribute("href");
		try {
				String [] temp=aid.split("/");
			
				 aid=temp[6];
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		String f=e.ReadExcel("RFP", 5, 16);
		String fee=f.replace(",", "");
		driver.findElement(Fee).sendKeys(fee);
		Thread.sleep(2000);
		return aid;

		
	}
	
	public void submitRFPP() throws InterruptedException
	{
		driver.findElement(submitRFPPButton).click();
		Thread.sleep(4000);
	}	
	
	public void AttachEngagementLetter() throws InterruptedException
	{
		Wait w=new Wait(driver);
		Thread.sleep(10000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");		
		Thread.sleep(2000);
		w.WaitForSomeTime();
		driver.findElement(By.xpath("//i[@class='fa fa-save']")).click();
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		/*WebElement e=driver.findElement(By.xpath("//*[@id='action-buttons']/button[2]/text()"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("*[id='action-buttons']/button[2]/text()")));		
	*/
	}

	
	
	public String updateRFP() throws InterruptedException
	{
		driver.switchTo().frame(driver.findElement(RFPpage));
		tp=driver.findElement(VendorSelection);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",tp );
		
		driver.findElement(DirectAwardButton).click();
		
		Select p=new Select(driver.findElement(VendorPanal));
		p.selectByVisibleText("All Vendors");
		
		//Thread.sleep(5000);
		driver.findElement(FirstVendor).click();
		
		driver.findElement(firstVendorName).click();
		Thread.sleep(3000);
		aid=driver.findElement(firstVendorAid).getAttribute("href");
		try {
				String [] temp=aid.split("/");
			
				 aid=temp[6];
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");		
		Thread.sleep(2000);
		driver.findElement(submitRFPPButton).click();
		return aid;
	}
	
	
	public void CreateEnvironmentalRFP()
	{
		
		
		
		
	}
	
}
