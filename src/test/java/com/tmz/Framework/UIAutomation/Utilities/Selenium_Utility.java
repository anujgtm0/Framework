package com.tmz.Framework.UIAutomation.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium_Utility {
WebDriver driver;
WebDriverWait wait1;
 
	public Selenium_Utility(WebDriver driver){
		this.driver=driver;
		WebDriverWait wait=new WebDriverWait(driver,10);
		
	}
	
	public void selectvaluefromdropdown(WebElement E1,String option , String optionvalue){
		Select dropdown=new Select(E1);
	if(option.equalsIgnoreCase("index")){
		dropdown.selectByIndex(Integer.parseInt(optionvalue));
	}
	else if (option.equalsIgnoreCase("VisibleText")){
		dropdown.selectByVisibleText(optionvalue);
	}
	else if (option.equalsIgnoreCase("Value")){
		dropdown.selectByValue(optionvalue);
	}
	}

	public WebElement findelement(By locator ){
	WebElement E1=driver.findElement(locator);
	
	return E1;
	
}
	
	public void ExplicitWait(WebDriverWait wait,String Condition,By locator){
		this.wait1=wait;
		try{
		if(Condition.equalsIgnoreCase("ElementVisible")){
			
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
		else if(Condition.equalsIgnoreCase("ElementClickable")){
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		}
		catch(Exception e){
			System.out.println("Element not found");
		}
	}
	public void wait(int WaitTime){
		driver.manage().timeouts().implicitlyWait(WaitTime, TimeUnit.SECONDS);
	}
	

}
