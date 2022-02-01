package PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ReadDataFromPropertiesFile {
	public static void main(String[] args) throws IOException {
		//step1: get the java representaion object of the physical file
		FileInputStream fis= new FileInputStream("./commondata/commondata.properties.txt");
		//step2: create an object to property class to load all the keys
		Properties pobj= new Properties();
		pobj.load(fis);
		//step3: read the value using getproperty("key")
		//String BROWSER = pobj.getProperty("browser");
		
		
		
		Scanner scr=new Scanner(System.in);
		System.out.println("enter the browser name");
		String BROWSER = scr.next();
		WebDriver driver = null;
		
		if(BROWSER.equals("chrome")){
			driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")){
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equals("ie"))
		{
			driver= new InternetExplorerDriver();
		}
		// s
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		// step1: login
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		//step2: navigate to organization module
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		// step3:click on "create organization" Button
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//step4: enter all the details
		FileInputStream fis_e= new FileInputStream("./commondata/tdt.xlsx");
		//step1: open the workbook in readvmode
		Workbook wb = WorkbookFactory.create(fis_e);
		// step2: get the control of the org
		//Sheet sh = wb.getSheet("sheet1");
		//step3: get the control of the 1St row
		//Row row = sh.getRow(1);
		String orgName = wb.getSheet("sheet1").getRow(1).getCell(2).getStringCellValue();
		//String orgName = row.getCell(2).getStringCellValue();
		System.out.println(orgName);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		String  website = wb.getSheet("sheet1").getRow(1).getCell(3).getStringCellValue();
		System.out.println( website);
		driver.findElement(By.xpath("//input[@name='website']")).sendKeys(website);
		WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
		Select sc= new Select(ele);
		sc.selectByVisibleText("Banking");
		   String mobileno = wb.getSheet("sheet1").getRow(1).getCell(4).getStringCellValue();
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(mobileno);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Actions act= new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"))).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
		
	}

}
