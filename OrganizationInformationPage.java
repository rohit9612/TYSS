package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.acute.generics.WebDriverUtils;

public class OrganizationInformationPage 
{
	@FindBy(id="dtlview_Organization Name") private WebElement OrgNameInfo;
    WebDriver driver;
	public OrganizationInformationPage(WebDriver driver)
    {
		this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
	public WebElement getOrgNameInfo() 
	{
		return OrgNameInfo;
	}
	public void clickOrgInfo()
	{
		WebDriverUtils.waitForElementToClick(driver, OrgNameInfo);;
		OrgNameInfo.click();
	}
	
}
