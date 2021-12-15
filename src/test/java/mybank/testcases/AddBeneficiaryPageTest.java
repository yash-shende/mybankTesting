package mybank.testcases;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.opencsv.CSVReader;
import mybank.pages.AddBeneficiaryPage;
import mybank.pages.SideNavBar;
import mybank.utility.BaseTest;
import mybank.utility.Utilities;

public class AddBeneficiaryPageTest extends BaseTest {

	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getName());
	CSVReader beneficiaries;
	String decodePass;

	@BeforeTest
	public void beforeTest() {
		driver = utils.browserSetup();
		logger.info("Browser Launched Successfully");
	}

	@Test(priority = 1)
	public void addBeneficiaryTest() throws IOException, InterruptedException {
		test = extent.createTest("Add Beneficiary Page Test", "Testing Adding Beneficiary Feature ");
		test.info("Browser launched successfully");
 
		AddBeneficiaryPage addBeneficiaryPage = new AddBeneficiaryPage(driver);
		SideNavBar sideBar = new SideNavBar(driver);
		SoftAssert soft = new SoftAssert();

		ArrayList<String[]> rows = utils.CSVReader("beneficiary.csv");

		boolean logined = utils.userLogin("abc@gmail.com", "1234");
		if (logined) {

			sideBar.clickAddBeneficiary();

			for (String[] row : rows) {
				addBeneficiaryPage.enterAccNumber(row[0]);
				addBeneficiaryPage.enterAccHolderName(row[1]);
				addBeneficiaryPage.enterBankName(row[2]);
				addBeneficiaryPage.enterBranchName(row[3]);
				addBeneficiaryPage.enterIfsc(row[4]);
				addBeneficiaryPage.clickAddBeneficiaryBtn();
				Thread.sleep(4000);
				String expectedStatusMsg = "Beneficiary added successfully!!";
				String actualStatusMsg = addBeneficiaryPage.getStatusMsg();
				System.out.println(actualStatusMsg);
				if (expectedStatusMsg.equalsIgnoreCase(actualStatusMsg)) {
					soft.assertEquals(actualStatusMsg, expectedStatusMsg);
					logger.info("Beneficiary Added Successfully !");
					test.pass("Beneficiary Added Successfully !");
				} else {
					logger.info("invalid credientials.. Beneficiary not added !");
					test.warning("invalid credientials.. Beneficiary not added !");

				}
			}
			test.info("Browser Closed Successfully");
			soft.assertAll();
		} else {
			test.warning("Logined Failed...");
			Assert.assertTrue(logined);
		}

	}

	@Test(priority = 2)
	public void invalidCredentialsTest() throws IOException {

		AddBeneficiaryPage addBeneficiaryPage = new AddBeneficiaryPage(driver);
		SideNavBar sideBar = new SideNavBar(driver);

		test = extent.createTest("Invalid Credentials Test",
				"Testing Adding Beneficiary button is disabled on entering Invalid account number ");
		test.info("Browser launched successfully");
		String invalidAccNumber = "78906543214";

		boolean logined = utils.userLogin("abc@gmail.com", "1234");

		if (logined) {
			sideBar.clickAddBeneficiary();
			addBeneficiaryPage.enterAccNumber(invalidAccNumber);
			
			driver.findElement(By.xpath("//body")).click();
			driver.switchTo().alert().accept();
			
			if (addBeneficiaryPage.getSubmitBtnStatus()) {
				System.out.println("Submint Button enabled !!");
				logger.warn("Submint Button is Enabled");
				test.warning("Valid Account Number Entered !");
				test.pass("Submint Button is Enabled");
			} else {
				String path = utils.getScreenShotOfElement(addBeneficiaryPage.addBeneficiaryBtn);
				System.out.println("Submit Button is disabled");
				logger.info("Submit Button is disabled");
				test.warning("Invalid Account Number Entered !");
				test.pass("Submit Button is disabled",MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			}

		} else {
			test.warning("Logined Failed...");
			Assert.assertTrue(logined, "Logined Failed");

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
	public void afterTest() {
		driver.close();
		driver.quit();
		logger.info("Browser Closed Successfully");
	}

}
