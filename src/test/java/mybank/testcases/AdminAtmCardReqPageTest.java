package mybank.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.MediaEntityBuilder;

import mybank.pages.AdminAtmCardReqPage;
import mybank.pages.SideNavBar;
import mybank.utility.AdminData;
import mybank.utility.BaseTest;
import mybank.utility.UserData;
import mybank.utility.Utilities;

public class AdminAtmCardReqPageTest extends BaseTest {
	static WebDriver driver = null;
	static Utilities utils = new Utilities();
	Logger logger = utils.log4jSetup(this.getClass().getSimpleName());

	@BeforeTest
	public void beforeTest() {

		test = extent.createTest("Admin ATM Request Page Test", "Testing Admin ATM Card Requests Feature ");
		logger.info("before suit log..");
		driver = utils.browserSetup();
		test.info("Browser launched successfully");
		logger.warn("Browser just launched !");
	}

	@Test(dataProvider = "Dataset", dataProviderClass = AdminData.class)
	public void adminATMReqPageTest(String emailid, String password){
		String id = "", actualStatusMSg = "";
		SideNavBar sideBar = new SideNavBar(driver);
		AdminAtmCardReqPage adminAtmReqPage = new AdminAtmCardReqPage(driver);
		SoftAssert soft = new SoftAssert();

		utils.AdminLogin(emailid,password);

		sideBar.clickAdminAtmCardReq();

		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://localhost/mybank/adminATMapprove.php";
		System.out.println(actualUrl);
		try {
			assertEquals(expectedUrl, actualUrl);
			test.pass("Admin Atm Requests page Avialable !");
			logger.info("Admin Atm Request Avialable !!");
		}

		catch (AssertionError e) {
			test.error("Admin Atm Requests page is not Avialable ! ");
			logger.error("Error occured with assert statement !");
		}

		int Element1 = adminAtmReqPage.findTableElements();
		if (Element1 == 1) {
			test.warning("No ATM Requests for admin page available ! ");
			logger.error("No ATM Requests for admin page available ");
		} else {

			id = adminAtmReqPage.getUserId();
			System.out.print(id);
			adminAtmReqPage.putUserId(id);
			adminAtmReqPage.clickAtmRequestBtn();
			driver.switchTo().alert().accept();

			actualStatusMSg = adminAtmReqPage.getStatusMsg();
			String expectedStatusMSg = "No requests yet!!";
			soft.assertEquals(actualStatusMSg, expectedStatusMSg);
			System.out.print(actualStatusMSg + "" + expectedStatusMSg);
			test.error("ATM Request accepted Succesfully! ");
			logger.error("ATM Request accepted Succesfully! ");
			soft.assertAll();
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
