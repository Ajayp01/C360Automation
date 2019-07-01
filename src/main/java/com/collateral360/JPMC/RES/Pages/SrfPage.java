package com.collateral360.JPMC.RES.Pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.collateral360.qa.utilities.Calendar;
import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;

public class SrfPage {

	
	//Transaction Tab
	
	By createLoanButton=By.xpath("//a[@data-title='Create New Request']");
	By sRFpage=By.xpath("//iframe[@name='sb-player']");
	By projectName=By.xpath("//input[@id='ProjectName']");
	By loanNumber=By.xpath("//input[@id='LoanNumber']");
	By loanAmount=By.xpath("//input[@id='LoanAmount']");
	By borrowerName=By.xpath("//input[@id='BorrowerName']");
	By eCID=By.xpath("//input[@id='ecid']");
	By anticipatedClosingDateCalendar=By.xpath("//input[@id='ClosingDate']");
	By desiredDateCalendar=By.xpath("//input[@id='DesiredReviewDeliveryDate']");
	
	By requesterAID=By.xpath("//span[@aria-labelledby='select2-RequesterAID-container']//span[2]");
	By textbox=By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span/span/input[@class='select2-search__field']");
	By accountOfficerAID=By.xpath("//span[@aria-labelledby='select2-AccountOfficerAID-container']//span[2]");
	By costcentre=By.xpath("//span[@aria-labelledby='select2-CostCenter-container']//span[2]");	
	By company=By.xpath("//span[@aria-labelledby='select2-CompanyNumber-container']//span[2]");
	By teamLeadAID=By.xpath("//*[@id='divDealTeamInfo']/fieldset/table/tbody/tr/td/div[3]/span/span[1]/span/ul/li/input");

	By teamLeadtextbox=By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--focus select2-container--open select2-container--above']//span[@class='select2-selection select2-selection--multiple']//ul/li/input");
	
	By moveToCollateralTab=By.xpath("//input[@value='Move to Collateral Tab']");
	By browseFileButton=By.xpath("//a[@id='srfuploads-select-file']");
	By isSbaLoanRadioButton=By.xpath("//input[@id='IsSbaLoan1']");
	By sbaTypeDropdown=By.xpath("//select[@id='sbaType']");
	By intendedUsers=By.xpath("//input[@id='PartnerBusinessName']");
	By cDCPartners=By.xpath("//input[@id='AltPartnerBusinessName']");
	By participationSyndication=By.xpath("//input[@id='IsParticipationLoan1']");
	By aggregateLoanAmount=By.xpath("//input[@id='ParticipationLoanAmount']");
	By jPMCShare=By.xpath("//input[@id='ParticipationLenderShare']");
	By otherBanks=By.xpath("//input[@id='OtherBanks']");
	By administrativeAgent=By.xpath("//input[@id='IsAgentBank1']");
	By priorJob=By.xpath("//input[@id='PriorJob']");
	
	//Collateral Tab
	
