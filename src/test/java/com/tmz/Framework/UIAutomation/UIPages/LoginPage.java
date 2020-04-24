package com.tmz.Framework.UIAutomation.UIPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmz.Framework.UIAutomation.Utilities.Selenium_Utility;




public class LoginPage {
	Selenium_Utility utility;
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(name = "uid")

	WebElement user99GuruName;

	@FindBy(name = "password")

	WebElement password99Guru;

	@FindBy(className = "barone")

	WebElement titleText;

	@FindBy(name = "btnLogin")

	WebElement login;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		  AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory (driver,100);
	        PageFactory.initElements(factory, this);

	}

	public void setUsername(String uname) {
		 utility = new Selenium_Utility (driver);
		  wait=new WebDriverWait(driver,30);
		 utility.ExplicitWait(wait, "ElementVisible", By.name("uid"));
		WebElement E1= utility.findelement(By.name("uid"));
		E1.sendKeys(uname);
	}

	public void setPassword(String pwd) {
		password99Guru.sendKeys(pwd);
	}

	public void clickloginbtn() {

		login.click();
	}

	public String getTitle() {

		String title = titleText.getText();
		return title;
	}

	public void loginToGuru99(String strUserName, String strPasword) {

		// Fill user name

		this.setUsername(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickloginbtn();

	}

}
