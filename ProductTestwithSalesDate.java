package com.crm.acute.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.acute.generics.BaseClass;
import com.crm.acute.generics.FileLib;
import com.crm.acute.generics.WebDriverUtils;
import com.crm.acute.pages.CreatingNewProduct;
import com.crm.acute.pages.HomePage;
import com.crm.acute.pages.ProductInfoPage;
import com.crm.acute.pages.ProductPage;

public class ProductTestwithSalesDate extends BaseClass
{
	@Test(groups= {"Smoke","Regression"})
      public void testCreateProduct()
      {
		FileLib fl= new FileLib();
		String productName = fl.getExceldata("Product", 1, 0)+WebDriverUtils.generateRandomNum(10000);
		String salesStartDate = fl.getExceldata("Product", 1, 1);
		String salesEndDate = fl.getExceldata("Product", 1, 2);
	 
		/* navigate to Product page*/
    	  HomePage hp= new HomePage(driver);
    	  ProductPage pp = hp.clickOnProductLink();
    	  
  		/* navigate to create new Product page*/
    	  CreatingNewProduct cnp = pp.navigateProductToCreateNewProduct();
    	  
    	 ProductInfoPage pip = cnp.createnewProductWithSalesDate(productName, salesStartDate, salesEndDate);
    	 
    	 /*verify*/
 		String actualProdName=pip.getProdNameInfo().getText();
 		Assert.assertEquals(actualProdName, productName);
    	  
    	  
    	  
    	  
    	  
    	  
    	  
      }
}
