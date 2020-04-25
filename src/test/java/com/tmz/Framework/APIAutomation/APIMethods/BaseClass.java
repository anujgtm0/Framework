package com.tmz.Framework.APIAutomation.APIMethods;

import java.io.File;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.tmz.Framework.APIAutomation.APIUtilities.APIConstants;
import com.tmz.Framework.UIAutomation.Utilities.Constants;
import com.tmz.Framework.UIAutomation.Utilities.DateTime;

import com.twilio.Twilio;

public class BaseClass {
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    DateTime dt= new DateTime();
    String FileName="API_AutomationReport"+dt.Getcurrentdatetime1()+".html";
	
	
	@BeforeSuite(alwaysRun=true)
    public void initialize() throws Exception
    {
    
    	extent = new ExtentReports (APIConstants.REPORT_PATH+FileName, true);
		 extent
        .addSystemInfo("Host Name", "Tekmindz")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "Anuj Kumar Gautam");
    	

         


        extent.loadConfig(new File(Constants.EXTENT_XMLPATH));
    }
     



	 @AfterSuite
	    public void aftersuite() throws Exception
	    {
	    	
			extent.flush();
			//extent.close();
			
			
			
	    }
}
