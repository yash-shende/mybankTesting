package mybank.testcases;

import java.io.IOException;
import java.util.Random;

import static org.testng.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import mybank.pages.SideNavBar;
import mybank.pages.AddMoneyPage;
import mybank.pages.AccSummSideNavBar;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class AddMoneyPageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	static Logger logger = utils.log4jSetup(UserLoginPageTest.class.getName());
	boolean logined ;

	@BeforeTest 
	public void beforeTest() {

		logger.info("before suit log..");
		driver = utils.browserSetup();
		logger.warn("Browser just launched !");
	}

	@Test(priority = 1)
	public void addMoneyPageAvabilityTest() {
		test = extent.createTest("Add Money Page Test", "Testing Add Money Feature ");
		test.info("Browser launched successfully");

		logined = utils.userLogin("abc@gmail.com", "1234");

		if (logined) {
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "http://localhost/mybank/Userdashboard.php#";

			try {
				assertEquals(expectedUrl, actualUrl);
				test.pass("UserDashBoard page Avialable !");
				logger.info("UserDashBoard page Avialable !!");
			}

			catch (AssertionError e) {
				System.out.println("UserDashBoard page not Avialable ");
				test.fail("UserDashBoarde page Not avialable ... ");
				logger.error("UserDashBoard page not avialible !");
			}

			SideNavBar sideNavBar = new SideNavBar(driver);

			sideNavBar.clickaccSummaryBtn();

			String actualUrl1 = driver.getCurrentUrl();
			String expectedUrl1 = "http://localhost/mybank/accountSummary.php";

			try {
				assertEquals(expectedUrl1, actualUrl1);
				test.pass("Account Summery btn is working !");
				logger.info("Account Summery page Avialable !!");
			}

			catch (AssertionError e) {
				System.out.println("Account Summery page not Avialable ");
				test.fail("Account Summery page Not avialable ... ");
				logger.error("Error occured with assert statement !");
			}

			AccSummSideNavBar accSummsideNavBar = new AccSummSideNavBar(driver);

			accSummsideNavBar.clickaddMoneyToAccBtn();

			String actualUrl2 = driver.getCurrentUrl();
			String expectedUrl2 = "http://localhost/mybank/addMoney.php";

			try {
				assertEquals(expectedUrl2, actualUrl2);
				test.pass("Add Money btn is working !");
				logger.info("Add Money page Avialable !!");
			}

			catch (AssertionError e) {
				System.out.println("Add Money page not Avialable ");
				test.fail("Add Money page Not avialable ... ");
				logger.error("Error occured with assert statement !");
			}
		}

	}

	@Test(priority = 2)
	public void test2() {
		test = extent.createTest("Veryfing Add Money feature above given Limit ", "Testing Add Money Feature ");
		AddMoneyPage addMoneyPage = new AddMoneyPage(driver);
		
		if(logined) {
		test.info("User logined successfully !");
		test.info("AddMoney Page is Avialable");
		addMoneyPage.clickenterAmount();

		WebElement amount = driver.findElement(By.className("form-control"));

		amount.sendKeys("59999999999");

		addMoneyPage.clickaddMoneyBtn();

		String actualStr = addMoneyPage.getStatusMesg();

		String expectedStr4 = "You cannot add more than Rs.40,000";

		try {
			assertEquals(expectedStr4, actualStr);
			String path = utils.getScreenShotOfElement(addMoneyPage.statusMesg);
			try {
				test.pass("cannot add more than 40,000 !!",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}

			logger.info("cannot add more than 40,000 !!");
		}

		catch (AssertionError e) {
			test.fail("Error occured while adding more than 40k !");
			logger.error("add money limit exceed !");
			Assert.assertTrue(false);
		}
	}
		else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
		}
	}

	@Test(priority = 3)
	public void test3() {
		test = extent.createTest("Veryfing Add Money feature within a given Limit ", "Testing Add Money Feature ");
		AddMoneyPage addMoneyPage = new AddMoneyPage(driver);
		if(logined) {
		test.info("User logined successfully !");
		test.info("AddMoney Page is Avialable");
		addMoneyPage.clickenterAmount();

		WebElement amount = driver.findElement(By.className("form-control"));

		amount.sendKeys("6000");

		addMoneyPage.clickaddMoneyBtn();

		String actualStr = addMoneyPage.getStatusMesg();

		String expectedStr5 = "Your request for adding the money has been sent to the bank. You will be able to see the updated balance in your account once it has been approved by the Bank";

		try {
			assertEquals(expectedStr5, actualStr);
			String path = utils.getScreenShotOfElement(addMoneyPage.statusMesg);
			try {
				test.pass("your money add req has been sent !!",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			logger.info("your money add req has been sent  !!");
		}

		catch (AssertionError e) {
			test.fail("Error occured while fetching add money status ! ");
			logger.error("Error occured while fetching add money status !");
			Assert.assertTrue(false);
		}
		}
		else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
		}
	}

	@Test(priority = 4)
	public void test4() {
		test = extent.createTest("Test to Check user already requested for adding money !", "Testing Add Money Feature ");
		
		AddMoneyPage addMoneyPage = new AddMoneyPage(driver);
		
		if(logined) {
		test.info("User logined successfully !");
		test.info("AddMoney Page is Avialable");
		addMoneyPage.clickenterAmount();

		WebElement amount = driver.findElement(By.className("form-control"));

		amount.sendKeys("999");

		addMoneyPage.clickaddMoneyBtn();

		String actualStr = addMoneyPage.getStatusMesg();

		String expectedStr3 = "You have already requested for adding money. Once the bank approves your request, you can then add money to your account!";

		try {
			assertEquals(expectedStr3, actualStr);
			String path = utils.getScreenShotOfElement(addMoneyPage.statusMesg);
			try {
				test.pass("Already requested for add money!",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); 
			}
			logger.info("Already requested for add money !!");
		}

		catch (AssertionError e) {
			test.fail("Error occured while fetching add money status for already requested ! ");
			logger.error("Error occured while fetching add money status for already requested !");
			Assert.assertTrue(false);
		}
		
		}
		else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
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