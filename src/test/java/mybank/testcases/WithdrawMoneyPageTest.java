package mybank.testcases;

import java.io.IOException;
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
import mybank.pages.WithdrawMoneyPage;
import mybank.pages.AccSummSideNavBar;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class WithdrawMoneyPageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getName());
	boolean logined;

	@BeforeTest
	public void beforeTest() {

		logger.info("before suit log..");
		driver = utils.browserSetup();
		logger.warn("Browser just launched !");
	}
 
	@Test(priority = 1)
	public void requestAtmPageAvabilityTest() {
		test = extent.createTest("withdraw Money Page Test", "Testing withdraw Money Feature ");
		test.info("Browser launched successfully");

		WithdrawMoneyPage withdrawMoneyPage = new WithdrawMoneyPage(driver);

		logined = utils.userLogin("abc@gmail.com", "1234");

		if (logined) {
			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "http://localhost/mybank/Userdashboard.php#";

			try {
				assertEquals(expectedUrl, actualUrl);
				test.pass("Userdashboard page Avialable !");
				logger.info("Userdashboard page Avialable !!");
			}

			catch (AssertionError e) {
				System.out.println("Userdashboard page not Avialable ");
				test.fail("Userdashboard Not avialable ... ");
				logger.error("Userdashboard page not avialable !");
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

			accSummsideNavBar.clickwithdrawMoneyBtn();

			String actualUrl2 = driver.getCurrentUrl();
			String expectedUrl2 = "http://localhost/mybank/withdrawMoney.php";

			try {
				assertEquals(expectedUrl2, actualUrl2);
				test.pass("withdraw Money btn is working !");
				logger.info("withdraw Money page Avialable !!");
			}

			catch (AssertionError e) {
				System.out.println("withdraw Money page not Avialable ");
				test.fail("withdraw Money page Not avialable ... ");
				logger.error("Error occured with assert statement !");
			}

		}
	}

	@Test(priority = 2)
	public void Test2() {
		test = extent.createTest("Test to withdraw Money above given limit ", "Testing withdraw Money Feature ");

		if (logined) {
			test.info("Withdraw Money page is avialable !");

			WithdrawMoneyPage withdrawMoneyPage = new WithdrawMoneyPage(driver);

			withdrawMoneyPage.clickenterAmount();

			WebElement amount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));

			amount.sendKeys("93,000");

			withdrawMoneyPage.clickwithdrawMoneyBtn();

			String actualStr = withdrawMoneyPage.getStatusMesg();

			String expectedStr4 = "You cannot withdraw more than Rs.40,000";

			try {
				assertEquals(expectedStr4, actualStr);
				test.pass("cannot withdraw more than 40,000 !!");
				logger.info("cannot withdraw more than 40,000 !!");
			}

			catch (AssertionError e) {
				// System.out.println("Error occured while withdrawing more than 40k ! ");
				test.fail("Error occured while withdrawing more than 40k ! ");
				logger.error("Withdraw money limit exceed");
				Assert.assertTrue(false);  // capturing ss
				
			}
		} else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
		}
	}

	@Test(priority = 3)
	public void Test3() {
		test = extent.createTest("Test to withdraw Money with insufficient balance ! ",
				"Testing withdraw Money Feature ");
		if (logined) {
			test.info("Withdraw Money page is avialable !");

			WithdrawMoneyPage withdrawMoneyPage = new WithdrawMoneyPage(driver);

			withdrawMoneyPage.clickenterAmount();

			WebElement amount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));

			amount.sendKeys("30");

			withdrawMoneyPage.clickwithdrawMoneyBtn();

			String actualStr = withdrawMoneyPage.getStatusMesg();

			String expectedStr10 = "Don't have sufficient balance to withdraw money!";

			try {
				assertEquals(expectedStr10, actualStr);
				test.pass("Not sufficient balance for withdraw money!");
				logger.info("Not sufficient balance for withdraw money !!");
			}

			catch (AssertionError e) {
				// System.out.println("Error occured while fetching add money status ! ");
				test.fail("Has sufficient balance,request sent for withdraw ! ");
				logger.error("Has sufficient balance,request sent for withdraw !");
				Assert.assertTrue(false); // caturing ss
			}
		} else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
		}
	}

	@Test(priority = 4)
	public void Test4() {
		test = extent.createTest("Test to withdraw Money within given limit ", "Testing withdraw Money Feature ");
		if (logined) {
			test.info("Withdraw Money page is avialable !");
			WithdrawMoneyPage withdrawMoneyPage = new WithdrawMoneyPage(driver);

			withdrawMoneyPage.clickenterAmount();

			WebElement amount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));

			amount.sendKeys("30");

			withdrawMoneyPage.clickwithdrawMoneyBtn();

			String actualStr = withdrawMoneyPage.getStatusMesg();

			String expectedStr5 = "Your request for withdrawing the money has been sent to the bank. You will be able to see the updated balance in your account once it has been approved by the Bank";

			try {
				assertEquals(expectedStr5, actualStr);
				test.pass("your money withdraw req has been sent !!");
				logger.info("your money withdraw req has been sent  !!");
			}

			catch (AssertionError e) {
				// System.out.println("Error occured while fetching add money status ! ");
				test.fail("Error occured while sending withdraw money req ! ");
				logger.error("Error occured while sending withdraw money req !");
				Assert.assertTrue(false); // capturing ss
			}
		} else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
			Assert.assertTrue(logined);
		}
	}

	@Test(priority = 5)
	public void Test5() {
		test = extent.createTest("Test to withdraw Money with a pending withdraw request ",
				"Testing withdraw Money Feature ");
		if (logined) {
			test.info("Withdraw Money page is avialable !");
			WithdrawMoneyPage withdrawMoneyPage = new WithdrawMoneyPage(driver);

			withdrawMoneyPage.clickenterAmount();

			WebElement amount = driver.findElement(By.xpath("//input[@placeholder='Enter Amount']"));

			amount.sendKeys("3,00");

			withdrawMoneyPage.clickwithdrawMoneyBtn();

			String actualStr = withdrawMoneyPage.getStatusMesg();

			String expectedStr3 = "You have already requested for withdrawing/transferring money. Once the bank approves your request, you can then withdraw money from your account! Please check the history or requests made to the bank.";

			try {
				assertEquals(expectedStr3, actualStr);
				test.pass("Already requested for withdraw money!");
				logger.info("Already requested for withdraw money !!");
			}

			catch (AssertionError e) {
				// System.out.println("Error occured while fetching add money status ! ");
				test.fail("Error occured while requesting for withdraw, already requested ! ");
				logger.error("Error occured while requesting for withdraw, already requested !");
			}
		} else {
			test.fail("Error occured.. Login Failed or Blocked User");
			logger.error("Error occured.. Login Failed or Blocked User");
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
	public void ShutDown() {
		driver.close();
		logger.info("All Done!");
	}
}
