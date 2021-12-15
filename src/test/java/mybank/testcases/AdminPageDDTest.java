package mybank.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import mybank.utility.Utilities;
import mybank.utility.BaseTest;
import mybank.utility.Data;

public class AdminPageDDTest extends BaseTest {

	static Utilities utils = new Utilities();
	static WebDriver driver = null;
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());


	@BeforeTest
	public void beforeSuite() {
		test = extent.createTest("Admin Login Page Test Using DDT", "DD Testing Admin Login Feature ");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.log(Status.INFO, "Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test(dataProvider = "Dataset", dataProviderClass = Data.class)
	public void adminLoginTest(String emailid, String password) {

		boolean logined  = utils.AdminLogin(emailid, password); // calling admin login method
		if(logined) {
			System.out.println("Admin Login Successful !!");
			
		}
		else {
			System.out.println("Admin Login Failed! !!");
			Assert.assertTrue(logined);
		}
	}
	
	@AfterMethod
	public void temp(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String ssPath = utils.getScreenshot();
			test.fail("Failed !!",MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		}
	}

	@AfterTest
	public void quit() {
		driver.close();
		driver.quit();
		logger.info("All Done!");

	}

}