	By propertyType=By.xpath("//select[@id='PropertyType']");
	By propertySubType=By.xpath("//select[@id='PropertySubTypeList']");
	By country=By.xpath("//select[@id='PropCountry']");
	By address=By.xpath("//input[@id='PropAddress']");
	By secondaryStreetAddress=By.xpath("//input[@id='SecondaryStreetAddress']");
	By suitFloorUnit=By.xpath("//input[@id='PropUnit']");
	By city=By.xpath("//input[@id='PropCity']");
	By state=By.xpath("//select[@id='PropState']");
	By mAPPROPERTYButton=By.xpath("//input[@class='coolBtn coolBtn-ocean']");
	By apn=By.xpath("//textarea[@id='PropertyNumbers']");
	By vALService=By.xpath("//input[@value='Valuation']");
	By eNVService=By.xpath("//input[@value='Environmental']");
	By purposeVAL=By.xpath("//select[@id='Purpose']");
	By appraisalPriority=By.xpath("//select[@id='AppraisalPriority']");
	By creditTransactionTypeAppraisal=By.xpath("//select[@id='TransactionTypeList']");
	By oFSIReport=By.xpath("//input[@id='ofsiReportReview1']");
	By propertyInterestAppraised=By.xpath("//input[@id='PropInterest3']");
	By propInterestOther=By.xpath("//input[@id='PropInterestOther']");
	By valuationPremiseOther=By.xpath("//input[@id='ValuationPremiseOther']");
	By purposeENV=By.xpath("//select[@id='PurposeEnv']");
	By creditTransactionTypeEnvironmental=By.xpath("//select[@id='TransactionTypeEnvList']");
	By environmentalPriority=By.xpath("//select[@id='EnvironmentalPriority']");
	By contactType=By.xpath("//select[@id='ContactType']");
	By contactCompany=By.xpath("//input[@id='ContactCompany']");
	By contactName=By.xpath("//input[@id='ContactName']");
	By contactPhone=By.xpath("//input[@id='ContactPhone']");
	By contactEmail=By.xpath("//input[@id='ContactEmail']");
	By contactAltPhone=By.xpath("//input[@id='ContactAltPhone']");
	By numBuildings=By.xpath("//input[@id='NumBuildings']");
	By buildingSize=By.xpath("//input[@id='BuildingSize']");
	By improvementsizeAsIsAlt=By.xpath("//input[@id='improvementsizeAsIsAlt']");
	By buildingSizeCompleted=By.xpath("//input[@id='BuildingSizeCompleted']");
	By improvementsizeAsCompletedAlt=By.xpath("//input[@id='improvementsizeAsCompletedAlt']");
	By landSize=By.xpath("//input[@id='LandSize']");
	By excessLand1=By.xpath("//input[@id='ExcessLand1']");
	By yearBuilt=By.xpath("//input[@id='YearBuilt']");
	By lastRenovated=By.xpath("//input[@id='LastRenovated']");
	By hasRenovation1=By.xpath("//input[@id='HasRenovation1']");
	By renevationDesc=By.xpath("//input[@id='RenevationDesc']");
	By zoning=By.xpath("//input[@id='Zoning']");
	By propertyStatus=By.xpath("//*[@id='div']/fieldset/table/tbody/tr/td/div[37]/span/span[1]/span/ul/li/input");
	By tenancy=By.xpath("//select[@id='Tenancy']");
	By occupancy=By.xpath("//input[@id='Occupancy']");
	By thirdParty=By.xpath("//input[@id='TenantsThirdPartyLeasePct']");
	By tenants=By.xpath("//input[@id='Tenants']");
	By proposedChangeinUse=By.xpath("//input[@id='HasUseChange1']");
	By groundLease=By.xpath("//input[@id='HasGroundLease1']");
	By listedforSale=By.xpath("//input[@id='IsForSale1']");
	By pendingorRecentSale=By.xpath("//input[@id='HasRecentSale1']");
	By proposedUse=By.xpath("//input[@id='ProposedUse']");
	By groundLeaseDesc=By.xpath("//input[@id='GroundLeaseDesc']");
	By listedSaleBrokerCnt=By.xpath("//input[@id='ListedSaleBrokerCnt']");
	By listPrice=By.xpath("//input[@id='ListPrice']");
	By pendingSaleBrokerCnt=By.xpath("//input[@id='PendingSaleBrokerCnt']");
	By salePrice=By.xpath("//input[@id='SalePrice']");
	By saleDate=By.xpath("//input[@id='SaleDate']");
	By propertyDescription=By.xpath("//textarea[@id='PropertyDescription']");
	By comments=By.xpath("//textarea[@id='Comments']");
	By submitServiceRequest=By.xpath("//input[@id='submitServiceRequest']");
	
	By closeButton=By.xpath("//a[@title='Close']");
	
	Calendar o;
	public Excel e;
	
	public WebDriver driver;
	
