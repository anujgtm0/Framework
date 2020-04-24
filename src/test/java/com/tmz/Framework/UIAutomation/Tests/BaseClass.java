package com.tmz.Framework.UIAutomation.Tests;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tmz.Framework.UIAutomation.Utilities.Constants;
import com.tmz.Framework.UIAutomation.Utilities.DateTime;
import com.tmz.Framework.UIAutomation.Utilities.SendSMS;
import com.tmz.Framework.UIAutomation.Utilities.Sendmail;
import com.twilio.Twilio;


public class BaseClass {
	public static WebDriver driver = null;
	String Browser=Constants.BROWSER_NAME;
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    DateTime dt= new DateTime();
    String FileName="UI Automation_Report"+dt.Getcurrentdatetime1()+".html";
	SendSMS sm=new SendSMS();
	Sendmail mail=new Sendmail();
	
	@BeforeSuite(alwaysRun=true)
    public void initialize() throws Exception
    {
    	System.out.println("File Path is ===>"+Constants.EXTENT_PATH+FileName);
    	Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
    	extent = new ExtentReports (Constants.EXTENT_PATH+FileName, true);
		 extent
        .addSystemInfo("Host Name", "Tekmindz")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "Anuj Kumar Gautam");
    	

         


        extent.loadConfig(new File(Constants.EXTENT_XMLPATH));
    }
     
	public BaseClass() {
		if (driver == null) {
			if(Browser.equalsIgnoreCase("Chrome")){
			// Mention path of chrome driver of your system
			System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("**Chrome driver initiated**");
			}
			
			else if (Browser.equalsIgnoreCase("Firefox")){
				System.setProperty("webdriver.gecko.driver", Constants.FIREFOXDRIVER_PATH);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				System.out.println("**FireFox driver initiated**");
			}
		} else {
			System.out.println("** driver already instantiated**");
		}
	}

	public static WebDriver getdriver() {
		if (driver == null) {
			return driver;
		} else {
			return driver;
		}
	}


	 @AfterSuite
	    public void aftersuite() throws Exception
	    {
	    	String Mail_Body="Hi Below is your Test Summary \n "+"Total Test Cases==>"+Constants.TotalTC+"\n"+"  Total PASS==>"+Constants.PassTC+"\n"+"  Total FAIL==>"+Constants.FailTC+"\n"+"  Total SKIPPED==>"+Constants.SkipTC+"\n"+
	    			"For Full Detail please find attached Status report    \n\n\n\n\n\n\n"+"Regards,\n"+"Anuj Kumar Gautam";
	    	sm.sendMessage("Hi Below is your Test Summary  "+"Total Test Cases==>"+Constants.TotalTC+"  Total PASS==>"+Constants.PassTC+"  Total FAIL==>"+Constants.FailTC+"  Total SKIPPED==>"+Constants.SkipTC);
			extent.flush();
			//extent.close();
			
			mail.sendReport("UI Automation Report",Constants.MGR_ID, Constants.EXTENT_PATH+FileName, Mail_Body);
			driver.quit();
	    }
}
