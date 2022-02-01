package com.comcast.generalUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.crm.comcast.objectrepositionlib.Home;
import com.crm.comcast.objectrepositionlib.Login;

public class BaseClass {
public 	WebDriver driver=null;
	/*create Objects*/
	public ExcelUtility eLib=new ExcelUtility();
	public FileUtility fLib=new FileUtility();
	public JavaUtility jLib=new JavaUtility();
    public webdriverUtility wLib=new webdriverUtility();
    public static WebDriver sdriver= null;
    
     @BeforeSuite(groups={"smokeTest","regressionTest"})
     public void configBS(){
    	 System.out.println("======connect to db====");
     }
   // @Parameters("BROWSER") 
     @BeforeClass(groups={"smokeTest","regressionTest"})
     public void configBc(/*String BROWSER*/) throws IOException{
    	 System.out.println("======launch the browser======");
    	
    	 String BROWSER = fLib.getPropertyKeyValue("browser");
  		
  		/*step1: launch the browser*/
 		if(BROWSER.equalsIgnoreCase("chrome")){
 			driver=new ChromeDriver();
 		}
 		else if(BROWSER.equalsIgnoreCase("firefox")){
 			driver=new FirefoxDriver();
 		}
 		else if(BROWSER.equalsIgnoreCase("ie")){
 			System.out.println("invalid browser");
 			
 		}
 		
    	 wLib.waitForpageLoad(driver);
    	 driver.manage().window().maximize();
    	 sdriver=driver;
     }
     @BeforeMethod(groups={"smokeTest","regressionTest"})
     public void configBM() throws IOException{
    		/*read common data*/
    	 String URL = fLib.getPropertyKeyValue("url");
   		String USERNAME = fLib.getPropertyKeyValue("username");
   		String PASSWORD = fLib.getPropertyKeyValue("password");

		/*step2:login to app*/
        driver.get(URL);
        Login lp=new Login(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		 }
     @AfterMethod(groups={"smokeTest","regressionTest"})
     public void configAM(){
    		/*step7 : logout*/
 		Home hp=new Home(driver);
 		hp.logout(driver);
     }
     @AfterClass(groups={"smokeTest","regressionTest"})
     public void configAc(){
    	 System.out.println("close the browser");
    	 driver.quit();
     }
     @AfterSuite(groups={"smokeTest","regressionTest"})
     public void configAS(){
    	 System.out.println("======close the db=======");
     }
     
     
	

}