	public SrfPage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public void RESCreateLoan() throws Exception
	{		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(sRFpage));
		//Thread.sleep(10000);
		//driver.switchTo().frame(driver.findElement(sRFpage));
		Thread.sleep(10000);
		
		RESTransactionTab();
		RESCollateralTab();
	}
	
	public void validateCloseButton()
	{
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement closebutton=driver.findElement(closeButton);
		wait.until(ExpectedConditions.visibilityOf(closebutton)); //this will wait for elememt to be visible for 30 seconds
		closebutton.click();
	}
	
	private void RESTransactionTab() throws Exception
	{
		
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		driver.findElement(projectName).sendKeys(e.ReadExcel("JPMC", 5, 1));
		driver.findElement(loanNumber).sendKeys(e.ReadExcel("JPMC", 5, 2));
		driver.findElement(loanAmount).sendKeys(e.ReadExcel("JPMC", 5, 3));
		driver.findElement(borrowerName).sendKeys(e.ReadExcel("JPMC", 5, 4));
		driver.findElement(eCID).sendKeys(e.ReadExcel("JPMC", 5, 5));
		driver.findElement(anticipatedClosingDateCalendar).click();
		String AnticipatedClosingDate=e.ReadExcel("JPMC", 5, 6);

		String[] t;
		String dd;
		String mm;
		String yy;
		t=AnticipatedClosingDate.split("-");
		 
		dd=t[2];
		mm=t[1];
		yy=t[0];
		
		o=new Calendar(driver);
		o.SelectDates(dd,mm,yy);
		Thread.sleep(3000);
		
		String DesiredReviewDeliveryDate=e.ReadExcel("JPMC", 5, 7);
		t=DesiredReviewDeliveryDate.split("-");
		 
		dd=t[2];
		mm=t[1];
		yy=t[0];
		
		driver.findElement(desiredDateCalendar).click();
		o.SelectDates(dd,mm,yy);
		Thread.sleep(2000);		
		driver.findElement(isSbaLoanRadioButton).click();
		//w.WaitForSomeTime();
	
		Select s4=new Select(driver.findElement(sbaTypeDropdown));
		s4.selectByValue(e.ReadExcel("JPMC", 5, 8));
		//w.WaitForSomeTime();
		
		driver.findElement(intendedUsers).sendKeys(e.ReadExcel("JPMC", 5, 9));
		//w.WaitForSomeTime();
		driver.findElement(cDCPartners).sendKeys(e.ReadExcel("JPMC", 5, 10));
		
		//Participation/Syndication
		
		driver.findElement(participationSyndication).click();
		//w.WaitForSomeTime();
		driver.findElement(aggregateLoanAmount).sendKeys(e.ReadExcel("JPMC", 5, 12));
		driver.findElement(jPMCShare).sendKeys(e.ReadExcel("JPMC", 5, 13));
		driver.findElement(administrativeAgent).click();
		driver.findElement(otherBanks).sendKeys(e.ReadExcel("JPMC", 5, 15));
		driver.findElement(priorJob).sendKeys(e.ReadExcel("JPMC", 5, 16));
		
		//Upload File On SRF
		
		driver.findElement(browseFileButton).click();
		Thread.sleep(3000);
		try {
		Runtime.getRuntime().exec("src//test//resources//FileUploadScriptSRF.exe");
		}catch(Exception e) {
			
		}
		//Select data in the Drop down
		Thread.sleep(6000);
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");		
		Thread.sleep(2000);
		driver.findElement(requesterAID).click();
		driver.findElement(textbox).sendKeys(e.ReadExcel("JPMC", 5, 17));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 5, 17)+"')]")).click();
		driver.findElement(accountOfficerAID).click();
		driver.findElement(textbox).sendKeys(e.ReadExcel("JPMC", 5, 18));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 5, 18)+"')]")).click();
		Thread.sleep(3000);
		driver.findElement(teamLeadAID).click();
		driver.findElement(teamLeadAID).sendKeys(e.ReadExcel("JPMC", 5, 19));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 5, 19)+"')]")).click();
	
		/*WebElement uploadElement = driver.findElement(BrowseFileButton);
        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\AjayP\\Desktop\\Collateral360\\Upload sample\\FILENAME1.pdf");*/
	}
	
	
	private void RESCollateralTab() throws InterruptedException
	{
		driver.findElement(moveToCollateralTab).click();
		
	    Select s5=new Select(driver.findElement(propertyType));
		s5.selectByValue(e.ReadExcel("JPMC", 9, 1));
		//w.WaitForSomeTime();
		
		Select s6=new Select(driver.findElement(propertySubType));
		s6.selectByVisibleText(e.ReadExcel("JPMC", 9, 2));
	
		Select s7=new Select(driver.findElement(country));
		s7.selectByValue(e.ReadExcel("JPMC", 9, 3));
		
		driver.findElement(address).sendKeys(e.ReadExcel("JPMC", 9, 4));
		driver.findElement(secondaryStreetAddress).sendKeys(e.ReadExcel("JPMC", 9, 5));
		driver.findElement(suitFloorUnit).sendKeys(e.ReadExcel("JPMC", 9, 6));
		driver.findElement(city).sendKeys(e.ReadExcel("JPMC", 9, 7));
		Select s8=new Select(driver.findElement(state));
		s8.selectByValue(e.ReadExcel("JPMC", 9, 8));
		//w.WaitForSomeTime();
		driver.findElement(mAPPROPERTYButton).click();
		Thread.sleep(6000);
		
		driver.findElement(apn).sendKeys(e.ReadExcel("JPMC", 9, 9));
		
		//Services
		String Services="2";
		
		if(Services.equalsIgnoreCase("2"))
		{
			driver.findElement(vALService).click();
			//w.WaitForSomeTime();
			driver.findElement(eNVService).click();
			Select s9=new Select(driver.findElement(purposeVAL));
			s9.selectByValue(e.ReadExcel("JPMC", 9, 10));
			Select s10=new Select(driver.findElement(creditTransactionTypeAppraisal));
			s10.selectByVisibleText(e.ReadExcel("JPMC", 9, 11));
			Select s11=new Select(driver.findElement(appraisalPriority));
			s11.selectByValue(e.ReadExcel("JPMC", 9, 12));
			driver.findElement(oFSIReport).click();
			
			for(int i=1;i<=5;i++)
			{
				driver.findElement(By.xpath("//input[@id='PropInterest"+i+"']")).click();
			}
			for(int i=1;i<=7;i++)
			{
				driver.findElement(By.xpath("//input[@id='ValuationPremise"+i+"']")).click();
			}
			
		//w.WaitForSomeTime();	
		driver.findElement(propInterestOther).sendKeys(e.ReadExcel("JPMC", 9, 13));
		//w.WaitForSomeTime();
		driver.findElement(valuationPremiseOther).sendKeys(e.ReadExcel("JPMC", 9, 14));
		Select s12=new Select(driver.findElement(purposeENV));
		s12.selectByValue(e.ReadExcel("JPMC", 9, 15));
		Select s13=new Select(driver.findElement(creditTransactionTypeEnvironmental));
		s13.selectByVisibleText(e.ReadExcel("JPMC", 9, 16));
		Select s14=new Select(driver.findElement(environmentalPriority));
		s14.selectByValue(e.ReadExcel("JPMC", 9, 17));
		
		}
		else if(Services.equalsIgnoreCase("Valuation"))
		{
			driver.findElement(vALService).click();
		}
		else
		{
			driver.findElement(eNVService).click();
		}
		
		//Property Contact section
		
		Select s15=new Select(driver.findElement(contactType));
		s15.selectByValue(e.ReadExcel("JPMC", 9, 18));
		
		driver.findElement(contactCompany).sendKeys(e.ReadExcel("JPMC", 9, 19));

		driver.findElement(contactName).sendKeys(e.ReadExcel("JPMC", 9, 20));

		driver.findElement(contactPhone).sendKeys(e.ReadExcel("JPMC", 9, 21));

		driver.findElement(contactEmail).sendKeys(e.ReadExcel("JPMC", 9, 22));

		driver.findElement(contactAltPhone).sendKeys(e.ReadExcel("JPMC", 9, 23));
		
		driver.findElement(numBuildings).sendKeys(e.ReadExcel("JPMC", 9, 24));
		driver.findElement(buildingSize).sendKeys(e.ReadExcel("JPMC", 9, 25));
		driver.findElement(improvementsizeAsIsAlt).sendKeys(e.ReadExcel("JPMC", 9, 26));
		driver.findElement(buildingSizeCompleted).sendKeys(e.ReadExcel("JPMC", 9, 27));
		driver.findElement(improvementsizeAsCompletedAlt).sendKeys(e.ReadExcel("JPMC", 9, 28));
		driver.findElement(landSize).sendKeys(e.ReadExcel("JPMC", 9, 28));
		driver.findElement(excessLand1).click();
		driver.findElement(yearBuilt).sendKeys(e.ReadExcel("JPMC", 9, 29));
		driver.findElement(lastRenovated).sendKeys(e.ReadExcel("JPMC", 9, 30));
		
		Select s16=new Select(driver.findElement(tenancy));
		s16.selectByValue(e.ReadExcel("JPMC", 9, 31));
		
		//w.WaitForSomeTime();
		driver.findElement(occupancy).sendKeys(e.ReadExcel("JPMC", 9, 32));
		driver.findElement(thirdParty).sendKeys(e.ReadExcel("JPMC", 9, 33));
		driver.findElement(tenants).sendKeys(e.ReadExcel("JPMC", 9, 34));
		
		driver.findElement(hasRenovation1).click();
		driver.findElement(renevationDesc).sendKeys(e.ReadExcel("JPMC", 9, 35));
		driver.findElement(zoning).sendKeys(e.ReadExcel("JPMC", 9, 36));
	
	
		driver.findElement(propertyStatus).click();
		driver.findElement(propertyStatus).sendKeys(e.ReadExcel("JPMC", 9, 37));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 9, 37)+"')]")).click();
		
		
		
		driver.findElement(proposedChangeinUse).click();
		driver.findElement(proposedUse).sendKeys(e.ReadExcel("JPMC", 9, 38));
		
		driver.findElement(groundLease).click();
		driver.findElement(groundLeaseDesc).sendKeys(e.ReadExcel("JPMC", 9, 39));
		
		driver.findElement(listedforSale).click();
		driver.findElement(listedSaleBrokerCnt).sendKeys(e.ReadExcel("JPMC", 9, 40));
		driver.findElement(listPrice).sendKeys(e.ReadExcel("JPMC", 9, 41));
		
		driver.findElement(pendingorRecentSale).click();
		
		driver.findElement(pendingSaleBrokerCnt).sendKeys(e.ReadExcel("JPMC", 9, 42));
		driver.findElement(salePrice).sendKeys(e.ReadExcel("JPMC", 9, 43));
		
		driver.findElement(saleDate).click();
		String DateSold=e.ReadExcel("JPMC", 9, 44);
		String[] t;
		String dd;
		String mm;
		String yy;
		t=DateSold.split("-");
		 
		dd=t[2];
		mm=t[1];
		yy=t[0];
		o.SelectDates(dd, mm, yy);
		Thread.sleep(3000);
		
		driver.findElement(propertyDescription).sendKeys(e.ReadExcel("JPMC", 9, 45));
		driver.findElement(comments).sendKeys(e.ReadExcel("JPMC", 9, 46));
		driver.findElement(submitServiceRequest).click();	
	}
	
}
		
		
		

	

