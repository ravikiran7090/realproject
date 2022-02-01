
package com.crm.comcast.objectrepositionlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	/**
	 * to click on organization image to create new orgnization
	 */
   @FindBy(xpath="//img[@title='Create Organization...']" )
	private WebElement createOrgImg;
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	@FindBy(id="search_txt")
	private WebElement searchEdt;
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	@FindBy(name="search")
	private WebElement searcBtn;
	public WebElement getSearcBtn() {
		return searcBtn;
	}
	
	

}
