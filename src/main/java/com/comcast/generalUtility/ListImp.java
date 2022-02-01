 package com.comcast.generalUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mysql.jdbc.Driver;

public class ListImp extends BaseClass implements ITestListener {
	ExtentReports report;
	 ExtentTest test;
	 public void onTestStart(ITestResult result) {
	  //@Test
	   test = report.createTest(result.getMethod().getMethodName());
	 }

	 public void onTestSuccess(ITestResult result) {
	  test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	 }

	 public void onTestSkipped(ITestResult result) {
	  test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
	  test.log(Status.SKIP,result.getThrowable());
	 }

	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	  
	 }

	 public void onTestFailedWithTimeout(ITestResult result) {
	  
	 }

	 public void onStart(ITestContext context) {
	 //@BeforeSuite
	  ExtentSparkReporter spark=new ExtentSparkReporter("./extentreport.html");
	  spark.config().setTheme(Theme.DARK);
	  spark.config().setDocumentTitle("Vtiger automation");
	  spark.config().setReportName("Execution report");
	  
	   report=new ExtentReports();
	  report.attachReporter(spark);
	  report.setSystemInfo("OS", "Window");
	  report.setSystemInfo("Platform", "Windows 10");
	  report.setSystemInfo("Reporter", "Nithesh");
	 }

	 public void onFinish(ITestContext context) {
	  //@AfterSuite
	  report.flush();
	 }

	 public void onTestFailure(ITestResult result) {
	  String failedTestNAme = result.getMethod().getMethodName();
	  
	  EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sdriver);
	  File srcFile =  eDriver.getScreenshotAs(OutputType.FILE);
	  String sytemDate = new Date().toString().replace(":", "_").replace(" ", "_");
	  File target=new File("./ScreenShot/"+failedTestNAme + "_"+sytemDate+".png");
	  try {
	   FileUtils.copyFile(srcFile, target);
	  } catch (IOException e) {

	  }
	  
	  test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
	  test.log(Status.FAIL, result.getThrowable());
	  test.addScreenCaptureFromPath(target.getAbsolutePath());
	 }


	
	
}
