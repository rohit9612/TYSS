package com.crm.acute.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.crm.acute.pages.HomePage;
import com.crm.acute.pages.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	FileLib fl= new FileLib();
	WebDriverUtils utils= new WebDriverUtils();
	
        @BeforeSuite(groups= {"Smoke","Regression"})
        public void connectToDB() 
        {
	     System.out.println("Connect to DB");
	     System.out.println("Extend Report");
        }
//@BeforeTest(groups= {"Smoke","Regression"}) 
//public void launchBrowser()
//{
//    	
//}

       @BeforeClass(groups= {"Smoke","Regression"})
       public void launchBrowser() throws Exception
       {
    	   String browsername=fl.getDataFromProp("browser");
    	   
    	   //RT polymorphism
    	   if(browsername.equals("firefox"))
               driver= new FirefoxDriver();
    	   else if(browsername.equals("chrome"))
    		   driver= new ChromeDriver();
    	   else if(browsername.equals("ie"))
    		   driver= new InternetExplorerDriver();   
       }
       
       @BeforeMethod(groups= {"Smoke","Regression"})
       public void login() throws Exception
       {
    	  String url =fl.getDataFromProp("URL");
    	  driver.get(url); 
    	  
    	  LoginPage lp= new LoginPage(driver);
    	  utils.waitForElementToLoad(driver);
    	  lp.loginToApp();
    	  System.out.println("Login done");
       }
      @AfterMethod(groups= {"Smoke","Regression"})
      public void Signout()
      {
    	  HomePage hp= new HomePage(driver);
    	  hp.clickSignOut();	  
      }
      
      @AfterClass(groups= {"Smoke","Regression"})
      public void closeBrowser()
      {
    	  System.out.println("Close the browser");
    	 driver.close();   
      }
      
      @AfterSuite(groups= {"Smoke","Regression"})
      public void disconnectToDB() 
      {
	     System.out.println("disConnect to DB");
	     System.out.println("Result");
      }
}
