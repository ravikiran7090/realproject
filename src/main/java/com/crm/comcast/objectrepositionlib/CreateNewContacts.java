package com.crm.comcast.objectrepositionlib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.generalUtility.webdriverUtility;

public class CreateNewContacts extends webdriverUtility {
	WebDriver driver;
	public  CreateNewContacts(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    @FindBy(xpath="//input[@name='account_name']/following-sibling::img")
    private WebElement orgLookUpImg;
    public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	public void createContact(String contactLastName){
    	lastNameEdt.sendKeys(contactLastName);
    	saveBtn.click();
    }
    public void  createContact(String contactlastName,String orgName){
    	lastNameEdt.sendKeys(contactlastName);
    	orgLookUpImg.click();
    	switchToWindow(driver, "Accounts&action");
    	Organizations op=new Organizations(driver);
    	op.getSearchEdt().sendKeys(orgName);
    	op.getSearcBtn().click();
    	
    	driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
    	switchToWindow(driver, "Contact&action");
    	saveBtn.click();
    	
    	
    }
}
