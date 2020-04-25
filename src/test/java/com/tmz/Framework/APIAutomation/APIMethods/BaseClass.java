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
import com.tmz.Framework.UIAutomation.Utilities.SendSMS;
import com.tmz.Framework.UIAutomation.Utilities.Sendmail;
import com.twilio.Twilio;

public class BaseClass {
	public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    DateTime dt= new DateTime();
    String FileName="API_AutomationReport"+dt.Getcurrentdatetime1()+".html";
	SendSMS sm=new SendSMS();
	Sendmail mail=new Sendmail();
	
	@BeforeSuite(alwaysRun=true)
    public void initialize() throws Exception
    {
    	//System.out.println("File Path is ===>"+Constants.EXTENT_PATH+FileName);
    	Twilio.init(Constants.ACCOUNT_SID, Constants.AUTH_TOKEN);
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
	    	//String Mail_Body="Hi Below is your Test Summary \n "+"Total Test Cases==>"+APIConstants.TotalTC+"\n"+"  Total PASS==>"+APIConstants.PassTC+"\n"+"  Total FAIL==>"+APIConstants.FailTC+"\n"+"  Total SKIPPED==>"+APIConstants.SkipTC+"\n"+
	    			"For Full Detail please find attached Status report    \n\n\n\n\n\n\n"+"Regards,\n"+"Anuj Kumar Gautam";
	    	//sm.sendMessage("Hi Below is your Test Summary  "+"Total Test Cases==>"+APIConstants.TotalTC+"  Total PASS==>"+APIConstants.PassTC+"  Total FAIL==>"+APIConstants.FailTC+"  Total SKIPPED==>"+APIConstants.SkipTC);
			extent.flush();
			//extent.close();
			
			//mail.sendReport("API Automation Report",Constants.MGR_ID, APIConstants.REPORT_PATH+FileName, Mail_Body);
			
	    }
}
