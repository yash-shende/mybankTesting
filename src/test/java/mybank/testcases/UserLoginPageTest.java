package mybank.testcases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import mybank.utility.*;

public class UserLoginPageTest extends BaseTest {

	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());

	@BeforeTest
	public void beforeSuite() {
		test = extent.createTest("Login Page Test", "Testing Login Feature ");
		logger.info("before suit log..");
		driver = utils.browserSetup();		
		test.log(Status.INFO, "Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test(dataProvider = "Dataset", dataProviderClass = UserData.class)
	public static void LoginTest(String emailid, String password) {

		utils.userLogin(emailid, password); 
		
	}
	
	@AfterMethod
	public void temp(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.FAILURE) {
			String ssPath = utils.getScreenshot();
			test.fail("Failed !!",MediaEntityBuilder.createScreenCaptureFromPath(ssPath).build());
		}
	}
	

	@AfterTest
	public void tear() {
		driver.close();
		driver.quit();
		logger.info("All Done!");

	}

}
