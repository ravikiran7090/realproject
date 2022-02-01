package com.crm.comcast.objectrepositionlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generalUtility.webdriverUtility;

public class Home extends webdriverUtility {
	WebDriver driver;
	public Home (WebDriver driver){//Rule3: Excecute all the elements and initialize the 
		//elements pageFactory.initElement[initialization]
		PageFactory.initElements(driver, this);
		}
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminstatorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getAdminstatorImg() {
		return adminstatorImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	public void logout(WebDriver driver){
		Actions act=new Actions(driver);
		act.moveToElement(adminstatorImg).perform();
		signOutLink.click();
				
		
	}
	

}
