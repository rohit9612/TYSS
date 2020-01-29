package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.acute.generics.FileLib;

/**
 * @author Rajesh Kumar
 *
 */
public class LoginPage 
{
@FindBy(name="user_name") private WebElement unTB;
@FindBy(name="user_password") private WebElement pwdTB;
@FindBy(id="submitButton") private WebElement lgnBtn;

// provide getter for read access
public WebElement getUnTB() {return unTB;}

public WebElement getPwdTB() {return pwdTB;}

public WebElement getLgnBtn() {return lgnBtn;}

WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

//overloaded method one to login with un & pwd, other direct by calling
public void loginToApp() throws Exception
{
	FileLib fl= new FileLib();
	String un=fl.getDataFromProp("Username");
	String pwd=fl.getDataFromProp("Password");
	unTB.sendKeys(un);
	pwdTB.sendKeys(pwd);
	lgnBtn.click();
}
public void loginToApp(String username, String password)
{
	unTB.sendKeys(username);
	pwdTB.sendKeys(password);
	lgnBtn.click();
}



}
