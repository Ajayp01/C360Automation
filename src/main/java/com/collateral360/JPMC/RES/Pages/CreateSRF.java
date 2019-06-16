package com.collateral360.JPMC.RES.Pages;

/* 
 * 
 * AJ
 * 
 * 
 */
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.collateral360.qa.utilities.Calendar;
import com.collateral360.qa.utilities.Excel;
import com.collateral360.qa.utilities.Wait;

public class CreateSRF {

	
	//Transaction Tab
	
	By CreateLoanButton=By.xpath("//a[@data-title='Create New Request']");
	By SRFpage=By.xpath("//iframe[@name='sb-player']");
	By ProjectName=By.xpath("//input[@id='ProjectName']");
	By LoanNumber=By.xpath("//input[@id='LoanNumber']");
	By LoanAmount=By.xpath("//input[@id='LoanAmount']");
	By BorrowerName=By.xpath("//input[@id='BorrowerName']");
	By ECID=By.xpath("//input[@id='ecid']");
	By AnticipatedClosingDateCalendar=By.xpath("//input[@id='ClosingDate']");
	By DesiredDateCalendar=By.xpath("//input[@id='DesiredReviewDeliveryDate']");
	
	By RequesterAID=By.xpath("//span[@aria-labelledby='select2-RequesterAID-container']//span[2]");
	By textbox=By.xpath("//span[@class='select2-container select2-container--default select2-container--open']/span/span/input[@class='select2-search__field']");
	By AccountOfficerAID=By.xpath("//span[@aria-labelledby='select2-AccountOfficerAID-container']//span[2]");
	By costcentre=By.xpath("//span[@aria-labelledby='select2-CostCenter-container']//span[2]");	
	By company=By.xpath("//span[@aria-labelledby='select2-CompanyNumber-container']//span[2]");
	By TeamLeadAID=By.xpath("//*[@id='divDealTeamInfo']/fieldset/table/tbody/tr/td/div[3]/span/span[1]/span/ul/li/input");

	By TeamLeadtextbox=By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--focus select2-container--open select2-container--above']//span[@class='select2-selection select2-selection--multiple']//ul/li/input");
	
	By MoveToCollateralTab=By.xpath("//input[@value='Move to Collateral Tab']");
	By BrowseFileButton=By.xpath("//a[@id='srfuploads-select-file']");
	By IsSbaLoanRadioButton=By.xpath("//input[@id='IsSbaLoan1']");
	By sbaTypeDropdown=By.xpath("//select[@id='sbaType']");
	By IntendedUsers=By.xpath("//input[@id='PartnerBusinessName']");
	By CDCPartners=By.xpath("//input[@id='AltPartnerBusinessName']");
	By ParticipationSyndication=By.xpath("//input[@id='IsParticipationLoan1']");
	By AggregateLoanAmount=By.xpath("//input[@id='ParticipationLoanAmount']");
	By JPMCShare=By.xpath("//input[@id='ParticipationLenderShare']");
	By OtherBanks=By.xpath("//input[@id='OtherBanks']");
	By AdministrativeAgent=By.xpath("//input[@id='IsAgentBank1']");
	By PriorJob=By.xpath("//input[@id='PriorJob']");
	
	//Collateral Tab
	
