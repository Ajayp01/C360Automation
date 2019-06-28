package collateral.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.collateral360.JPMC.RES.Pages.LoginPage;
import com.collateral360.qa.utilities.Base;

public class LoginPageTest{
			
			
	public WebDriver driver;			
	LoginPage loginPageObj;
	Base baseObj;
	
	@BeforeMethod
	public void setup() throws Exception
	{
		baseObj=new Base(driver);
		driver=baseObj.initialization("Collateral");
		loginPageObj=new LoginPage(driver);
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String currentTitle=loginPageObj.validateLoginPageTitle();
		Assert.assertEquals(currentTitle, "Collateral360");
	}
	
	@Test(priority=2)
	public void signTest() throws Exception
	{
		loginPageObj.SignIn();
 	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		System.out.println(" Passed: "  + result.getMethod().getMethodName());
		driver.quit();
	}

}
