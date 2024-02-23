 package TestingPractisecompany.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import BaseTest.Tests.Base;
import Resources.ExtentReportNg;

public class Listeners extends Base implements ITestListener{
	ExtentReports ex=ExtentReportNg.getReport();
	ExtentTest test;
	ThreadLocal<ExtentTest> th =new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		test=ex.createTest(result.getMethod().getMethodName());
		th.set(test);
	  }

	 
	public void onTestSuccess(ITestResult result) {
	    th.get().log(Status.PASS, "Passed");
	  }

	  
	public void onTestFailure(ITestResult result) {
	    th.get().fail(result.getThrowable());
	    String ts=null;
	    try {
			driver=(WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	    try {
			ts = takeScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    th.get().addScreenCaptureFromPath(ts, result.getMethod().getMethodName());
	    
	  }

	  
	public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }

	  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	    // not implemented
	  }

	  
	public void onTestFailedWithTimeout(ITestResult result) {
	    onTestFailure(result);
	  }

	  
	public void onStart(ITestContext context) {
	    // not implemented
	  }

	 
	public void onFinish(ITestContext context) {
	   ex.flush();
	  }

}
