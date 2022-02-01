package com.crm.comcast.contacttest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.generalUtility.BaseClass;
import com.comcast.generalUtility.ExcelUtility;
import com.comcast.generalUtility.FileUtility;
import com.comcast.generalUtility.JavaUtility;
import com.comcast.generalUtility.webdriverUtility;
import com.crm.comcast.objectrepositionlib.ContactInformation;
import com.crm.comcast.objectrepositionlib.Contacts;
import com.crm.comcast.objectrepositionlib.CreateNewContacts;
import com.crm.comcast.objectrepositionlib.Home;
import com.crm.comcast.objectrepositionlib.Login;
import com.crm.comcast.objectrepositionlib.OrganizationInformation;
import com.crm.comcast.objectrepositionlib.Organizations;
import com.crm.comcast.objectrepositionlib.createingNewOrganization;

@Listeners(com.comcast.generalUtility.ListImp.class)
public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void CreateContactTest() throws Throwable {
		/* read test data */
		String lastName = eLib.getDataFromExcel("sheet1", 1, 2) + "-" + jLib.getRandomNumber();
		// step3: navigate to conatact page
		Home hp = new Home(driver);
		hp.getContactLink().click();
		// step4: navigate to create new contact page
		Contacts cp = new Contacts(driver);
		cp.getCreateContactImg().click();
		// step5: create org
		CreateNewContacts cnp = new CreateNewContacts(driver);
		cnp.createContact(lastName);

		/* step6: verify */
		ContactInformation ci = new ContactInformation(driver);
		String actLstName = ci.getOrgHeaderSucMsg().getText();
	
		Assert.assertTrue(actLstName.contains(lastName));

	}

	@Test(groups = "regressionTests")
	public void createContactWithOrgTest() throws Throwable {

		/* read test data */
		String lastName = eLib.getDataFromExcel("sheet1", 1, 2) + "-" + jLib.getRandomNumber();
		String orgName = eLib.getDataFromExcel("sheet1", 1, 2) + "-" + jLib.getRandomNumber();

		/* step3: navigate to homepage */
		Home hp = new Home(driver);
		hp.getOrganizationLink().click();

		// step4: navigate to org page
		Organizations op = new Organizations(driver);
		op.getCreateOrgImg().click();
		// step5: navigate to create org page
		createingNewOrganization cnop = new createingNewOrganization(driver);
		cnop.createOrg(orgName);
		/* step6: verify */
		OrganizationInformation oinfop = new OrganizationInformation(driver);
		wLib.waitForElementVisibility(driver, oinfop.getSuccesfullMsg());
		String actSucmsg = oinfop.getSuccesfullMsg().getText();
		SoftAssert sft = new SoftAssert();
		sft.assertTrue(actSucmsg.contains(orgName));
		sft.assertAll();

		// explicit wait for contact link web element to visible
		OrganizationInformation oi = new OrganizationInformation(driver);
		wLib.waitForElementVisibility(driver, oi.getSuccesfullMsg());
		hp.getContactLink().click();
		// step8:navigate to contact page
		Contacts cp = new Contacts(driver);
		cp.getCreateContactImg().click();
		// step9:creating a new contact
		CreateNewContacts cnc = new CreateNewContacts(driver);
		cnc.createContact(lastName, orgName);

	}
}
