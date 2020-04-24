package com.tmz.Framework.APIAutomation.APIMethods;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tmz.Framework.APIAutomation.APIUtilities.APIConstants;
import com.tmz.Framework.APIAutomation.APIUtilities.RestUtilities;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class Protocol extends BaseClass {
	RestUtilities utility ;
	RequestSpecification reqSpec;
	ResponseSpecification resSpec;
	int protocol_id;

	@BeforeClass
public void setup(){
		utility=new RestUtilities();
	resSpec= RestUtilities.getResponseSpecification();
	reqSpec=RestUtilities.getRequestSpecification();
}

	@Test
public void CreateProtocol(){
		APIConstants.TotalTC++;
		logger = extent.startTest("Verify that a new Protocol is Created");
	RestUtilities.setEndPoint(APIConstants.ENDPOINT);
	Map<String,String>	map= new HashMap<String,String>();
	map.put("name", "OCPP 2.0.1J");
	reqSpec.body(map);
	Response response=RestUtilities.getResponse(reqSpec, "POST");
	//System.out.println(response.body().toString());
	JsonPath js = RestUtilities.getJsonPath(response);
	 protocol_id=js.get("data.id");
	System.out.println(protocol_id);
	
}
	@Test(dependsOnMethods = { "CreateProtocol" })
public void UpdateProtocol(){
		APIConstants.TotalTC++;
		logger = extent.startTest("Verify that Protocol is updated with new name");
	RestUtilities.setEndPoint(APIConstants.ENDPOINT);
	Map<String,Object>	map= new HashMap<String,Object>();
	map.put("name", "OCPP 2.1.1J");
	map.put("id", protocol_id);
	reqSpec.body(map);
	Response response=RestUtilities.getResponse(reqSpec, "PUT");
	//System.out.println(response.body().toString());
	JsonPath js = RestUtilities.getJsonPath(response);
	String protocol_name=js.get("data.name");
	Assert.assertEquals(protocol_name, "OCPP 2.1.1J");
	
}
	@Test(dependsOnMethods = { "UpdateProtocol" })
public void GetProtocol(){
		APIConstants.TotalTC++;
		logger = extent.startTest("Verify that protocol details is fetched with existing ID");
	
	RestUtilities.setEndPoint(APIConstants.ENDPOINT+"/"+protocol_id);
	
	Response response=RestUtilities.getResponse(reqSpec, "GET");
	
	JsonPath js = RestUtilities.getJsonPath(response);
	String protocol_name=js.get("data.name");
	int id=js.get("data.id");
	Assert.assertEquals(id, protocol_id);
	Assert.assertEquals(protocol_name, "OCPP 2.1.1J");
	
}
	@Test(dependsOnMethods = { "GetProtocol" })
public void DeleteProtocol(){
		APIConstants.TotalTC++;
		logger = extent.startTest("Verify that Protocol is deleted successfully");
	RestUtilities.setEndPoint(APIConstants.ENDPOINT+"/"+protocol_id);
	
	Response response=RestUtilities.getResponse(reqSpec, "DELETE");
	
	JsonPath js = RestUtilities.getJsonPath(response);
	String status=js.get("status");
	Assert.assertEquals(status, "SUCCESS");
	
}
	@AfterMethod
	public void aftermethod(ITestResult result) {
		try {
			if (result.getStatus() == ITestResult.SUCCESS) {
				APIConstants.PassTC++;

				// D something here
				logger.log(LogStatus.PASS, "Test Case Passed is" + result.getName());
				System.out.println("passed **********");

			}

			else if (result.getStatus() == ITestResult.FAILURE) {
				APIConstants.FailTC++;
				// Do something here
				System.out.println("Failed ***********");

				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
				logger.log(LogStatus.FAIL, "Test Case Failed is " + result.getThrowable());
			}

			else if (result.getStatus() == ITestResult.SKIP) {
				APIConstants.SkipTC++;
				System.out.println("Skiped***********");

				logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			}
			// extent.endTest(logger);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
