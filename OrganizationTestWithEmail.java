package com.crm.acute.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.acute.generics.BaseClass;
import com.crm.acute.generics.FileLib;
import com.crm.acute.generics.WebDriverUtils;
import com.crm.acute.pages.CreatingNewOrganization;
import com.crm.acute.pages.HomePage;
import com.crm.acute.pages.OrganizationInformationPage;
import com.crm.acute.pages.OrganizationPage;

public class OrganizationTestWithEmail extends BaseClass
{
	@Test(groups= {"Smoke","Regression"})
	public void testcreateOrganization() throws InterruptedException
	{
		/*Step 1: get Test Data*/
		FileLib fl= new FileLib();
		String orgName= fl.getExceldata("Org",1, 0)+WebDriverUtils.generateRandomNum(1000); 
		String fno= fl.getExceldata("Org", 1, 1);
		String email= fl.getExceldata("Org", 1, 2);
		
		/* Step2: navigate to Org Page*/
		HomePage hp= new HomePage(driver);
		OrganizationPage op = hp.navigateToOrganizationPage();
		
		/* Step3: navigate to Create Org Page*/
		CreatingNewOrganization cno= op.navigateCreateOrganization();
		/* Step4: create org*/
		Thread.sleep(2000);
		OrganizationInformationPage oip = cno.createOrganizationwithEmailNphone(orgName, fno, email);
		Thread.sleep(2000);
		/* Step 5: verify */
		String actualOrgName=oip.getOrgNameInfo().getText();
		Assert.assertEquals(actualOrgName, orgName);
	
	}
}
