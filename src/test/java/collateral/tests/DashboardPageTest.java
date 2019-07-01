package collateral.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.AdminDashboardPage;
import com.collateral360.JPMC.RES.Pages.DashboardPage;
import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.qa.utilities.Base;

public class DashboardPageTest{

	
	 LoginPage loginPageObj;
	 AdminDashboardPage adminDashboardPageObj;
	 public WebDriver driver;
	 String aid=null;
	 DashboardPage dashboardPageObj;
	 
	@BeforeMethod
	public void setup() throws Exception
	{
		Base b=new Base(driver);
		driver=b.initialization("Collateral");
		loginPageObj=new LoginPage(driver);
		loginPageObj.SignIn();
		adminDashboardPageObj=new AdminDashboardPage(driver);
		adminDashboardPageObj.Impersonate("collateral", aid);
	    dashboardPageObj=new DashboardPage(driver);
	}
	
	@Test(priority=1)
	public void dashboardPageTitleTest()
	{
		String currentTitle=dashboardPageObj.dashboardPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test(priority=2)
	public void logoTest() throws InterruptedException
	{
		boolean currentLogo=dashboardPageObj.logo();
		Assert.assertTrue(currentLogo, "Logo not displayed");
	}
	
	
	@Test(priority=3)
	public void CreateRequestButtonTest()
	{
		boolean IsButtonAvailable=dashboardPageObj.validateCreateRequestButton();
		Assert.assertTrue(IsButtonAvailable, "Create Request Button is not available");
	}

	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println("Passed  " + result.getMethod().getMethodName());
		driver.quit();
	}
}
