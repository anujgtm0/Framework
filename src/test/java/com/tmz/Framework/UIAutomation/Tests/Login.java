package com.tmz.Framework.UIAutomation.Tests;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tmz.Framework.UIAutomation.UIPages.HomePage;
import com.tmz.Framework.UIAutomation.UIPages.LoginPage;
import com.tmz.Framework.UIAutomation.Utilities.Constants;
import com.tmz.Framework.UIAutomation.Utilities.Selenium_Utility;





public class Login extends BaseClass {
	LoginPage lp;
	HomePage hp;
	Selenium_Utility utility;

	@BeforeClass
	public void setup() {

		utility = new Selenium_Utility(driver);
		utility.wait(10);
		driver.get(Constants.APP_URL);

	}

	@Test
	public void TestLogin() {
		Constants.TotalTC++;
		logger = extent.startTest("Verify that Login is successfull and user is on Home page");
		lp = new LoginPage(driver);
		hp = new HomePage(driver);
		String logintitle = lp.getTitle();
		Assert.assertTrue(logintitle.toLowerCase().contains("guru99 bank"));
		lp.loginToGuru99(Constants.USERID, Constants.PASSWORD);
		utility.wait(10);
		String Hometitle = hp.getHomePageDashboardUserName();
		Assert.assertTrue(Hometitle.toLowerCase().contains("manger id : " + Constants.USERID));

	}

	@AfterMethod
	public void aftermethod(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				Constants.PassTC++;

				// D something here
				logger.log(LogStatus.PASS, "Test Case Passed is" + result.getName());
				System.out.println("passed **********");

			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				Constants.FailTC++;
				// Do something here
				System.out.println("Failed ***********");

				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			}

			else if (result.getStatus() == ITestResult.SKIP) {
				Constants.SkipTC++;
				System.out.println("Skiped***********");

				logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			}
			// extent.endTest(logger);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
