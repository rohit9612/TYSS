package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
   @FindBy(xpath="//img[@title='Create Product...']") private WebElement createProdImg;
   
   WebDriver driver;
   public ProductPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   public CreatingNewProduct navigateProductToCreateNewProduct()
   {
	   createProdImg.click();
	   return new CreatingNewProduct(driver);
   }
}
