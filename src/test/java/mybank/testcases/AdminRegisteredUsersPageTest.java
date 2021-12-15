package mybank.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import mybank.pages.AdminLoginPage;
import mybank.pages.AdminRegisteredUsersPage;
import mybank.pages.AdminSideNavBar;
//import mybank.testcases.AdminPageDDTest;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class AdminRegisteredUsersPageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getName());

	@BeforeTest
	public void beforeTest() {

		test = extent.createTest("To Test Block/Unblock user Feature ", "To check that admin can block/unblock user");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.info("Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test
	public void registeredUserPageAvabilityTest() {
		AdminSideNavBar adminsideBar = new AdminSideNavBar(driver);
		AdminRegisteredUsersPage changeUserStatusPage = new AdminRegisteredUsersPage(driver);

		boolean logined = utils.AdminLogin("admin@gmail.com", "admin123");
		if(logined) {
		adminsideBar.RegisteredUserBtn();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/adminuserdetails.php";
		

		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("User Details page is Avialable in Admin Dashboard!");
			logger.info("User Details page is Avialable !!");
		}

		catch (AssertionError e) {
			System.out.println("User Details page is not Avialable in Admin Dashboard ");
			test.fail("Error, User Details page is not Avialable in Admin Dashboard ");
			logger.error("Error, User Details page is not Avialable in Admin Dashboard ");
		}

		
		String customerStatus = changeUserStatusPage.getcustomeStatus();
		String customerCode = changeUserStatusPage.getcustomerCodeNo();
		
		if(customerStatus.equals("allowed")) {
			
			changeUserStatusPage.clickchangeUserStatus();
			
			String actualUrl2 = driver.getCurrentUrl();
			String expectedUrl2 = "http://localhost/mybank/CustomerStatus.php";
			
			try {
				assertEquals(expectedUrl2, actualUrl2);
				//System.out.println("inside try");
				test.pass("customer status page is Avialable to block/unblock !");
				logger.info("block/unblock page is available !!");
			}

			catch (AssertionError e) {
				//System.out.println("block/unblock page is not available ");
				test.fail("Error, block/unblock page is not available ");
				logger.error("Error, block/unblock page is not available ");
			}
			
			
			changeUserStatusPage.clicktextFieldForBlock();
			
			WebElement code = driver.findElement(By.xpath("//div[@class='col-xs-3']//input[@placeholder='Enter here']"));			
			code.sendKeys(customerCode);
					
			changeUserStatusPage.clickblock();
			
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			
			
			test.pass("customer blocked !");
			logger.info("customer blocked !!");
			
		} 
		
		else 
			
		{
			System.out.println("inside else");
			
			changeUserStatusPage.clickchangeUserStatus();
			
			String actualUrl2 = driver.getCurrentUrl();
			String expectedUrl2 = "http://localhost/mybank/CustomerStatus.php";
			
			try {
				assertEquals(expectedUrl2, actualUrl2);
				//System.out.println("inside try");
				test.pass("customer status page is Avialable to block/unblock !");
				logger.info("block/unblock page is available !!");
			}

			catch (AssertionError e) {
				//System.out.println("block/unblock page is not available ");
				test.fail("Error, block/unblock page is not available ");
				logger.error("Error, block/unblock page is not available ");
			}
			
			
			changeUserStatusPage.clicktextFieldForunblock();
			
			WebElement code = driver.findElement(By.xpath("//div[@class='col-xs-6']//input[@placeholder='Enter here']"));			
			code.sendKeys(customerCode);
			
			changeUserStatusPage.clickunblock();
			
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
			
			
			
			test.pass("customer unblocked !");
			logger.info("customer unblocked !!");
		}
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
