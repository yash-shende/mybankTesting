package mybank.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import mybank.pages.UserLoginPage;
import mybank.pages.RequestAtmPage;
import mybank.pages.SideNavBar;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class RequestAtmPageTest extends BaseTest {

	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());

	@BeforeTest
	public void beforeTest() {

		test = extent.createTest("Request ATM Page Test", "Testing Request ATM Feature ");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.info("Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test 
	public void requestAtmPageAvabilityTest() {
		SideNavBar sideBar = new SideNavBar(driver);
		RequestAtmPage reqAtmPage = new RequestAtmPage(driver);

		utils.userLogin("abc@gmail.com", "1234");

		sideBar.clickRequestAtmBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/requestATM.php";

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("Atm Request page Avialable !");
			logger.info("Atm Request Avialable !!");
		}

		catch (AssertionError e) {
			System.out.println("Atm not Avialable ");
			test.fail("Atm page Not avialable ... ");
			logger.error("Error occured with assert statement !");
		}

		reqAtmPage.clickReqAtmBtn();
		driver.switchTo().alert().accept();


		if (reqAtmPage.getStatusMesg() == "")
			System.out.println("You Clicked on cancle");
		else {
			
			
			String path = utils.getScreenShotOfElement(reqAtmPage.atmStatusMessage);
			logger.info("Alert Message is Clicked OK !");
			try {
				test.pass("Request for ATM is Successfull !",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Request for ATM is Successfull!!");	
		
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
	public void ShutDown() {
		driver.close();
		driver.quit();
		logger.info("All Done!");
	}

}
