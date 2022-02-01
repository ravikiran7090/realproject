package Vtiger.Organization.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SearchTheOrgnizationbyratingtest {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("./commondata/commondata.properties.txt");
		Properties pobj= new Properties();
		pobj.load(fis);
		String BROWSER = pobj.getProperty("browser");
		String URL = pobj.getProperty("url");
		String USERNAME = pobj.getProperty("username");
		String PASSWORD = pobj.getProperty("password");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("(//a[.='Organizations'])[1]")).click();
		driver.findElement(By.xpath("//a[.='Go to Advanced Search']")).click();
		WebElement ele = driver.findElement(By.xpath("//select[@name='fcol0']"));
		Select sc=new Select(ele);
		sc.selectByVisibleText("Rating");
		driver.findElement(By.xpath("(//input[@value=' Search Now '])[2]")).click();
		driver.switchTo().alert().accept();
		 WebElement ele2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 Actions act= new Actions(driver);
		act.moveToElement(ele2).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
	}

}
