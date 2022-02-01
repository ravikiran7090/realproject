package com.crm.comcast.orgTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.generalUtility.BaseClass;
import com.comcast.generalUtility.ExcelUtility;
import com.comcast.generalUtility.FileUtility;
import com.comcast.generalUtility.JavaUtility;
import com.comcast.generalUtility.webdriverUtility;
import com.crm.comcast.objectrepositionlib.Home;
import com.crm.comcast.objectrepositionlib.Login;
import com.crm.comcast.objectrepositionlib.OrganizationInformation;
import com.crm.comcast.objectrepositionlib.Organizations;
import com.crm.comcast.objectrepositionlib.createingNewOrganization;
@Listeners(com.comcast.generalUtility.ListImp.class)
public class createOrgTest extends BaseClass {
	@Test(groups="smokeTest")
	public void createOrgTest() throws Throwable{
		/* read test data*/
		String orgName = eLib.getDataFromExcel("sheet1", 1, 2)+"-"+jLib.getRandomNumber();
	   /* step3: navigate to org*/
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		//step4: navigate to create org page
		Organizations op= new Organizations(driver);
		op.getCreateOrgImg().click();
		//step5: create org
		createingNewOrganization cnop=new createingNewOrganization(driver);
		cnop.createOrg(orgName);
		 /* step6: verify */
		OrganizationInformation oinfop=new OrganizationInformation(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		String actSucmsg = oinfop.getSuccesfullMsg().getText();
		
		Assert.assertTrue(actSucmsg.contains(orgName));
		
	}
		
		@Test(groups="regressionTest")
		public void createOrgWithindustytest() throws Throwable
		{
		
		
		/* read test data*/
		String orgName = eLib.getDataFromExcel("sheet1", 1, 2)+"-"+jLib.getRandomNumber();
		String industries = eLib.getDataFromExcel("sheet1", 1, 5);
		/* step3: navigate to org*/
		Home hp=new Home(driver);
		hp.getOrganizationLink().click();
		
		//step4: navigate to create org page
		Organizations op= new Organizations(driver);
		op.getCreateOrgImg().click();
		//step5: create org
		createingNewOrganization cnop=new createingNewOrganization(driver);
		cnop.createOrg(orgName, industries);
		WebElement ind = cnop.getIndustresLst();
		//wLib.select(Industry, cnop.getIndustresLst());
		 
		/* step6: verify */
		OrganizationInformation oinfop=new OrganizationInformation(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		String actSucmsg = oinfop.getIndustries().getText();
		SoftAssert sft=new SoftAssert();
		sft.assertTrue(actSucmsg.contains(orgName));
		sft.assertAll();
		
		
	}
		}



