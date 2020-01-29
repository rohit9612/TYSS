package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.acute.generics.FileLib;

public class CreatingNewProduct 
{
     @FindBy(name="productname") private WebElement productNameTB;
     @FindBy(name="sales_start_date") private WebElement SalesStartDateTB;
     @FindBy(name="sales_end_date") private WebElement SalesEndDateTB;
     @FindBy(name="website") private WebElement websiteTB;
     @FindBy(xpath ="//input[@class='crmbutton small save']") private WebElement saveBtn;
     
     
     WebDriver driver;
     public CreatingNewProduct(WebDriver driver)
     { 
    	 this.driver=driver;
    	PageFactory.initElements(driver, this); 
     }
     
     public ProductInfoPage createnewProductWithSalesDate(String prodName, String salesstrtdate, String salesenddate)
     {
    	 
    	 productNameTB.sendKeys(prodName); 
    	 SalesStartDateTB.sendKeys(salesstrtdate);
    	 SalesEndDateTB.sendKeys(salesenddate);
    	 saveBtn.click();
    	 return new ProductInfoPage(driver);
     }
     
     public ProductInfoPage createnewProductwithWebsite(String prodName, String salesstrtdate, String salesenddate,String website)
     {
    	 
    	 productNameTB.sendKeys(prodName); 
    	 SalesStartDateTB.sendKeys(salesstrtdate);
    	 SalesEndDateTB.sendKeys(salesenddate);
    	 websiteTB.sendKeys(website);
    	 saveBtn.click();
    	 return new ProductInfoPage(driver);
     }
}
