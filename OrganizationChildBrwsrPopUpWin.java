package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationChildBrwsrPopUpWin 
{
	@FindBy(name = "search_text") private WebElement srchTB;
	@FindBy(xpath = "//input[@class='crmbutton small create']") private WebElement searchNowBtn;	
	@FindBy(id = "1") private WebElement firstlink;
	
	public OrganizationChildBrwsrPopUpWin(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setOrgNameinSearchTB(String on)
	{
		srchTB.sendKeys(on);
	}
	public void clickSearchNowBtn()
	{
		searchNowBtn.click();
	}
	public void clickFirstLink()
	{
		firstlink.click();
	}
	
	
}
