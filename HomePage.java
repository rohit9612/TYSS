package com.crm.acute.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.acute.generics.WebDriverUtils;
import com.crm.acute.pages.OrganizationPage;

public class HomePage extends WebDriverUtils
{
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']") private WebElement HomeLink;
	@FindBy(linkText = "Organizations") private WebElement OrgLink;
	@FindBy(linkText = "Products") private WebElement ProdLink;
	
	@FindBy(linkText = "Calendar") private WebElement CalendarLink;
	@FindBy(linkText = "Leads") private WebElement LeadsLink;
	@FindBy(linkText = "Contacts") private WebElement ContactsLink;
	@FindBy(linkText = "Opportunities") private WebElement OpportunitiesLink;
	@FindBy(linkText = "Products") private WebElement ProductsLink;
	@FindBy(linkText = "Documents") private WebElement DocumentsLink;
	@FindBy(linkText = "Email") private WebElement EmailLink;
	@FindBy(linkText = "Trouble Tickets") private WebElement TroubleTicketsLink;
	@FindBy(linkText = "Dashboard") private WebElement DashboardLink;
	@FindBy(linkText = "More") private WebElement MoreLink;
	@FindBy(linkText = "Campaigns") private WebElement CampaignsLink;
	@FindBy(linkText = "Reports") private WebElement ReportsLink;
	@FindBy(linkText = "Invoice") private WebElement InvoiceLink;
	@FindBy(linkText = "Sales Order") private WebElement SalesOrderLink;
	@FindBy(linkText = "Quotes") private WebElement QuotesLink;
	@FindBy(linkText = "Services") private WebElement ServicesLink;
	@FindBy(linkText = "Assets") private WebElement AssetsLink;
	@FindBy(linkText = "Purchase Order") private WebElement PurchaseOrderLink;
	@FindBy(linkText = "Price Books") private WebElement PriceBooksLink;
	@FindBy(linkText = "Vendors") private WebElement VendorsLink;
	@FindBy(linkText = "Service Contracts") private WebElement ServiceContractsLink;
	@FindBy(linkText = "Project Milestones") private WebElement ProjectMilestonesLink;
	@FindBy(linkText = "Project Tasks") private WebElement ProjectTasksLink;
	@FindBy(linkText = "Projects") private WebElement ProjectsLink;
	@FindBy(linkText = "FAQ") private WebElement FAQ_Link;
	@FindBy(linkText = "SMSNotifier") private WebElement SMSNotifierLink;
	@FindBy(linkText = "Our Sites") private WebElement OurSitesLink;
	@FindBy(linkText = "Integration") private WebElement IntegrationLink;
	@FindBy(linkText = "PBX Manager") private WebElement PBXManagerLink;
	@FindBy(linkText = "Comments") private WebElement CommentsLink;
	@FindBy(linkText = "Recycle Bin") private WebElement RecycleBinLink;
	
	@FindBy(xpath = "//img[@title='Chat...']") private WebElement Chat;
	@FindBy(linkText = "Sign Out") private WebElement Signout;
	@FindBy(linkText = "CRM Settings") private WebElement CRMSettings;
	@FindBy(linkText = "Help") private WebElement Help;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']") private WebElement AdministratorImage;
	
	
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getOrgLink() {return OrgLink;}
	
	public WebElement getHomeLink() {return HomeLink;}

	public WebElement getSignoutLink() {return Signout;}

	public WebElement getCalendarLink() {return CalendarLink;}

	public WebElement getLeadsLink() {return LeadsLink;}

	public WebElement getContactsLink() {return ContactsLink;}

	public WebElement getOpportunitiesLink() {return OpportunitiesLink;}

	public WebElement getProductsLink() {return ProductsLink;}

	public WebElement getDocumentsLink() {return DocumentsLink;}

	public WebElement getEmailLink() {return EmailLink;}

	public WebElement getTroubleTicketsLink() {return TroubleTicketsLink;}

	public WebElement getDashboardLink() {return DashboardLink;}

	public WebElement getMoreLink() {return MoreLink;}

	public WebElement getProdLink() {return ProdLink;}
	
	public WebElement getSignout() {return Signout;}
	
	public WebElement getCampaignsLink() {return CampaignsLink;}

	public WebElement getReportsLink() {return ReportsLink;}

	public WebElement getInvoiceLink() {return InvoiceLink;}

	public WebElement getSalesOrderLink() {return SalesOrderLink;}

	public WebElement getQuotesLink() {return QuotesLink;}

	public WebElement getServicesLink() {return ServicesLink;}

	public WebElement getAssetsLink() {return AssetsLink;}

	public WebElement getPurchaseOrderLink() {return PurchaseOrderLink;}

	public WebElement getPriceBooksLink() {return PriceBooksLink;}

	public WebElement getVendorsLink() {return VendorsLink;}

	public WebElement getServiceContractsLink() {return ServiceContractsLink;}

	public WebElement getProjectMilestonesLink() {return ProjectMilestonesLink;}

	public WebElement getProjectTasksLink() {return ProjectTasksLink;}

	public WebElement getProjectsLink() {return ProjectsLink;}

	public WebElement getFAQ_Link() {return FAQ_Link;}

	public WebElement getSMSNotifierLink() {return SMSNotifierLink;}

	public WebElement getOurSitesLink() {return OurSitesLink;}

	public WebElement getIntegrationLink() {return IntegrationLink;}

	public WebElement getPBXManagerLink() {return PBXManagerLink;}

	public WebElement getCommentsLink() {return CommentsLink;}

	public WebElement getRecycleBinLink() {return RecycleBinLink;}
	
	public OrganizationPage navigateToOrganizationPage()
	{
		OrgLink.click();
		return new OrganizationPage(driver);
	}

	public ProductPage clickOnProductLink() 
	{
		ProdLink.click();
		return new ProductPage(driver);
	}

	public void clickSignOut()
	{
		moveMouseOnElement(driver, AdministratorImage);
		Signout.click();
	}

}
