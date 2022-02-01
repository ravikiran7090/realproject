package com.crm.comcast.objectrepositionlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {//Rule:1 Create a seperate java class for every page in aapplication
	public Login(WebDriver driver){//Rule3: Excecute all the elements and initialize the 
		//elements pageFactory.initElement[initialization]
		PageFactory.initElements(driver, this);
		}
	@FindBy(name="user_name")     //Rule2: Identify all the elements using@findby and findbys &findAll declaration
	private WebElement userNameEdt;
	
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	//Rule4: Declare all the elements as private & provide getters method,bussiness method for (Utilization)

	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getUserPaswordEdt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	public void loginToApp(String userName,String password)
	{
		//step 1: login
		userNameEdt.sendKeys(userName);
		userPasswordEdt.sendKeys(password);
		loginBtn.click();
	}
	

}
