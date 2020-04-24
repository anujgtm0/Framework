package com.tmz.Framework.UIAutomation.UIPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.tmz.Framework.UIAutomation.Utilities.Selenium_Utility;





public class AddCustomerPage {
	WebDriver driver;
	Selenium_Utility utility;
	
	public AddCustomerPage(WebDriver driver){
		this.driver=driver;
		utility=new Selenium_Utility(driver);
	}

	public void enterCustomerID(String CustID){
		utility.findelement(By.name("cusid")).sendKeys(CustID);
			
	}
	public void SelectAccoutType(String Value){
		WebElement E1=utility.findelement(By.name("selaccount"));
		utility.selectvaluefromdropdown(E1, "Value", Value);
			
	}
	public void initialdeposit(int value){
		utility.findelement(By.name("inideposit")).sendKeys(String.valueOf(value));
		
	}
	public void clickbutton(){
		utility.findelement(By.name("button2")).click();
		
	}
	public void AddAccount(String CustID,String Value,int deposit){
		this.enterCustomerID(CustID);
		this.SelectAccoutType(Value);
		this.initialdeposit(deposit);
		this.clickbutton();
	}
}
