package com.tmz.Framework.UIAutomation.Tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.tmz.Framework.UIAutomation.UIPages.AddCustomerPage;
import com.tmz.Framework.UIAutomation.UIPages.HomePage;
import com.tmz.Framework.UIAutomation.Utilities.Constants;
import com.tmz.Framework.UIAutomation.Utilities.Selenium_Utility;





public class AddAccount extends BaseClass {
	HomePage hp;
	Selenium_Utility utility;
	AddCustomerPage acc;

	@BeforeClass
	public void setup() {

		utility = new Selenium_Utility(driver);
		utility.wait(10);

	}

	@Test
	public void AddAcountTest() {
		Constants.TotalTC++;
		logger = extent.startTest("Verify Account is Created Successfully");
		hp = new HomePage(driver);
		acc = new AddCustomerPage(driver);
		hp.clickcustomer();
		int deposit = 1200;
		utility.wait(10);
		acc.AddAccount("97561", "Savings", deposit);
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
