package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.acute.generics.WebDriverUtils;

public class OrganizationPage 
{
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createOrgImg;
	
	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public CreatingNewOrganization navigateCreateOrganization()
	{
		WebDriverUtils.waitForElementToClick(driver, createOrgImg);
		createOrgImg.click();
		return new CreatingNewOrganization(driver);
	}


}
