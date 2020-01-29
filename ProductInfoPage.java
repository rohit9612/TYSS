package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
	@FindBy(id="dtlview_Product Name") private WebElement prodNameInfo;
	
	WebDriver driver;
	public ProductInfoPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getProdNameInfo() {
		return prodNameInfo;
	}
}