	By PropertyType=By.xpath("//select[@id='PropertyType']");
	By PropertySubType=By.xpath("//select[@id='PropertySubTypeList']");
	By Country=By.xpath("//select[@id='PropCountry']");
	By Address=By.xpath("//input[@id='PropAddress']");
	By SecondaryStreetAddress=By.xpath("//input[@id='SecondaryStreetAddress']");
	By SuitFloorUnit=By.xpath("//input[@id='PropUnit']");
	By City=By.xpath("//input[@id='PropCity']");
	By State=By.xpath("//select[@id='PropState']");
	By MAPPROPERTYButton=By.xpath("//input[@class='coolBtn coolBtn-ocean']");
	By APN=By.xpath("//textarea[@id='PropertyNumbers']");
	By VALService=By.xpath("//input[@value='Valuation']");
	By ENVService=By.xpath("//input[@value='Environmental']");
	By PurposeVAL=By.xpath("//select[@id='Purpose']");
	By AppraisalPriority=By.xpath("//select[@id='AppraisalPriority']");
	By CreditTransactionTypeAppraisal=By.xpath("//select[@id='TransactionTypeList']");
	By OFSIReport=By.xpath("//input[@id='ofsiReportReview1']");
	By PropertyInterestAppraised=By.xpath("//input[@id='PropInterest3']");
	By PropInterestOther=By.xpath("//input[@id='PropInterestOther']");
	By ValuationPremiseOther=By.xpath("//input[@id='ValuationPremiseOther']");
	By PurposeENV=By.xpath("//select[@id='PurposeEnv']");
	By CreditTransactionTypeEnvironmental=By.xpath("//select[@id='TransactionTypeEnvList']");
	By EnvironmentalPriority=By.xpath("//select[@id='EnvironmentalPriority']");
	By ContactType=By.xpath("//select[@id='ContactType']");
	By ContactCompany=By.xpath("//input[@id='ContactCompany']");
	By ContactName=By.xpath("//input[@id='ContactName']");
	By ContactPhone=By.xpath("//input[@id='ContactPhone']");
	By ContactEmail=By.xpath("//input[@id='ContactEmail']");
	By ContactAltPhone=By.xpath("//input[@id='ContactAltPhone']");
	By NumBuildings=By.xpath("//input[@id='NumBuildings']");
	By BuildingSize=By.xpath("//input[@id='BuildingSize']");
	By improvementsizeAsIsAlt=By.xpath("//input[@id='improvementsizeAsIsAlt']");
	By BuildingSizeCompleted=By.xpath("//input[@id='BuildingSizeCompleted']");
	By improvementsizeAsCompletedAlt=By.xpath("//input[@id='improvementsizeAsCompletedAlt']");
	By LandSize=By.xpath("//input[@id='LandSize']");
	By ExcessLand1=By.xpath("//input[@id='ExcessLand1']");
	By YearBuilt=By.xpath("//input[@id='YearBuilt']");
	By LastRenovated=By.xpath("//input[@id='LastRenovated']");
	By HasRenovation1=By.xpath("//input[@id='HasRenovation1']");
	By RenevationDesc=By.xpath("//input[@id='RenevationDesc']");
	By Zoning=By.xpath("//input[@id='Zoning']");
	By PropertyStatus=By.xpath("//*[@id='div']/fieldset/table/tbody/tr/td/div[37]/span/span[1]/span/ul/li/input");
	By Tenancy=By.xpath("//select[@id='Tenancy']");
	By Occupancy=By.xpath("//input[@id='Occupancy']");
	By ThirdParty=By.xpath("//input[@id='TenantsThirdPartyLeasePct']");
	By Tenants=By.xpath("//input[@id='Tenants']");
	By ProposedChangeinUse=By.xpath("//input[@id='HasUseChange1']");
	By GroundLease=By.xpath("//input[@id='HasGroundLease1']");
	By ListedforSale=By.xpath("//input[@id='IsForSale1']");
	By PendingorRecentSale=By.xpath("//input[@id='HasRecentSale1']");
	By ProposedUse=By.xpath("//input[@id='ProposedUse']");
	By GroundLeaseDesc=By.xpath("//input[@id='GroundLeaseDesc']");
	By ListedSaleBrokerCnt=By.xpath("//input[@id='ListedSaleBrokerCnt']");
	By ListPrice=By.xpath("//input[@id='ListPrice']");
	By PendingSaleBrokerCnt=By.xpath("//input[@id='PendingSaleBrokerCnt']");
	By SalePrice=By.xpath("//input[@id='SalePrice']");
	By SaleDate=By.xpath("//input[@id='SaleDate']");
	By PropertyDescription=By.xpath("//textarea[@id='PropertyDescription']");
	By Comments=By.xpath("//textarea[@id='Comments']");
	By submitServiceRequest=By.xpath("//input[@id='submitServiceRequest']");
	
	
	
	Calendar o;
	public Excel e;
	
	public WebDriver driver;
	
