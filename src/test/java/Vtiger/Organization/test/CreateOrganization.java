package Vtiger.Organization.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.comcast.generalUtility.ExcelUtility;
import com.comcast.generalUtility.FileUtility;
import com.comcast.generalUtility.JavaUtility;
import com.comcast.generalUtility.webdriverUtility;

public class CreateOrganization {
	public static void main(String[] args) throws Throwable {
		
	
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	FileUtility fLib=new FileUtility();
	webdriverUtility wLib= new webdriverUtility();
	int randomint = jLib.getRandomNumber();
	String USERNAME = fLib.getPropertyKeyValue("username");
	String PASSWORD = fLib.getPropertyKeyValue("password");
	String URL = fLib.getPropertyKeyValue("url");
	String BROWSER = fLib.getPropertyKeyValue("browser");
	
	 String orgName = eLib.getDataFromExcel("sheet1", 01, 02)+randomint;
	 WebDriver driver=null;
	 if(BROWSER.equalsIgnoreCase("chrome")){
		 driver=new ChromeDriver();
		  }
	 else if(BROWSER.equalsIgnoreCase("firefox")){
		 driver=new FirefoxDriver();
		}
	else if(BROWSER.equalsIgnoreCase("ie"))
	 {
		driver=new InternetExplorerDriver();
	 }
	 
	 wLib.waitForpageLoad(driver);
	 driver.get(URL);
	 wLib.maximizeWindow(driver);
	 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	 driver.findElement(By.id("submitButton")).click();
	 driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
	 driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
	 driver.findElement(By.name("accountname")).sendKeys(orgName);
	 WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
	 wLib.select("Education",ele );
	  WebElement ele1 = driver.findElement(By.name("accounttype"));
	  wLib.select("Customer", ele1);
	  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 wLib.mousehover(driver, ele3);
	 driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
	
	}
}
