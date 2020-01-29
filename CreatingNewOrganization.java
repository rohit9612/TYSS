package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.acute.generics.WebDriverUtils;

public class CreatingNewOrganization 
{
	
	@FindBy(name = "accountname") private WebElement OrgNameTB;
	@FindBy(name = "phone") private WebElement phoneTB;
	@FindBy(id="email1")private WebElement emailTB;
	@FindBy(xpath="//img[@alt='Select']") private WebElement memberOfTB;
	@FindBy(xpath ="//input[@class='crmbutton small save']") private WebElement saveBtn;
	
	WebDriver driver;
	public CreatingNewOrganization(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrganizationInformationPage createOrganizationWithPhone(String orgName, String fno)
	{
		OrgNameTB.sendKeys(orgName);
		phoneTB.sendKeys(fno);
		saveBtn.click();
		return new OrganizationInformationPage(driver); 
	}
	
	public OrganizationInformationPage createOrganizationwithEmailNphone(String orgName, String fno, String email)
	{
		OrgNameTB.sendKeys(orgName);
		phoneTB.sendKeys(fno);
		emailTB.sendKeys(email);
		saveBtn.click();
		return new OrganizationInformationPage(driver); 
	}
	
	public OrganizationInformationPage createOrganizationwithMember(String orgName, String fno, String email)
	{
		OrgNameTB.sendKeys(orgName);
		phoneTB.sendKeys(fno);
		emailTB.sendKeys(email);
		memberOfTB.click();
		WebDriverUtils util= new WebDriverUtils();
		util.switchtoChildWindow(driver);
		OrganizationChildBrwsrPopUpWin child= new OrganizationChildBrwsrPopUpWin(driver);
		child.setOrgNameinSearchTB("TY1");
		child.clickSearchNowBtn();
		child.clickFirstLink();
		util.acceptAlert(driver);
		util.switchtoParentWindow(driver);		
		saveBtn.click();
		return new OrganizationInformationPage(driver);
	}
}
