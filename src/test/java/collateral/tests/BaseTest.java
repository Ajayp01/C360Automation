package collateral.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.collateral360.JPMC.RES.Pages.*;

import com.collateral360.qa.utilities.Browser;
import com.collateral360.qa.utilities.Excel;
import com.parcel.pages.AllProjects;
import com.parcel.pages.PARCELDashboard;
import com.parcel.pages.ProjectDetails;


public class BaseTest {
	
	
	static WebDriver driver;
	public WebDriver driver2;
	public String aid;
	
	
	@BeforeTest
	public void StartBrowser() throws Exception
	{
		Browser b=new Browser(driver);
		driver=b.OpenBrowser("Collateral");
	}
	
	@Test(priority=1)
	public void Login() throws Exception
	{
		LoginPage o=new LoginPage(driver);
		o.SignIn();
		o.Impersonate("collateral","");
		
	}
	
	//@Test(priority=2)
	public void RESCreateSRF() throws Exception
	{
		CreateSRF l=new CreateSRF(driver);
		
		l.RESCreateLoan();
	}

	//@Test(priority=2)
	public void CreateSRFINT() throws Exception
	{
		CreateSRFINT k=new CreateSRFINT(driver);
		k.INTCreateLoan();
		
		
	}
	//@Test(priority=3)
	public void IsSRFCreated() throws Exception
	{
		C360Dashboard d=new C360Dashboard(driver);
		d.VerifyCreatedLoan();
		
	}
	
	//@Test(priority=4)
	public void OpenLoanCreated() throws Exception 
	{
		C360Dashboard d=new C360Dashboard(driver);
		d.VerifyCreatedLoan();
		d.OpenLoan();
		
	}
	
	//@Test(priority=5)
	public void OpenExistingLoan() 
	{
		C360Dashboard d=new C360Dashboard(driver);
		
		
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
    	Browser b=new Browser(driver2);
		driver2=b.OpenBrowser("PARCEL");
		LoginPage o=new LoginPage(driver2);
		o.SignIn();
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
