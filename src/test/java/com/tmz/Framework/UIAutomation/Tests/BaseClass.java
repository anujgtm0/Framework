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



public class BaseClass {
	public static WebDriver driver = null;
	String Browser=Constants.BROWSER_NAME;
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    DateTime dt= new DateTime();
    String FileName="UI Automation_Report"+dt.Getcurrentdatetime1()+".html";
	
	
	@BeforeSuite(alwaysRun=true)
    public void initialize() throws Exception
    {
    	System.out.println("File Path is ===>"+Constants.EXTENT_PATH+FileName);
    
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
	    	
			extent.flush();
			
			driver.quit();
	    }
}
