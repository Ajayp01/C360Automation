package collateral.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.AdminDashboardPage;
import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.qa.utilities.Base;

public class AdminDashboardPageTest{
	
     public WebDriver driver;
	 AdminDashboardPage adminDashboardPageObj;
	 LoginPage loginPageObj;
	 String aid=null;
	
	 
	@BeforeMethod
	public void setup() throws Exception
	{
		Base b=new Base(driver);
		driver=b.initialization("Collateral");
		loginPageObj=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loggedUserNameTest()
	{
		String UserName=adminDashboardPageObj.validateLoggedUserName();
		Assert.assertEquals(UserName, "AJAY", "User name did not match");
	}
	
	@Test(priority=2)
	public void impersonateTest() throws Exception
	{
		adminDashboardPageObj.Impersonate("collateral",aid);
	} 
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println("Passed  " + result.getMethod().getMethodName());
		driver.quit();
	}
	
	
	
	
	
	
	
}
