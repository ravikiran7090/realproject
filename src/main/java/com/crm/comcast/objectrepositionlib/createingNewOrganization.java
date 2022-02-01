package com.crm.comcast.objectrepositionlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generalUtility.webdriverUtility;

public class createingNewOrganization extends webdriverUtility  {
	public createingNewOrganization(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industresLst;
	
	public WebElement getIndustresLst() {
		return industresLst;
	}
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	
	public void createOrg(String orgName){
		orgNameEdt.sendKeys(orgName);
		saveBtn.click();
		
	}
	public void createOrg(String orgName, String industries){
		orgNameEdt.sendKeys(orgName);
		select(industresLst, industries );
		saveBtn.click();
	}

}
