package com.crm.comcast.objectrepositionlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformation {
	public  OrganizationInformation(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement succesfullMsg;
	
	public WebElement getSuccesfullMsg() {
		return succesfullMsg;
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement industries;

	public WebElement getIndustries() {
		return industries;
	}
	

}
