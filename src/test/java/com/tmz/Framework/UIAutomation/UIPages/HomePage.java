package com.tmz.Framework.UIAutomation.UIPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.tmz.Framework.UIAutomation.Utilities.Selenium_Utility;




public class HomePage {
	WebDriver driver;
Selenium_Utility utility;
	@FindBy(xpath="//table//tr[@class='heading3']")

    WebElement homePageUserName;    

    public HomePage(WebDriver driver){

        this.driver = driver;
        utility=new Selenium_Utility(driver);
        //This initElements method will create all WebElements
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory (driver,100);
        PageFactory.initElements(factory, this);

    }   

    //Get the User name from Home Page

        public String getHomePageDashboardUserName(){

         return    homePageUserName.getText();

        }
        public void clickcustomer(){
        	utility.findelement(By.xpath(".//a[@href='addAccount.php']")).click();
        }


}
