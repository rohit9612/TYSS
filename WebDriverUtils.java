package com.crm.acute.generics;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class WebDriverUtils 
{
  public void waitForElementToLoad(WebDriver driver)
  {
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  public static void waitForElementToClick(WebDriver driver, WebElement element)
  {
	  WebDriverWait wait= new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.elementToBeClickable(element));
  }
  public void waitForElementToVisible(WebDriver driver, WebElement element)
  {
	  WebDriverWait wait= new WebDriverWait(driver, 20);
	  wait.until(ExpectedConditions.visibilityOf(element));
  }
  public static int generateRandomNum(int limit)
  {
 	 Random ran= new Random(); 
 	 return ran.nextInt(limit);	 
  }
  //overloaded select method
  public static void select(WebElement element, String name)
  {
 	 Select sel= new Select(element);
      sel.selectByVisibleText(name);
  }
  public static void select(WebElement element, int index)
  {
 	Select sel= new Select(element); 
 	sel.selectByIndex(index);
  }
  public void moveMouseOnElement(WebDriver driver, WebElement element) 
  {
	  Actions act= new Actions(driver);
	  act.moveToElement(element).perform();
  }
  
  static String parentWindowRef;
         String childWindowRef;
  public void switchtoChildWindow(WebDriver driver)
  {
	  Set<String> windows = driver.getWindowHandles();
	  Iterator<String> it= windows.iterator();
	  parentWindowRef= it.next();
	  childWindowRef= it.next();
	  driver.switchTo().window(childWindowRef);	   
  }
  public void switchtoParentWindow(WebDriver driver)
  {
	  driver.switchTo().window(parentWindowRef);	   
  }
  public static void cancelAlert(WebDriver driver)
  {
	
 	driver.switchTo().alert().dismiss(); 
  }
  public void acceptAlert(WebDriver driver)
  {
 	driver.switchTo().alert().accept(); 
  }
  /**
   * its a custom wait, it wait 20s & click on element if exist
   * @param driver
   * @param element
   * @throws Throwable
   */
  public static void waitfor20secNclick(WebDriver driver, WebElement element ) throws Throwable
  {
 	 int count=1;
 	 while(count<=20)
 	 {
 		 try 
 		 {
 			 element.click();
 			 break;
 		 }
 		 catch (Exception e) 
 		 {
 			Thread.sleep(1000);
 			count++;			
 		}
 	 }
  }
}
