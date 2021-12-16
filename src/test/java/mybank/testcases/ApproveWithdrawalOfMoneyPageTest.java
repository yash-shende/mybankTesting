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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import mybank.pages.AdminSideNavBar;
import mybank.pages.ApproveWithdrawalOfMoneyPage;

import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class ApproveWithdrawalOfMoneyPageTest extends BaseTest {

	static WebDriver driver = null;
	static Utilities utils = new Utilities();

	static Logger logger = utils.log4jSetup(AdminPageDDTest.class.getName());

	@BeforeTest
	public void beforeTest() {

		test = extent.createTest("Approve withdrawal of money Page Test",
				"Testing Approve withdrawal of money Feature ");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.info("Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test
	public void approveWithdrawalOfMoneyPageAvabilityTest() {

		AdminSideNavBar adminsideBar = new AdminSideNavBar(driver);
		ApproveWithdrawalOfMoneyPage approveWithdrawalOfMoneyPage = new ApproveWithdrawalOfMoneyPage(driver);
		SoftAssert soft = new SoftAssert();
		boolean logined = utils.AdminLogin("admin@gmail.com", "admin123");

		if (logined) {
			adminsideBar.approveWithdrawalBtn();

			String actualUrl = driver.getCurrentUrl();
			String expectedUrl = "http://localhost/mybank/adminWithMoney.php";

			try {
				assertEquals(expectedUrl, actualUrl);
				test.pass("Approve Withdrawal of Money Page Avialable !");
				logger.info("Approve withdrawal of Money Page Avialable !!");
			}

			catch (AssertionError e) {
				test.fail("Approve withdrawal of Money page Not avialable ... ");
				logger.error("Error occured with assert statement !");
			}

			int rows = approveWithdrawalOfMoneyPage.findTableElements();

			if (rows == 1) {
				test.warning("No Withdraw Requests for admin page available ! ");
				logger.error("No Withdraw Requests for admin page available ");
			} else {

				String id = approveWithdrawalOfMoneyPage.getcustomerCodeNo();

				approveWithdrawalOfMoneyPage.putUserId(id);
				approveWithdrawalOfMoneyPage.clickapproveWithdrawalMoneyBtn();
				String actualStatusMSg = approveWithdrawalOfMoneyPage.getnoReqstatus();
				String expectedStatusMSg = "No requests yet!!";
				soft.assertEquals(actualStatusMSg, expectedStatusMSg);
				test.pass("Withdraw Request accepted Succesfully! ");
				logger.info("Withdraw Request accepted Succesfully! ");
				soft.assertAll();
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