	public CreateSRF(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public void RESCreateLoan() throws Exception
	{
		driver.findElement(CreateLoanButton).click();
		Thread.sleep(10000);
		driver.switchTo().frame(driver.findElement(SRFpage));
		Thread.sleep(10000);
		
		RESTransactionTab();
		RESCollateralTab();
	}
	
	
	public void RESTransactionTab() throws Exception
	{
		
		e=new Excel("src\\test\\resources\\CollateralData.xlsx");
		driver.findElement(ProjectName).sendKeys(e.ReadExcel("JPMC", 5, 1));
		driver.findElement(LoanNumber).sendKeys(e.ReadExcel("JPMC", 5, 2));
		driver.findElement(LoanAmount).sendKeys(e.ReadExcel("JPMC", 5, 3));
		driver.findElement(BorrowerName).sendKeys(e.ReadExcel("JPMC", 5, 4));
		driver.findElement(ECID).sendKeys(e.ReadExcel("JPMC", 5, 5));
		driver.findElement(AnticipatedClosingDateCalendar).click();
		
		
		//String Characters
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
		
		driver.findElement(DesiredDateCalendar).click();
		o.SelectDates(dd,mm,yy);
		Thread.sleep(2000);
		//w.WaitForSomeTime();
		//Radio buttons
		
		driver.findElement(IsSbaLoanRadioButton).click();
		//w.WaitForSomeTime();
	
		Select s4=new Select(driver.findElement(sbaTypeDropdown));
		s4.selectByValue(e.ReadExcel("JPMC", 5, 8));
		//w.WaitForSomeTime();
		
		driver.findElement(IntendedUsers).sendKeys(e.ReadExcel("JPMC", 5, 9));
		//w.WaitForSomeTime();
		driver.findElement(CDCPartners).sendKeys(e.ReadExcel("JPMC", 5, 10));
		
		//Participation/Syndication
		
		driver.findElement(ParticipationSyndication).click();
		//w.WaitForSomeTime();
		driver.findElement(AggregateLoanAmount).sendKeys(e.ReadExcel("JPMC", 5, 12));
		driver.findElement(JPMCShare).sendKeys(e.ReadExcel("JPMC", 5, 13));
		driver.findElement(AdministrativeAgent).click();
		driver.findElement(OtherBanks).sendKeys(e.ReadExcel("JPMC", 5, 15));
		driver.findElement(PriorJob).sendKeys(e.ReadExcel("JPMC", 5, 16));
		
		//Upload File On SRF
		
		driver.findElement(BrowseFileButton).click();
		Thread.sleep(3000);
		try {
		Runtime.getRuntime().exec("src//test//resources//FileUploadScriptSRF.exe");
		}catch(Exception e) {
			
		}
		//Select data in the Drop down
		
		Thread.sleep(6000);
		
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");		
		Thread.sleep(2000);
		driver.findElement(RequesterAID).click();
		driver.findElement(textbox).sendKeys(e.ReadExcel("JPMC", 5, 17));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 5, 17)+"')]")).click();
		
		driver.findElement(AccountOfficerAID).click();
		driver.findElement(textbox).sendKeys(e.ReadExcel("JPMC", 5, 18));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 5, 18)+"')]")).click();
		Thread.sleep(3000);
		driver.findElement(TeamLeadAID).click();
		driver.findElement(TeamLeadAID).sendKeys(e.ReadExcel("JPMC", 5, 19));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 5, 19)+"')]")).click();
	
		/*WebElement uploadElement = driver.findElement(BrowseFileButton);
        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\AjayP\\Desktop\\Collateral360\\Upload sample\\FILENAME1.pdf");*/
	}
	
	
	public void RESCollateralTab() throws InterruptedException
	{
		driver.findElement(MoveToCollateralTab).click();
		
	    Select s5=new Select(driver.findElement(PropertyType));
		s5.selectByValue(e.ReadExcel("JPMC", 9, 1));
		//w.WaitForSomeTime();
		
		Select s6=new Select(driver.findElement(PropertySubType));
		s6.selectByVisibleText(e.ReadExcel("JPMC", 9, 2));
	
		Select s7=new Select(driver.findElement(Country));
		s7.selectByValue(e.ReadExcel("JPMC", 9, 3));
		
		driver.findElement(Address).sendKeys(e.ReadExcel("JPMC", 9, 4));
		driver.findElement(SecondaryStreetAddress).sendKeys(e.ReadExcel("JPMC", 9, 5));
		driver.findElement(SuitFloorUnit).sendKeys(e.ReadExcel("JPMC", 9, 6));
		driver.findElement(City).sendKeys(e.ReadExcel("JPMC", 9, 7));
		Select s8=new Select(driver.findElement(State));
		s8.selectByValue(e.ReadExcel("JPMC", 9, 8));
		//w.WaitForSomeTime();
		driver.findElement(MAPPROPERTYButton).click();
		Thread.sleep(6000);
		
		driver.findElement(APN).sendKeys(e.ReadExcel("JPMC", 9, 9));
		
		//Services
		String Services="2";
		
		if(Services.equalsIgnoreCase("2"))
		{
			driver.findElement(VALService).click();
			//w.WaitForSomeTime();
			driver.findElement(ENVService).click();
			Select s9=new Select(driver.findElement(PurposeVAL));
			s9.selectByValue(e.ReadExcel("JPMC", 9, 10));
			Select s10=new Select(driver.findElement(CreditTransactionTypeAppraisal));
			s10.selectByVisibleText(e.ReadExcel("JPMC", 9, 11));
			Select s11=new Select(driver.findElement(AppraisalPriority));
			s11.selectByValue(e.ReadExcel("JPMC", 9, 12));
			driver.findElement(OFSIReport).click();
			
			for(int i=1;i<=5;i++)
			{
				driver.findElement(By.xpath("//input[@id='PropInterest"+i+"']")).click();
			}
			for(int i=1;i<=7;i++)
			{
				driver.findElement(By.xpath("//input[@id='ValuationPremise"+i+"']")).click();
			}
			
		//w.WaitForSomeTime();	
		driver.findElement(PropInterestOther).sendKeys(e.ReadExcel("JPMC", 9, 13));
		//w.WaitForSomeTime();
		driver.findElement(ValuationPremiseOther).sendKeys(e.ReadExcel("JPMC", 9, 14));
		Select s12=new Select(driver.findElement(PurposeENV));
		s12.selectByValue(e.ReadExcel("JPMC", 9, 15));
		Select s13=new Select(driver.findElement(CreditTransactionTypeEnvironmental));
		s13.selectByVisibleText(e.ReadExcel("JPMC", 9, 16));
		Select s14=new Select(driver.findElement(EnvironmentalPriority));
		s14.selectByValue(e.ReadExcel("JPMC", 9, 17));
		
		}
		else if(Services.equalsIgnoreCase("Valuation"))
		{
			driver.findElement(VALService).click();
		}
		else
		{
			driver.findElement(ENVService).click();
		}
		
		//Property Contact section
		
		Select s15=new Select(driver.findElement(ContactType));
		s15.selectByValue(e.ReadExcel("JPMC", 9, 18));
		
		driver.findElement(ContactCompany).sendKeys(e.ReadExcel("JPMC", 9, 19));

		driver.findElement(ContactName).sendKeys(e.ReadExcel("JPMC", 9, 20));

		driver.findElement(ContactPhone).sendKeys(e.ReadExcel("JPMC", 9, 21));

		driver.findElement(ContactEmail).sendKeys(e.ReadExcel("JPMC", 9, 22));

		driver.findElement(ContactAltPhone).sendKeys(e.ReadExcel("JPMC", 9, 23));
		
		driver.findElement(NumBuildings).sendKeys(e.ReadExcel("JPMC", 9, 24));
		driver.findElement(BuildingSize).sendKeys(e.ReadExcel("JPMC", 9, 25));
		driver.findElement(improvementsizeAsIsAlt).sendKeys(e.ReadExcel("JPMC", 9, 26));
		driver.findElement(BuildingSizeCompleted).sendKeys(e.ReadExcel("JPMC", 9, 27));
		driver.findElement(improvementsizeAsCompletedAlt).sendKeys(e.ReadExcel("JPMC", 9, 28));
		driver.findElement(LandSize).sendKeys(e.ReadExcel("JPMC", 9, 28));
		driver.findElement(ExcessLand1).click();
		driver.findElement(YearBuilt).sendKeys(e.ReadExcel("JPMC", 9, 29));
		driver.findElement(LastRenovated).sendKeys(e.ReadExcel("JPMC", 9, 30));
		
		Select s16=new Select(driver.findElement(Tenancy));
		s16.selectByValue(e.ReadExcel("JPMC", 9, 31));
		
		//w.WaitForSomeTime();
		driver.findElement(Occupancy).sendKeys(e.ReadExcel("JPMC", 9, 32));
		driver.findElement(ThirdParty).sendKeys(e.ReadExcel("JPMC", 9, 33));
		driver.findElement(Tenants).sendKeys(e.ReadExcel("JPMC", 9, 34));
		
		driver.findElement(HasRenovation1).click();
		driver.findElement(RenevationDesc).sendKeys(e.ReadExcel("JPMC", 9, 35));
		driver.findElement(Zoning).sendKeys(e.ReadExcel("JPMC", 9, 36));
	
	
		driver.findElement(PropertyStatus).click();
		driver.findElement(PropertyStatus).sendKeys(e.ReadExcel("JPMC", 9, 37));
		driver.findElement(By.xpath("//li[contains(text(),'"+e.ReadExcel("JPMC", 9, 37)+"')]")).click();
		
		
		
		driver.findElement(ProposedChangeinUse).click();
		driver.findElement(ProposedUse).sendKeys(e.ReadExcel("JPMC", 9, 38));
		
		driver.findElement(GroundLease).click();
		driver.findElement(GroundLeaseDesc).sendKeys(e.ReadExcel("JPMC", 9, 39));
		
		driver.findElement(ListedforSale).click();
		driver.findElement(ListedSaleBrokerCnt).sendKeys(e.ReadExcel("JPMC", 9, 40));
		driver.findElement(ListPrice).sendKeys(e.ReadExcel("JPMC", 9, 41));
		
		driver.findElement(PendingorRecentSale).click();
		
		driver.findElement(PendingSaleBrokerCnt).sendKeys(e.ReadExcel("JPMC", 9, 42));
		driver.findElement(SalePrice).sendKeys(e.ReadExcel("JPMC", 9, 43));
		
		driver.findElement(SaleDate).click();
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
		
		driver.findElement(PropertyDescription).sendKeys(e.ReadExcel("JPMC", 9, 45));
		driver.findElement(Comments).sendKeys(e.ReadExcel("JPMC", 9, 46));
		driver.findElement(submitServiceRequest).click();	
	}
	
}
		
		
		

	

