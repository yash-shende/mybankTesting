package mybank.utility;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseTest  {
	public static ExtentReports extent;
	public static ExtentHtmlReporter reporter;
	//public static WebDriver driver;
	public static ExtentTest test;
	
	@BeforeSuite
	public void setup()
	{
		extent=new ExtentReports();
		reporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"\\Reports\\MyBankTestCaseReport.html");
		extent.attachReporter(reporter);
		
	}
	
	@AfterSuite
	public void tearDown()
	{
		extent.flush();
	}
	
	
}
