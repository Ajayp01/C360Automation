package collateral.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.collateral360.JPMC.RES.Pages.*;

import com.collateral360.qa.utilities.Base;
import com.collateral360.qa.utilities.Excel;
import com.parcel.pages.AllProjects;
import com.parcel.pages.PARCELDashboard;
import com.parcel.pages.ProjectDetails;
/*
 * AJ
 */

public class SrfTest {
	
	
	public WebDriver driver;
	public WebDriver driver2;
	public String aid;
	LoginPage loginPageObj;
	Base b;
	AdminDashboardPage adminDashboardPageObj;
	DashboardPage dashboardPage;
	SrfPage l;
	
	@BeforeTest
	public void setup() throws Exception
	{
		b=new Base(driver);
		driver=b.initialization("Collateral");
		loginPageObj=new LoginPage(driver);
		loginPageObj.SignIn();
		adminDashboardPageObj.Impersonate("collateral", aid);
		dashboardPage.clickOnCreateRequestButton();	
	}
	
	@Test(priority=1)
	public void RESCreateSRF() throws Exception
	{
		l=new SrfPage(driver);
		
		l.RESCreateLoan();
	}
	//@Test(priority=3)
	public void IsSRFCreated() throws Exception
	{
		DashboardPage d=new DashboardPage(driver);
		d.VerifyCreatedLoan();
		
	}
	
	//@Test(priority=4)
	public void OpenLoanCreated() throws Exception 
	{
		DashboardPage d=new DashboardPage(driver);
		d.VerifyCreatedLoan();
		d.OpenLoan();
		
	}
	
	//@Test(priority=5)
	public void OpenExistingLoan() 
	{
		DashboardPage d=new DashboardPage(driver);
		
		
	}
	
	//@Test(priority=6)
	public void Taskpipeline() throws Exception
	
	{
		CollateralOverview j=new CollateralOverview(driver);
		j.AddNewServices();
		j.CheckServicesAddedOrNOT();
	}
	
    //@Test(priority=7)
	public void CreateRFP() throws Exception
	{
		RFP r=new RFP(driver);
		r.CheckService();
		r.OpenRFPPage();
		aid=r.EnterDataOnRfpForm();
		r.submitRFPP();
		r.AttachEngagementLetter();
		ReportStatusPage s=new ReportStatusPage(driver);
		s.CheckRFPStatus(1);
	}
   
   //@Test(priority=8)
	public void UpdateRFP() throws Exception
	{
		RFP u=new RFP(driver);
		u.CheckService();
		u.OpenRFPPage();
		aid=u.updateRFP();	
		u.AttachEngagementLetter();
		
	}	
   
    //@Test(priority=9)
	public void OpenPARCEL() throws Exception
	{
    	Base b=new Base(driver2);
		driver2=b.initialization("PARCEL");
		AdminDashboardPage o=new AdminDashboardPage(driver2);
		o.Impersonate("parcel",aid);
	}
	
	//@Test(priority=10)
	public void CheckBidAtPARCEL() throws Exception
	{
		PARCELDashboard p=new PARCELDashboard(driver2);
		p.OpenBid();
	}
	
	//@Test(priority=11)
	public void AcceptAward() throws Exception
	{
		ProjectDetails p=new ProjectDetails(driver2);
		p.AcceptAward();
		ReportStatusPage r=new ReportStatusPage(driver);
		r.CheckRFPStatus(2);
	}
	
	//@Test(priority=12)
	public void SendReport() throws Exception
	{
		AllProjects r=new AllProjects(driver2);
		r.ViewDetails();
		ProjectDetails p=new ProjectDetails(driver2);
		p.SendReport();
	}
	
	//@Test(priority=13)
	public void ReportStatus() throws Exception
	{
		ReportStatusPage r=new ReportStatusPage(driver);
		r.CheckRFPStatus(3);
	}
	
	
	
	
}
